package com.danielaraujos.previsaotempo.dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

public class DaoGenerico {

    private EntityManager entityManager;

    public DaoGenerico(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public Integer returnID(String jpql, String data, Integer cidade){
        TypedQuery<Integer> typedQuery = entityManager.createQuery(jpql, Integer.class);
        typedQuery.setParameter("pCidade", cidade);
        try {
            return typedQuery.getSingleResult();
        } catch (NoResultException nre) {
            return 0;
        }
    }
}
