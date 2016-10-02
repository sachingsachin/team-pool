package com.prismoskills.persistence;

import java.util.List;

import com.mysema.query.jpa.impl.JPAQuery;

public class UserManager extends BaseManager<UserEntity> {

    private static UserManager INSTANCE = new UserManager();

    private UserManager() {
        super(UserEntity.class, quserEntity);
    }

    public static UserManager get() {
        return INSTANCE;
    }

    public List<UserEntity> selectStar() {
        return em.createQuery("FROM Users").getResultList();
    }

    public List<UserEntity> getByIds(List<String> ids) {
        return query(quserEntity.id.in(ids));
    }
}
