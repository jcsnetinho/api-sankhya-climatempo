package com.danielaraujos.previsaotempo.controller;

import com.danielaraujos.previsaotempo.dao.Previsao15dDao;
import com.danielaraujos.previsaotempo.model.sankhya.Previsao15d;
import com.danielaraujos.previsaotempo.provider.JPAUtil;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;
import java.util.Date;


/**
 * Classe responsável por gerenciar a controller Previsão para os proximos 15 dias
 *
 * @author Daniel Araújo
 */
public class Previsao15dController {

    private static Logger logger = Logger.getLogger(Previsao15dController.class);

    /**
     * Método responsável pela inserção das previsões para os proximos 15 dias no sistema
     *
     * @param codcid                         Código da cidade
     * @param data                           Data no formato "aaaa-mm-dd" (Ex.: 2017-10-01).
     * @param humidade_min                   Umidade Relativa minima (%).
     * @param humidade_max                   Umidade Relativa máxima (%).
     * @param humidade_madrugada_min         Umidade Relativa minima madrugada (%).
     * @param humidade_madrugada_max         Umidade Relativa máxima madrugada (%).
     * @param humidade_manha_min             Umidade Relativa minima manhã (%).
     * @param humidade_manha_max             Umidade Relativa máxima manhã (%).
     * @param humidade_tarde_min             Umidade Relativa minima tarde (%).
     * @param humidade_tarde_max             Umidade Relativa máxima tarde (%).
     * @param humidade_noite_min             Umidade Relativa minima noite (%).
     * @param humidade_noite_max             Umidade Relativa máxima noite (%).
     * @param chuva_probabilidade            Probabilidade de chuva em porcentagem.
     * @param chuva_precipitacao             Precipitação em milímetro.
     * @param vento_velocidade_min           Intensidade minima do vento em km/h.
     * @param vento_velocidade_max           Intensidade máxima do vento em km/h.
     * @param vento_velocidade_media         Intensidade média do vento em km/h.
     * @param vento_rajada                   Rajada máxima do vento em km/h
     * @param vento_direcao_graus            Direção do vento em graus.
     * @param vento_direcao                  Direção do vento.
     * @param vento_madrugada_direcao_graus  Direção do vento madrugada em graus.
     * @param vento_madrugada_direcao        Direção do vento madrugada.
     * @param vento_madrugada_rajada         Rajada máxima do vento madrugada em km/h.
     * @param vento_madrugada_velocidade_max Intensidade máxima do vento madrugada em km/h.
     * @param vento_manha_direcao_graus      Direção do vento manhã em graus.
     * @param vento_manha_direcao            Direção do vento manhã.
     * @param vento_manha_rajada             Rajada máxima do vento manhã em km/h.
     * @param vento_manha_velocidade_max     Intensidade máxima do vento manhã em km/h.
     * @param vento_tarde_direcao_graus      Direção do vento tarde.
     * @param vento_tarde_direcao            Direção do vento tarde em graus.
     * @param vento_tarde_rajada             Rajada máxima do vento tarde em km/h.
     * @param vento_tarde_velocidade_max     Intensidade máxima do vento tarde em km/h.
     * @param vento_noite_direcao_graus      Direção do vento noite em graus.
     * @param vento_noite_direcao            Direção do vento noite.
     * @param vento_noite_rajada             Rajada máxima do vento noite em km/h.
     * @param vento_noite_velocidade_max     Intensidade máxima do vento noite em km/h.
     * @param uv                             Indice máximo de Radiação ultravioleta
     * @param sensacao_min                   Sensação termica miníma (°C).
     * @param sensacao_max                   Sensação termica máxima (°C).
     * @param icone_madrugada                Icone madrugada.
     * @param icone_manha                    Icone manhã.
     * @param icone_tarde                    Icone tarde.
     * @param icone_noite                    Icone noite.
     * @param icone_dia                      Icone dia inteiro.
     * @param texto_clima                    Texto de previsão em português.
     * @param texto_dia_todo                 Frase de previsão do dia inteiro reduzida.
     * @param texto_madrugada                Frase de previsão madrugada.
     * @param texto_manha                    Frase de previsão manhã.
     * @param texto_tarde                    Frase de previsão tarde.
     * @param texto_noite                    Frase de previsão noite.
     * @param temperatura_min                Temperatura minima em graus celsius.
     * @param temperatura_max                Temperatura máxima em graus celsius.
     * @param temperatura_madrugada_min      Temperatura minima madrugada em graus celsius.
     * @param temperatura_madrugada_max      Temperatura máxima madrugada em graus celsius.
     * @param temperatura_manha_min          Temperatura minima manhã em graus celsius.
     * @param temperatura_manha_max          Temperatura máxima manhã em graus celsius.
     * @param temperatura_tarde_min          Temperatura minima tarde em graus celsius.
     * @param temperatura_tarde_max          Temperatura máxima tarde em graus celsius.
     * @param temperatura_noite_min          Temperatura minima noite em graus celsius.
     * @param temperatura_noite_max          Temperatura máxima noite em graus celsius.
     * @author Daniel Araújo
     */
    public void inserirPrevisao15d(Integer codcid, Date data,
                                   double humidade_min, double humidade_max, double humidade_madrugada_min, double humidade_madrugada_max,
                                   double humidade_manha_min, double humidade_manha_max, double humidade_tarde_min, double humidade_tarde_max,
                                   double humidade_noite_min, double humidade_noite_max, double chuva_probabilidade, double chuva_precipitacao,
                                   double vento_velocidade_min, double vento_velocidade_max, double vento_velocidade_media, double vento_rajada,
                                   double vento_direcao_graus, String vento_direcao, double vento_madrugada_direcao_graus, String vento_madrugada_direcao,
                                   double vento_madrugada_rajada, double vento_madrugada_velocidade_max, double vento_manha_direcao_graus, String vento_manha_direcao,
                                   double vento_manha_rajada, double vento_manha_velocidade_max, double vento_tarde_direcao_graus, String vento_tarde_direcao,
                                   double vento_tarde_rajada, double vento_tarde_velocidade_max, double vento_noite_direcao_graus, String vento_noite_direcao,
                                   double vento_noite_rajada, double vento_noite_velocidade_max, double uv, double sensacao_min, double sensacao_max,
                                   String icone_madrugada, String icone_manha, String icone_tarde, String icone_noite, String icone_dia,
                                   String texto_clima, String texto_dia_todo, String texto_madrugada, String texto_manha, String texto_tarde, String texto_noite,
                                   double temperatura_min, double temperatura_max, double temperatura_madrugada_min, double temperatura_madrugada_max, double temperatura_manha_min,
                                   double temperatura_manha_max, double temperatura_tarde_min, double temperatura_tarde_max, double temperatura_noite_min, double temperatura_noite_max) {

        EntityManager entityManager = new JPAUtil().getEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            Previsao15dDao previsao15dDao = new Previsao15dDao(entityManager);

            Previsao15d previsao15d = new Previsao15d(previsao15dDao.incrementarId(),
                    codcid, data, humidade_min, humidade_max, humidade_madrugada_min, humidade_madrugada_max, humidade_manha_min,
                    humidade_manha_max, humidade_tarde_min, humidade_tarde_max, humidade_noite_min, humidade_noite_max,
                    chuva_probabilidade, chuva_precipitacao, vento_velocidade_min, vento_velocidade_max, vento_velocidade_media,
                    vento_rajada, vento_direcao_graus, vento_direcao, vento_madrugada_direcao_graus, vento_madrugada_direcao,
                    vento_madrugada_rajada, vento_madrugada_velocidade_max, vento_manha_direcao_graus, vento_manha_direcao,
                    vento_manha_rajada, vento_manha_velocidade_max, vento_tarde_direcao_graus, vento_tarde_direcao,
                    vento_tarde_rajada, vento_tarde_velocidade_max, vento_noite_direcao_graus, vento_noite_direcao,
                    vento_noite_rajada, vento_noite_velocidade_max, uv, sensacao_min, sensacao_max,
                    icone_madrugada, icone_manha, icone_tarde, icone_noite, icone_dia, texto_clima, texto_dia_todo, texto_madrugada,
                    texto_manha, texto_tarde, texto_noite, temperatura_min, temperatura_max, temperatura_madrugada_min,
                    temperatura_madrugada_max, temperatura_manha_min, temperatura_manha_max, temperatura_tarde_min, temperatura_tarde_max,
                    temperatura_noite_min, temperatura_noite_max);

            entityManager.persist(previsao15d);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        } finally {
            entityManager.close();
        }
    }


    /**
     * Método responsável pela atualização das previsões para os proximos 15 dias no sistema
     *
     * @param codcid                         Código da cidade
     * @param dataString                     Data no formato em String
     * @param humidade_min                   Umidade Relativa minima (%).
     * @param humidade_max                   Umidade Relativa máxima (%).
     * @param humidade_madrugada_min         Umidade Relativa minima madrugada (%).
     * @param humidade_madrugada_max         Umidade Relativa máxima madrugada (%).
     * @param humidade_manha_min             Umidade Relativa minima manhã (%).
     * @param humidade_manha_max             Umidade Relativa máxima manhã (%).
     * @param humidade_tarde_min             Umidade Relativa minima tarde (%).
     * @param humidade_tarde_max             Umidade Relativa máxima tarde (%).
     * @param humidade_noite_min             Umidade Relativa minima noite (%).
     * @param humidade_noite_max             Umidade Relativa máxima noite (%).
     * @param chuva_probabilidade            Probabilidade de chuva em porcentagem.
     * @param chuva_precipitacao             Precipitação em milímetro.
     * @param vento_velocidade_min           Intensidade minima do vento em km/h.
     * @param vento_velocidade_max           Intensidade máxima do vento em km/h.
     * @param vento_velocidade_media         Intensidade média do vento em km/h.
     * @param vento_rajada                   Rajada máxima do vento em km/h
     * @param vento_direcao_graus            Direção do vento em graus.
     * @param vento_direcao                  Direção do vento.
     * @param vento_madrugada_direcao_graus  Direção do vento madrugada em graus.
     * @param vento_madrugada_direcao        Direção do vento madrugada.
     * @param vento_madrugada_rajada         Rajada máxima do vento madrugada em km/h.
     * @param vento_madrugada_velocidade_max Intensidade máxima do vento madrugada em km/h.
     * @param vento_manha_direcao_graus      Direção do vento manhã em graus.
     * @param vento_manha_direcao            Direção do vento manhã.
     * @param vento_manha_rajada             Rajada máxima do vento manhã em km/h.
     * @param vento_manha_velocidade_max     Intensidade máxima do vento manhã em km/h.
     * @param vento_tarde_direcao_graus      Direção do vento tarde.
     * @param vento_tarde_direcao            Direção do vento tarde em graus.
     * @param vento_tarde_rajada             Rajada máxima do vento tarde em km/h.
     * @param vento_tarde_velocidade_max     Intensidade máxima do vento tarde em km/h.
     * @param vento_noite_direcao_graus      Direção do vento noite em graus.
     * @param vento_noite_direcao            Direção do vento noite.
     * @param vento_noite_rajada             Rajada máxima do vento noite em km/h.
     * @param vento_noite_velocidade_max     Intensidade máxima do vento noite em km/h.
     * @param uv                             Indice máximo de Radiação ultravioleta
     * @param sensacao_min                   Sensação termica miníma (°C).
     * @param sensacao_max                   Sensação termica máxima (°C).
     * @param icone_madrugada                Icone madrugada.
     * @param icone_manha                    Icone manhã.
     * @param icone_tarde                    Icone tarde.
     * @param icone_noite                    Icone noite.
     * @param icone_dia                      Icone dia inteiro.
     * @param texto_clima                    Texto de previsão em português.
     * @param texto_dia_todo                 Frase de previsão do dia inteiro reduzida.
     * @param texto_madrugada                Frase de previsão madrugada.
     * @param texto_manha                    Frase de previsão manhã.
     * @param texto_tarde                    Frase de previsão tarde.
     * @param texto_noite                    Frase de previsão noite.
     * @param temperatura_min                Temperatura minima em graus celsius.
     * @param temperatura_max                Temperatura máxima em graus celsius.
     * @param temperatura_madrugada_min      Temperatura minima madrugada em graus celsius.
     * @param temperatura_madrugada_max      Temperatura máxima madrugada em graus celsius.
     * @param temperatura_manha_min          Temperatura minima manhã em graus celsius.
     * @param temperatura_manha_max          Temperatura máxima manhã em graus celsius.
     * @param temperatura_tarde_min          Temperatura minima tarde em graus celsius.
     * @param temperatura_tarde_max          Temperatura máxima tarde em graus celsius.
     * @param temperatura_noite_min          Temperatura minima noite em graus celsius.
     * @param temperatura_noite_max          Temperatura máxima noite em graus celsius.
     * @author Daniel Araújo
     */

    public void atualizaPrevisao15d(Integer codcid, String dataString,
                                    double humidade_min, double humidade_max, double humidade_madrugada_min, double humidade_madrugada_max,
                                    double humidade_manha_min, double humidade_manha_max, double humidade_tarde_min, double humidade_tarde_max,
                                    double humidade_noite_min, double humidade_noite_max, double chuva_probabilidade, double chuva_precipitacao,
                                    double vento_velocidade_min, double vento_velocidade_max, double vento_velocidade_media, double vento_rajada,
                                    double vento_direcao_graus, String vento_direcao, double vento_madrugada_direcao_graus, String vento_madrugada_direcao,
                                    double vento_madrugada_rajada, double vento_madrugada_velocidade_max, double vento_manha_direcao_graus, String vento_manha_direcao,
                                    double vento_manha_rajada, double vento_manha_velocidade_max, double vento_tarde_direcao_graus, String vento_tarde_direcao,
                                    double vento_tarde_rajada, double vento_tarde_velocidade_max, double vento_noite_direcao_graus, String vento_noite_direcao,
                                    double vento_noite_rajada, double vento_noite_velocidade_max, double uv, double sensacao_min, double sensacao_max,
                                    String icone_madrugada, String icone_manha, String icone_tarde, String icone_noite, String icone_dia,
                                    String texto_clima, String texto_dia_todo, String texto_madrugada, String texto_manha, String texto_tarde, String texto_noite,
                                    double temperatura_min, double temperatura_max, double temperatura_madrugada_min, double temperatura_madrugada_max, double temperatura_manha_min,
                                    double temperatura_manha_max, double temperatura_tarde_min, double temperatura_tarde_max, double temperatura_noite_min, double temperatura_noite_max) {

        EntityManager entityManager = new JPAUtil().getEntityManager();
        EntityTransaction transaction = null;

        try {
            transaction = entityManager.getTransaction();
            transaction.begin();

            Previsao15dDao previsao15dDao = new Previsao15dDao(entityManager);

            Integer integer = previsao15dDao.getId(dataString, codcid);

            Previsao15d previsao15d = entityManager.find(Previsao15d.class, integer);

            previsao15d.setHumidade_min(humidade_min);
            previsao15d.setHumidade_max(humidade_max);
            previsao15d.setHumidade_madrugada_min(humidade_madrugada_min);
            previsao15d.setHumidade_madrugada_max(humidade_madrugada_max);
            previsao15d.setHumidade_manha_min(humidade_manha_min);
            previsao15d.setHumidade_manha_max(humidade_manha_max);
            previsao15d.setHumidade_tarde_min(humidade_tarde_min);
            previsao15d.setHumidade_tarde_max(humidade_tarde_max);
            previsao15d.setHumidade_noite_min(humidade_noite_min);
            previsao15d.setHumidade_noite_max(humidade_noite_max);

            previsao15d.setChuva_probabilidade(chuva_probabilidade);
            previsao15d.setChuva_precipitacao(chuva_precipitacao);
            previsao15d.setVento_velocidade_min(vento_velocidade_min);
            previsao15d.setVento_velocidade_max(vento_velocidade_max);
            previsao15d.setVento_velocidade_media(vento_velocidade_media);
            previsao15d.setVento_rajada(vento_rajada);
            previsao15d.setVento_direcao(vento_direcao);
            previsao15d.setVento_direcao_graus(vento_direcao_graus);

            previsao15d.setVento_madrugada_direcao(vento_madrugada_direcao);
            previsao15d.setVento_madrugada_direcao_graus(vento_madrugada_direcao_graus);
            previsao15d.setVento_madrugada_rajada(vento_madrugada_rajada);
            previsao15d.setVento_madrugada_velocidade_max(vento_madrugada_velocidade_max);

            previsao15d.setVento_manha_direcao(vento_manha_direcao);
            previsao15d.setVento_manha_direcao_graus(vento_manha_direcao_graus);
            previsao15d.setVento_manha_rajada(vento_manha_rajada);
            previsao15d.setVento_manha_velocidade_max(vento_manha_velocidade_max);

            previsao15d.setVento_tarde_direcao(vento_tarde_direcao);
            previsao15d.setVento_tarde_direcao_graus(vento_tarde_direcao_graus);
            previsao15d.setVento_tarde_rajada(vento_tarde_rajada);
            previsao15d.setVento_tarde_velocidade_max(vento_tarde_velocidade_max);

            previsao15d.setVento_noite_direcao(vento_noite_direcao);
            previsao15d.setVento_noite_direcao_graus(vento_noite_direcao_graus);
            previsao15d.setVento_noite_rajada(vento_noite_rajada);
            previsao15d.setVento_noite_velocidade_max(vento_noite_velocidade_max);

            //previsao15d.setUv(uv);

            previsao15d.setSensacao_max(sensacao_max);
            previsao15d.setSensacao_min(sensacao_min);

            previsao15d.setIcone_dia(icone_dia);
            previsao15d.setIcone_madrugada(icone_madrugada);
            previsao15d.setIcone_manha(icone_manha);
            previsao15d.setIcone_tarde(icone_tarde);
            previsao15d.setIcone_noite(icone_noite);


            previsao15d.setTexto_clima(texto_clima);
            previsao15d.setTexto_dia_todo(texto_dia_todo);
            previsao15d.setTexto_madrugada(texto_madrugada);
            previsao15d.setTexto_manha(texto_manha);
            previsao15d.setTexto_tarde(texto_tarde);
            previsao15d.setTexto_noite(texto_noite);

            previsao15d.setTemperatura_min(temperatura_min);
            previsao15d.setTemperatura_max(temperatura_max);
            previsao15d.setTemperatura_madrugada_min(temperatura_madrugada_min);
            previsao15d.setTemperatura_madrugada_max(temperatura_madrugada_max);
            previsao15d.setTemperatura_manha_min(temperatura_manha_min);
            previsao15d.setTemperatura_manha_max(temperatura_manha_max);
            previsao15d.setTemperatura_tarde_min(temperatura_tarde_min);
            previsao15d.setTemperatura_tarde_max(temperatura_tarde_max);
            previsao15d.setTemperatura_noite_min(temperatura_noite_min);
            previsao15d.setTemperatura_noite_max(temperatura_noite_max);


            entityManager.merge(previsao15d);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null) transaction.rollback();
            logger.error(e.getMessage());
        } catch (PersistenceException e) {
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
        Previsao15dDao previsao15dDao = new Previsao15dDao(entityManager);
        if (previsao15dDao.getId(data, codcid) == 0) bool = false;
        else bool = true;

        entityManager.getTransaction().commit();
        entityManager.close();
        return bool;
    }
}
