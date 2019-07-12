package com.danielaraujos.previsaotempo.controller;

import com.danielaraujos.previsaotempo.dao.ChuvaClimaticaDao;
import com.danielaraujos.previsaotempo.model.sankhya.ChuvaClimatica;
import com.danielaraujos.previsaotempo.provider.JPAUtil;

import javax.persistence.EntityManager;
import java.util.Date;

public class ChuvaClimaticaController {

    public void inserirChuvaClimatica(Integer codcid, Date data, double chuva_anterior,
                                      double media_chuva, double previsao_chuva){

        EntityManager entityManager = new JPAUtil().getEntityManager();
        entityManager.getTransaction().begin();

        ChuvaClimaticaDao chuvaClimaticaDao = new ChuvaClimaticaDao(entityManager);

        ChuvaClimatica chuvaClimatica = new ChuvaClimatica(
                chuvaClimaticaDao.incrementarId(),codcid, data,chuva_anterior,media_chuva,previsao_chuva);

        entityManager.persist(chuvaClimatica);
        entityManager.getTransaction().commit();
        entityManager.close();

    }


}
