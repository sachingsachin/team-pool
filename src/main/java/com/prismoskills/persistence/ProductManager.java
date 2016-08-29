package com.prismoskills.persistence;

import java.util.List;

public class ProductManager extends BaseManager<ProductEntity> {

    private static ProductManager INSTANCE = new ProductManager();

    private ProductManager() {
        super(ProductEntity.class, qproductEntity);
    }

    public static ProductManager get() {
        return INSTANCE;
    }

    public List<ProductEntity> selectStar() {
        return em.createQuery("FROM Products").getResultList();
    }
}
