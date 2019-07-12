package com.danielaraujos.previsaotempo.dao;

import com.danielaraujos.previsaotempo.model.sankhya.Cidade;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

public class CidadeDao {
    private EntityManager entityManager;

    public CidadeDao(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    public Integer getCodigoCidade(Integer codCidade) {

        String jpql = "select c.cod_clima from Cidade c WHERE c.codcid = :pCodCidade";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("pCodCidade",codCidade);

        return (Integer) query.getSingleResult();
    }


    public List<Cidade> getCidadesMarcadas() {

        String jpql = "select distinct c from Cidade c where c.mapeado is not null and c.mapeado = 'S' ";
        Query query = entityManager.createQuery(jpql);

        return query.getResultList();
    }


    public List<Cidade> getEncontrarCidadePeloEstado(String estado) {

        String jpql = "select distinct e.cidades from Estado e where e.uf = :pEstado";
        Query query = entityManager.createQuery(jpql);
        query.setParameter("pEstado", estado);

        return query.getResultList();
    }


    public Integer getCidadeParaComparar(String nome, String sigla) {

        String jpql = "select distinct nvl(c.codcid,0) from Cidade c left join c.estado p where p.uf = :pEstado and c.codcid <> 0 and c.nomecid like UPPER(:pNome) and c.cod_clima is null";
        TypedQuery<Integer> typedQuery = entityManager.createQuery(jpql, Integer.class);
        typedQuery.setParameter("pEstado", sigla);
        typedQuery.setParameter("pNome", nome);

        try{
            return typedQuery.getSingleResult();
        }catch (NoResultException nre){
            return 0;
        }
    }
}
