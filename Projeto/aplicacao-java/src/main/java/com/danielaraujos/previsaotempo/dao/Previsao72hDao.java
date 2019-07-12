package com.danielaraujos.previsaotempo.dao;

import com.danielaraujos.previsaotempo.model.sankhya.Previsao72h;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Classe responsável pela comunicação da classe Previsão das proximas 72 Horas com a JPA
 *
 * @author Daniel Araújo
 */
public class Previsao72hDao {

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
    public Previsao72hDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Método responsavel por criar a query para listagem das previsões lançadas
     *
     * @return List - Retornar uma lista de todas previsões que foram lançadas dentro do sistema Sankhya
     **/
    public List<Previsao72h> getTodasPrevisoes72h() {
        String jpql = "select distinct p from Previsao72h p ";
        Query query = entityManager.createQuery(jpql);
        return query.getResultList();
    }

    /**
     * Método responsavel por verificar o ultimo id inserido no sistema e incremeta-lo.
     *
     * @return Integer - Retorna o próximo id
     **/
    public Integer incrementarId() {
        String jpql = "select distinct nvl(max(p.cod_clima_72),0)+1 from Previsao72h p";
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
        String jpql = "select p.cod_clima_72 from Previsao72h p where p.data = TO_DATE('" + data + "', 'YYYY-MM-DD:HH24:MI:SS') AND p.codcid = :pCidade";
        DaoGenerico daoGenerico = new DaoGenerico(entityManager);
        return daoGenerico.returnID(jpql,data,cidade);
    }
}
