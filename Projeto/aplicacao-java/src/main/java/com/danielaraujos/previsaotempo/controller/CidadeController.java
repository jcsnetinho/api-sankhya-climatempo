package com.danielaraujos.previsaotempo.controller;

import com.danielaraujos.previsaotempo.dao.CidadeDao;
import com.danielaraujos.previsaotempo.model.sankhya.Cidade;
import com.danielaraujos.previsaotempo.provider.JPAUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

/**
 * Classe responsável por gerenciar a controller Cidade
 *
 * @author Daniel Araújo
 */
public class CidadeController {

    private static Logger logger = Logger.getLogger(CidadeController.class);
    /**
     * Método responsável pela leitura do codigo da cidade do clima tempo dentro do sankhya
     *
     * @param codCidade Código da Cidade
     * @return Integer - Retornar o código da cidade
     * @author Daniel Araújo
     */
    public Integer getCodigoCidade(Integer codCidade) {
        EntityManager entityManager = new JPAUtil().getEntityManager();
        EntityTransaction transaction = null;
        Integer codCid = null;

        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            CidadeDao dao = new CidadeDao(entityManager);
            codCid = dao.getCodigoCidade(codCidade);
            transaction.commit();
            return codCid;
        } catch (
                HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println(e.getMessage());

        } finally {
            entityManager.close();
        }

        return codCid;
    }

    /**
     * Método responsável por identificar todas as cidades com id mapeados
     * desta forma, será feito as requisições, somente pelas cidades selecionadas
     *
     * @return List - Retorna uma lista de cidades
     * @author Daniel Araújo
     */
    public List<Cidade> getCidadesMarcadas() {

        EntityManager entityManager = new JPAUtil().getEntityManager();
        EntityTransaction transaction = null;
        List<Cidade> cidadeList = null;

        try{
            transaction = entityManager.getTransaction();
            transaction.begin();
            CidadeDao dao = new CidadeDao(entityManager);
            cidadeList = dao.getCidadesMarcadas();
            transaction.commit();
            return cidadeList;
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }

        return cidadeList;
    }


    /**
     * Método responsável por encontrar a cidade pelo estado
     * @param estado - Sigla do Estado
     * @return List - Retorna uma lista de cidades
     * @author Daniel Araújo
     */
    public List<Cidade> getEncontrarCidadePeloEstado(String estado) {

        EntityManager entityManager = new JPAUtil().getEntityManager();
        EntityTransaction transaction = null;
        List<Cidade> cidadeList = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            CidadeDao dao = new CidadeDao(entityManager);
            cidadeList = dao.getEncontrarCidadePeloEstado(estado);
            transaction.commit();
            return cidadeList;
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }
        return cidadeList;
    }

    /**
     * Método responsável por comparar Cidades para pegar o id da cidade no clima tempo
     * @param codcid - Código da Cidade
     * @param nome - Nome da Cidade
     * @param sigla - Sigla do estado
     * @return String - Retorna um ponto final ou de esclamação para mostrar o resultado no console.
     * @author Daniel Araújo
     */
    public String getCompararCidade(Integer codcid, String nome, String sigla) {
        EntityManager entityManager = new JPAUtil().getEntityManager();
        EntityTransaction transaction = null;
        String ponto = "";

        try{
            transaction = entityManager.getTransaction();
            transaction.begin();

            CidadeDao dao = new CidadeDao(entityManager);
            Integer iCodCidade = dao.getCidadeParaComparar(nome, sigla);

            if (iCodCidade != 0) {
                Cidade cidade = entityManager.find(Cidade.class, iCodCidade);
                cidade.setCod_clima(codcid);
                System.out.println("Codigo da Cidade Sankhya: " + iCodCidade + " Codigo da Cidade Clima Tempo: " + codcid + " Nome da cidade:" + nome + " Estado: " + sigla);
                ponto = ".";

            } else {
                ponto = "!";
            }
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            System.out.println(e.getMessage());
        } finally {
            entityManager.close();
        }
        return ponto;
    }
}
