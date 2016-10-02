package com.prismoskills.persistence;

import java.util.List;

import com.mysema.query.jpa.impl.JPAQuery;

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

    public ProductEntity getByName(String name) {
        WrapperEM wem = createEntityManager();

        JPAQuery answerQuery = new JPAQuery(wem.em);
        List<ProductEntity> products = answerQuery.from(qproductEntity)
                .where(qproductEntity.name.eq(name))
                .fetchAll()
                .list(qproductEntity);


        closeEntityManager(wem);
        return (products==null || products.isEmpty())?null:products.get(0);
    }
}
