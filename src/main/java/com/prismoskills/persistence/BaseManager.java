package com.prismoskills.persistence;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.codahale.metrics.Timer;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Predicate;
import com.mysema.query.types.path.EntityPathBase;
import com.prismoskills.util.Globals;

public class BaseManager<Entity extends BaseEntity> {

    private Logger logger = LoggerFactory.getLogger(BaseManager.class);

    // Hibernate and Query-DSL members
    protected EntityManagerFactory emf;
    protected EntityManager em;
    protected Class<Entity> entityClass;
    protected EntityPathBase<Entity> qpath;

    // Metrics
    private final Timer requestTimes;

    // Qpaths of all the entities for easy reference in all the derived classes
    public static QUserEntity quserEntity = QUserEntity.userEntity;
    public static QProductEntity qproductEntity = QProductEntity.productEntity;
    public static QTeamEntity qteamEntity = QTeamEntity.teamEntity;
    public static QUserProductMappingEntity quserProductMappingEntity = QUserProductMappingEntity.userProductMappingEntity;
    public static QProductTeamMappingEntity qproductTeamMappingEntity = QProductTeamMappingEntity.productTeamMappingEntity;

    protected BaseManager (Class<Entity> entityClass, EntityPathBase<Entity> qpath) {
        this.emf = Persistence.createEntityManagerFactory("teamwork");
        this.em = emf.createEntityManager();
        this.entityClass = entityClass;
        this.qpath = qpath;
        this.requestTimes = Globals.metrics.timer("DB." + entityClass.getSimpleName());
    }

    protected WrapperEM createEntityManager() {
        Timer.Context timerContext = requestTimes.time();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        return new WrapperEM(em, tx, timerContext);
    }

    protected void closeEntityManager(WrapperEM wem) {
        wem.em.flush();
        wem.tx.commit();
        wem.em.close();
        wem.timerContext.stop();
    }

    public Entity generateIdForNewEntities(Entity e) {
        if (e.getId() == null) {
            e.setId(UUID.randomUUID().toString());
        }
        return e;
    }

    public Entity put(Entity e) {
        WrapperEM wem = createEntityManager();
        e = generateIdForNewEntities(e);
        Entity mergedE = wem.em.merge(e);
        closeEntityManager(wem);
        return mergedE;
    }

    public Entity getById(String id) {
        WrapperEM wem = createEntityManager();
        Entity entity = wem.em.find(entityClass, id);
        closeEntityManager(wem);
        return entity;
    }

    public List<Entity> query(Predicate where) {
        WrapperEM wem = createEntityManager();

        JPAQuery query = new JPAQuery(wem.em);
        List<Entity> results = query.from(qpath)
                .where(where)
                .fetchAll().list(qpath);

        closeEntityManager(wem);
        return results;
    }

    public Entity deleteById(String id) {
        WrapperEM wem = createEntityManager();
        Entity entity = wem.em.find(entityClass, id);
        if (entity != null) {
            wem.em.remove(entity);
        }
        closeEntityManager(wem);
        return entity;
    }

    public void deleteAll(Object [] entities) {
        WrapperEM wem = createEntityManager();
        try {
            for (Object e: entities) {
                Entity entity = wem.em.find(entityClass, ((Entity)e).getId());
                if (entity != null) {
                    wem.em.remove(entity);
                }
            }
        } catch (Exception e) {
            logger.error("Exception while deleting", e);
        } finally {
            closeEntityManager(wem);
        }
    }
}
