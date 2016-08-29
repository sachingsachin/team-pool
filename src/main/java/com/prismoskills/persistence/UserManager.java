package com.prismoskills.persistence;

import java.util.List;

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
}
