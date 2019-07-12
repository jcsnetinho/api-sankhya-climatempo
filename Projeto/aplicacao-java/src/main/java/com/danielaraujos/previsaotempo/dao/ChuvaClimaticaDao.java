package com.danielaraujos.previsaotempo.dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ChuvaClimaticaDao {
    private EntityManager entityManager;

    public ChuvaClimaticaDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public Integer incrementarId(){
        String jpql = "select distinct nvl(max(c.cod_chuva_climatica),0)+1 from ChuvaClimatica c";
        Query query = entityManager.createQuery(jpql);
        return (Integer) query.getSingleResult();
    }
}
