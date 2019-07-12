package com.danielaraujos.previsaotempo.controller;

import com.danielaraujos.previsaotempo.dao.PrevisaoAtualDao;
import com.danielaraujos.previsaotempo.model.sankhya.PrevisaoAtual;
import com.danielaraujos.previsaotempo.provider.JPAUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Date;
import java.util.List;

/**
 * Classe responsável por gerenciar a controller Previsão Climática Atual.
 *
 * @author Daniel Araújo
 */
public class PrevisaoAtualController {

    private static Logger logger = Logger.getLogger(PrevisaoAtualController.class);

    /**
     * Método responsavel por listar todas previsões atuais lançadas no sistema
     *
     * @return List - Retornar uma lista de todas previsões que foram lançadas dentro do sistema Sankhya
     **/

    public List<PrevisaoAtual> getTodasPrevisoesAtuais() {

        EntityManager entityManager = new JPAUtil().getEntityManager();
        List<PrevisaoAtual> previsaoAtuals = null;
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            PrevisaoAtualDao previsaoAtualDao = new PrevisaoAtualDao(entityManager);
            previsaoAtuals = previsaoAtualDao.getTodasPrevisoesAtuais();

            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        } finally {
            entityManager.close();
        }
        return previsaoAtuals;
    }


    /**
     * Método responsável pela inserção das previsões atuais no sistema
     *
     * @param codcid            Código da Cidade
     * @param temperatura       Temperatuda da Cidade
     * @param direcao_ventos    Direções dos Ventos
     * @param velocidade_ventos Velocidade dos Ventos
     * @param umidade           Umidade do ar
     * @param condicao          Texto explicando as condições do dia
     * @param pressao           Pressão do ar
     * @param icone             Icone responsavel pela visualização
     * @param sensacao          Sensação Termica para o dia
     * @param data              Data da previsão
     * @author Daniel Araújo
     */

    public void inserirPrevisaoAtual(Integer codcid, double temperatura, String direcao_ventos,
                                     double velocidade_ventos, double umidade,
                                     String condicao, double pressao, String icone, double sensacao, Date data) {
        EntityManager entityManager = new JPAUtil().getEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            PrevisaoAtualDao previsaoAtualDao = new PrevisaoAtualDao(entityManager);

            PrevisaoAtual previsaoAtual = new PrevisaoAtual(previsaoAtualDao.incrementarId(),
                    codcid, temperatura, direcao_ventos, velocidade_ventos, umidade,
                    condicao, pressao, icone, sensacao, data);

            entityManager.persist(previsaoAtual);
            transaction.commit();

        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        }  finally {
            entityManager.close();
        }
    }

    /**
     * Método responsável por atualizar as  previsões atuais no sistema
     *
     * @param codcid            Código da Cidade
     * @param temperatura       Temperatuda da Cidade
     * @param direcao_ventos    Direções dos Ventos
     * @param velocidade_ventos Velocidade dos Ventos
     * @param umidade           Umidade do ar
     * @param condicao          Texto explicando as condições do dia
     * @param pressao           Pressão do ar
     * @param icone             Icone responsavel pela visualização
     * @param sensacao          Sensação Termica para o dia
     * @param data              Data da previsão
     * @param verifica          Data já convertida para string para fazer manipulações de verificações
     * @author Daniel Araújo
     */

    public void atualizaPrevisaoAtual(Integer codcid, double temperatura, String direcao_ventos,
                                      double velocidade_ventos, double umidade,
                                      String condicao, double pressao, String icone, double sensacao, Date data,
                                      String verifica) {

        EntityManager entityManager = new JPAUtil().getEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            PrevisaoAtualDao previsaoAtualDao = new PrevisaoAtualDao(entityManager);

            Integer integer = previsaoAtualDao.getId(verifica, codcid);

            PrevisaoAtual previsaoAtual = entityManager.find(PrevisaoAtual.class, integer);
            previsaoAtual.setData(data);
            previsaoAtual.setTemperatura(temperatura);
            previsaoAtual.setDirecao_ventos(direcao_ventos);
            previsaoAtual.setVelocidade_ventos(velocidade_ventos);
            previsaoAtual.setUmidade(umidade);
            previsaoAtual.setPressao(pressao);
            previsaoAtual.setCondicao(condicao);
            previsaoAtual.setSensacao(sensacao);
            previsaoAtual.setIcone(icone);

            entityManager.merge(previsaoAtual);
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
        PrevisaoAtualDao previsaoAtualDao = new PrevisaoAtualDao(entityManager);

        if (previsaoAtualDao.getId(data, codcid) == 0) bool = false;
        else bool = true;

        entityManager.getTransaction().commit();
        entityManager.close();

        return bool;
    }
}
