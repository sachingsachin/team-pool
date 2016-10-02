package com.prismoskills.persistence;

import java.util.List;

import com.mysema.query.jpa.impl.JPAQuery;

public class UserProductMappingManager extends BaseManager<UserProductMappingEntity> {

    private static UserProductMappingManager INSTANCE = new UserProductMappingManager();

    private UserProductMappingManager() {
        super(UserProductMappingEntity.class, quserProductMappingEntity);
    }

    public static UserProductMappingManager get() {
        return INSTANCE;
    }

    public List<UserProductMappingEntity> selectStar() {
        return em.createQuery("FROM User_Product_Mapping").getResultList();
    }

    public List<UserProductMappingEntity> withProductId(String pid) {
        if (pid == null || pid.length() == 0)
            return null;

        WrapperEM wem = createEntityManager();

        JPAQuery query = new JPAQuery(wem.em);
        List<UserProductMappingEntity> results = query.from(quserProductMappingEntity)
                .where(quserProductMappingEntity.productId.eq(pid))
                .fetchAll().list(quserProductMappingEntity);

        closeEntityManager(wem);
        return results;
    }
}
