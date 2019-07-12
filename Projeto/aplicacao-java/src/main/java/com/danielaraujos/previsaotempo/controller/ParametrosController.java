package com.danielaraujos.previsaotempo.controller;

import com.danielaraujos.previsaotempo.dao.ParametrosDao;
import com.danielaraujos.previsaotempo.model.sankhya.Parametro;
import com.danielaraujos.previsaotempo.provider.JPAUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

/**
 * Classe responsável por gerenciar a controller Parametros
 *
 * @author Daniel Araújo
 */
public class ParametrosController {

    private static Logger logger = Logger.getLogger(ParametrosController.class);
    /**
     * Método responsável por pegar o Token do clima tempo dentro das preferencias do sankhya
     *
     * @author Daniel Araújo
     */
    public static Parametro getToken() {

        EntityManager entityManager = new JPAUtil().getEntityManager();
        EntityTransaction transaction = null;
        Parametro parametros = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            ParametrosDao dao = new ParametrosDao(entityManager);
            parametros = dao.getToken();

            transaction.commit();

            return parametros;
        } catch (
                HibernateException e) {
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }  finally {
            entityManager.close();
        }
        return parametros;
    }
}
