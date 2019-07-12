package com.danielaraujos.previsaotempo.dao;


import com.danielaraujos.previsaotempo.model.sankhya.Parametro;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ParametrosDao {
    private EntityManager entityManager;

    public ParametrosDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public Parametro getToken(){
        String jpql = "select distinct p from Parametro p WHERE p.chave = :pChave";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("pChave","TOKENCLIMA");
        return (Parametro) query.getSingleResult();
    }

}
