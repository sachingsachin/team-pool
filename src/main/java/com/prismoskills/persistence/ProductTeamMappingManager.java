package com.prismoskills.persistence;

import java.util.List;

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
}
