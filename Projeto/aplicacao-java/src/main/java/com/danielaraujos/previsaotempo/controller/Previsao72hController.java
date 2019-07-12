package com.danielaraujos.previsaotempo.controller;

import com.danielaraujos.previsaotempo.dao.Previsao72hDao;
import com.danielaraujos.previsaotempo.model.sankhya.Previsao72h;
import com.danielaraujos.previsaotempo.provider.JPAUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Date;

/**
 * Classe responsável por gerenciar a controller Previsão para as proximas 72 horas
 *
 * @author Daniel Araújo
 */
public class Previsao72hController {

    private static Logger logger = Logger.getLogger(Previsao72hController.class);

    /**
     * Método responsável pela inserção das previsões para as proximas 72 horas no sistema
     *
     * @param codcid              Código da Cidade
     * @param temperatura         Temperatuda da Cidade
     * @param precipitacao_chuva  Precipitação em milímetro.
     * @param velocidade_vento    Velocidade dos Ventos
     * @param direcao_vento       Direção do vento
     * @param direcao_vento_graus Direção dos ventos em graus
     * @param rajada_vento        Rajada do vento em km/h.
     * @param data                Data da previsão
     * @author Daniel Araújo
     */
    public void inserirPrevisao72h(Integer codcid, Date data, double precipitacao_chuva,
                                   double velocidade_vento, String direcao_vento,
                                   double direcao_vento_graus, double rajada_vento, double temperatura) {

        EntityManager entityManager = new JPAUtil().getEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            Previsao72hDao previsao72hDao = new Previsao72hDao(entityManager);

            Previsao72h previsao72h = new Previsao72h(
                    previsao72hDao.incrementarId(), codcid, data, precipitacao_chuva,
                    velocidade_vento, direcao_vento, direcao_vento_graus, rajada_vento, temperatura);

            entityManager.persist(previsao72h);
            transaction.commit();
        } catch (
                HibernateException e) {
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }  finally {
            entityManager.close();
        }

    }


    /**
     * Método responsável pela atualização das previsões para as proximas 72 horas no sistema
     *
     * @param codcid              Código da Cidade
     * @param dataString          Data em String
     * @param temperatura         Temperatuda da Cidade
     * @param precipitacao_chuva  Precipitação em milímetro.
     * @param velocidade_vento    Velocidade dos Ventos
     * @param direcao_vento       Direção do vento
     * @param direcao_vento_graus Direção dos ventos em graus
     * @param rajada_vento        Rajada do vento em km/h.
     * @author Daniel Araújo
     */
    public void atualizarPrevisao72h(Integer codcid, String dataString, double precipitacao_chuva,
                                     double velocidade_vento, String direcao_vento,
                                     double direcao_vento_graus, double rajada_vento, double temperatura) {

        EntityManager entityManager = new JPAUtil().getEntityManager();

        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            Previsao72hDao previsao72hDao = new Previsao72hDao(entityManager);

            Integer integer = previsao72hDao.getId(dataString, codcid);

            Previsao72h previsao72h = entityManager.find(Previsao72h.class, integer);
            previsao72h.setDirecao_vento(direcao_vento);
            previsao72h.setDirecao_vento_graus(direcao_vento_graus);
            previsao72h.setPrecipitacao_chuva(precipitacao_chuva);
            previsao72h.setRajada_vento(rajada_vento);
            previsao72h.setTemperatura(temperatura);
            previsao72h.setVelocidade_vento(velocidade_vento);

            entityManager.merge(previsao72h);

            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        } finally {
            entityManager.close();
        }
    }

    /**
     * Método responsável por verificar se existe aquele lançamento no sankhya
     *
     * @param data   Temperatuda da Cidade
     * @param codcid Código da Cidade
     * @return Boolean - Se existe ou não a informação
     * @author Daniel Araújo
     */
    public Boolean jaExisteInformacao(String data, Integer codcid) {

        EntityManager entityManager = new JPAUtil().getEntityManager();
        entityManager.getTransaction().begin();

        Boolean bool;
        Previsao72hDao previsao72hDao = new Previsao72hDao(entityManager);

        if (previsao72hDao.getId(data, codcid) == 0) bool = false;
        else bool = true;

        entityManager.getTransaction().commit();
        entityManager.close();

        return bool;
    }
}
