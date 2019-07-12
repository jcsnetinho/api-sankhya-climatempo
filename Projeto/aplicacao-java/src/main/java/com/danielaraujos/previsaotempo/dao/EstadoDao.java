package com.danielaraujos.previsaotempo.dao;

import com.danielaraujos.previsaotempo.model.sankhya.Estado;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EstadoDao {

    private EntityManager entityManager;

    public EstadoDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public List<Estado> getEstados() {

        String jpql = "select distinct e from Estado e  order by e.uf";
        Query query = entityManager.createQuery(jpql);

        return query.getResultList();
    }
}
