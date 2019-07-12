package com.danielaraujos.previsaotempo.dao;

import com.danielaraujos.previsaotempo.model.sankhya.PrevisaoAtual;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Classe responsável pela comunicação da classe Previsão Atual com a JPA
 *
 * @author Daniel Araújo
 */
public class PrevisaoAtualDao  {

    /**
     * Método responsavel por criar uma instancia do EntityManager
     *
     * @return EntityManager - Retornar uma instancia do EntityManager
     **/
    private EntityManager entityManager;

    /**
     * Construtor
     *
     * @param entityManager - Retornar uma instancia do EntityManager
     **/
    public PrevisaoAtualDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Método responsavel por criar a query para listagem das previsões lançadas
     *
     * @return List - Retornar uma lista de todas previsões que foram lançadas dentro do sistema Sankhya
     **/
    public List<PrevisaoAtual> getTodasPrevisoesAtuais() {
        String jpql = "select distinct p from PrevisaoAtual p ";
        Query query = entityManager.createQuery(jpql);
        return query.getResultList();
    }

    /**
     * Método responsavel por verificar o ultimo id inserido no sistema e incremeta-lo.
     *
     * @return Integer - Retorna o próximo id
     **/
    public Integer incrementarId() {
        String jpql = "select distinct nvl(max(p.cod_clima_atual),0)+1 from PrevisaoAtual p";
        Query query = entityManager.createQuery(jpql);
        return (Integer) query.getSingleResult();
    }

    /**
     * Método responsavel por checar se existe um id sobre os parametros passados.
     *
     * @param data   Data da previsão
     * @param cidade Cidade
     * @return Integer - Retorna o id do resultado buscado, caso não encontre receberá 0
     **/
    public Integer getId(String data, Integer cidade) {
        String jpql = "select p.cod_clima_atual from PrevisaoAtual p where trunc(p.data) = TO_DATE('" + data + "', 'YYYY-MM-DD') AND p.codcid = :pCidade";
        DaoGenerico daoGenerico = new DaoGenerico(entityManager);
        return daoGenerico.returnID(jpql,data,cidade);
    }
}
