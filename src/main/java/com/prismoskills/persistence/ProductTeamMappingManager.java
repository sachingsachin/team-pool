package com.prismoskills.persistence;

import java.util.List;

import com.mysema.query.jpa.impl.JPAQuery;

public class ProductTeamMappingManager extends BaseManager<ProductTeamMappingEntity> {

    private static ProductTeamMappingManager INSTANCE = new ProductTeamMappingManager();

    private ProductTeamMappingManager() {
        super(ProductTeamMappingEntity.class, qproductTeamMappingEntity);
    }

    public static ProductTeamMappingManager get() {
        return INSTANCE;
    }

    public List<ProductTeamMappingEntity> selectStar() {
        return em.createQuery("FROM Product_Team_Mapping").getResultList();
    }

    public List<ProductTeamMappingEntity> withProductId(String pid) {
        if (pid == null || pid.length() == 0)
            return null;

        WrapperEM wem = createEntityManager();

        JPAQuery query = new JPAQuery(wem.em);
        List<ProductTeamMappingEntity> results = query.from(qproductTeamMappingEntity)
                .where(qproductTeamMappingEntity.productId.eq(pid))
                .fetchAll().list(qproductTeamMappingEntity);

        closeEntityManager(wem);
        return results;
    }
}
