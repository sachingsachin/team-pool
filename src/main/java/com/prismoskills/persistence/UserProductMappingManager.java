package com.prismoskills.persistence;

import java.util.List;

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
}
