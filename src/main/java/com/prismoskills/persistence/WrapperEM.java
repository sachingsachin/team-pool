package com.prismoskills.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.codahale.metrics.Timer;

public class WrapperEM {
    protected final EntityManager em;
    protected final EntityTransaction tx;
    protected final Timer.Context timerContext;

    public WrapperEM(EntityManager em, EntityTransaction tx, Timer.Context timerContext) {
        this.em = em;
        this.tx = tx;
        this.timerContext = timerContext;
    }
}
