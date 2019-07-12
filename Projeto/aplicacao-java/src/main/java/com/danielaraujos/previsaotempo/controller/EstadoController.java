package com.danielaraujos.previsaotempo.controller;

import com.danielaraujos.previsaotempo.dao.EstadoDao;
import com.danielaraujos.previsaotempo.model.sankhya.Estado;
import com.danielaraujos.previsaotempo.provider.JPAUtil;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Classe responsável por gerenciar a controller Estado
 *
 * @author Daniel Araújo
 */
public class EstadoController {

    /**
     * Método responsável pela leitura de todos os estados cadastrados no sankhya
     * * @return Lista - Retornar uma lista de Estados
     *
     * @author Daniel Araújo
     */
    public List<Estado> getEstado() {

        EntityManager entityManager = new JPAUtil().getEntityManager();
        EntityTransaction transaction = null;
        List<Estado> estadoList = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            EstadoDao dao = new EstadoDao(entityManager);
            estadoList = dao.getEstados();
            transaction.commit();
            return estadoList;
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }

        return estadoList;
    }
}
