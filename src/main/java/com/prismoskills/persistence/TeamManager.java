package com.prismoskills.persistence;

import java.util.List;

public class TeamManager extends BaseManager<TeamEntity> {

    private static TeamManager INSTANCE = new TeamManager();

    private TeamManager() {
        super(TeamEntity.class, qteamEntity);
    }

    public static TeamManager get() {
        return INSTANCE;
    }

    public List<TeamEntity> selectStar() {
        return em.createQuery("FROM Teams").getResultList();
    }

    public List<TeamEntity> getByIds(List<String> ids) {
        return query(qteamEntity.id.in(ids));
    }
}
