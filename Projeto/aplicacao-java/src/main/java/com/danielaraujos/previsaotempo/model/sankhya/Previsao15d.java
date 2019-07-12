package com.danielaraujos.previsaotempo.model.sankhya;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "AD_PRETEMD")
public class Previsao15d {

    @Id
    @Column(name = "CODPRETEMD")
    private Integer cod_clima_15;
    @Column(name = "CODCID")
    private Integer codcid;
    @Column(name = "DATAPREVISAO")
    private Date data;

    //Humidade
    @Column(name = "UMIDADEMIN")
    private double humidade_min;
    @Column(name = "UMIDADEMAX")
    private double humidade_max;
    @Column(name = "UMIDADEMADRUMIN")
    private double humidade_madrugada_min;
    @Column(name = "UMIDADEMADRUMAX")
    private double humidade_madrugada_max;
    @Column(name = "UMIDADEMANHAMIN")
    private double humidade_manha_min;
    @Column(name = "UMIDADEMANHAMAX")
    private double humidade_manha_max;
    @Column(name = "UMIDADETARDEMIN")
    private double humidade_tarde_min;
    @Column(name = "UMIDADETARDEMAX")
    private double humidade_tarde_max;
    @Column(name = "UMIDADENOITEMIN")
    private double humidade_noite_min;
    @Column(name = "UMIDADENOITEMAX")
    private double humidade_noite_max;

    //Chuvas
    @Column(name = "PROBABILIDADECHUVA")
    private double chuva_probabilidade;
    @Column(name = "PRECIPITACAOCHUVA")
    private double chuva_precipitacao;


    //Ventos
    @Column(name = "VELOCIDADEMINVENTO")
    private double vento_velocidade_min;
    @Column(name = "VELOCIDADEMAXVENTO")
    private double vento_velocidade_max;
    @Column(name = "VELOCIDADEMEDIAVENTO")
    private double vento_velocidade_media;
    @Column(name = "RAJADAVENTO")
    private double vento_rajada;
    @Column(name = "DIRECAOGRAUSVENTO")
    private double vento_direcao_graus;
    @Column(name = "DIRECAOVENTO")
    private String vento_direcao;


    @Column(name = "DIRECAOGRAUSMADRUVENTO")
    private double vento_madrugada_direcao_graus;
    @Column(name = "DIRECAOMADRUVENTO")
    private String vento_madrugada_direcao;
    @Column(name = "RAJADAMADRUVENTO")
    private double vento_madrugada_rajada;
    @Column(name = "VELOCIDADEMADRUVENTO")
    private double vento_madrugada_velocidade_max;

    @Column(name = "DIRECAOGRAUSMANHAVENTO")
    private double vento_manha_direcao_graus;
    @Column(name = "DIRECAOMANHAVENTO")
    private String vento_manha_direcao;
    @Column(name = "RAJADAMANHAVENTO")
    private double vento_manha_rajada;
    @Column(name = "VELOCIDADEMANHAVENTO")
    private double vento_manha_velocidade_max;


    @Column(name = "DIRECAOGRAUSTARDEVENTO")
    private double vento_tarde_direcao_graus;
    @Column(name = "DIRECAOTARDEVENTO")
    private String vento_tarde_direcao;
    @Column(name = "RAJADATARDEVENTO")
    private double vento_tarde_rajada;
    @Column(name = "VELOCIDADETARDEVENTO")
    private double vento_tarde_velocidade_max;

    @Column(name = "DIRECAOGRAUSNOITEVENTO")
    private double vento_noite_direcao_graus;
    @Column(name = "DIRECAONOITEVENTO")
    private String vento_noite_direcao;
    @Column(name = "RAJADANOITEVENTO")
    private double vento_noite_rajada;
    @Column(name = "VELOCIDADENOITEVENTO")
    private double vento_noite_velocidade_max;

    //Radiação ultravioleta
    @Column(name = "RADIACAOVIOLETA")
    private double uv;

    //Sensacao Termica
    @Column(name = "SENSACAOMIN")
    private double sensacao_min;
    @Column(name = "SENSACAOMAX")
    private double sensacao_max;

    //Icones
    @Column(name = "ICONEMADRU")
    private String icone_madrugada;
    @Column(name = "ICONEMANHA")
    private String icone_manha;
    @Column(name = "ICONETARDE")
    private String icone_tarde;
    @Column(name = "ICONENOITE")
    private String icone_noite;
    @Column(name = "ICONEDIA")
    private String icone_dia;

    //textos
    @Column(name = "TEXTOCLIMA")
    private String texto_clima;

    @Column(name = "TEXTODIA")
    private String texto_dia_todo;
    @Column(name = "TEXTOMADRU")
    private String texto_madrugada;
    @Column(name = "TEXTOMANHA")
    private String texto_manha;
    @Column(name = "TEXTOTARDE")
    private String texto_tarde;
    @Column(name = "TEXTONOITE")
    private String texto_noite;

    //Temperatura
    @Column(name = "TEMPERATURAMIN")
    private double temperatura_min;
    @Column(name = "TEMPERATURAMAX")
    private double temperatura_max;

    @Column(name = "TEMPERATURAMADRUMIN")
    private double temperatura_madrugada_min;
    @Column(name = "TEMPERATURAMADRUMAX")
    private double temperatura_madrugada_max;

    @Column(name = "TEMPERATURAMANHAMIN")
    private double temperatura_manha_min;
    @Column(name = "TEMPERATURAMANHAMAX")
    private double temperatura_manha_max;

    @Column(name = "TEMPERATURATARDEMIN")
    private double temperatura_tarde_min;
    @Column(name = "TEMPERATURATARDEMAX")
    private double temperatura_tarde_max;

    @Column(name = "TEMPERATURANOITEMIN")
    private double temperatura_noite_min;
    @Column(name = "TEMPERATURANOITEMAX")
    private double temperatura_noite_max;


    @Deprecated
    public Previsao15d() {
    }

    public Previsao15d(Integer cod_clima_15, Integer codcid, Date data,
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

        this.cod_clima_15 = cod_clima_15;
        this.codcid = codcid;
        this.data = data;

        this.humidade_min = humidade_min;
        this.humidade_max = humidade_max;
        this.humidade_madrugada_min = humidade_madrugada_min;
        this.humidade_madrugada_max = humidade_madrugada_max;
        this.humidade_manha_min = humidade_manha_min;
        this.humidade_manha_max = humidade_manha_max;
        this.humidade_tarde_min = humidade_tarde_min;
        this.humidade_tarde_max = humidade_tarde_max;
        this.humidade_noite_min = humidade_noite_min;
        this.humidade_noite_max = humidade_noite_max;

        this.chuva_probabilidade = chuva_probabilidade;
        this.chuva_precipitacao = chuva_precipitacao;

        this.vento_velocidade_min = vento_velocidade_min;
        this.vento_velocidade_max = vento_velocidade_max;
        this.vento_velocidade_media = vento_velocidade_media;
        this.vento_rajada = vento_rajada;
        this.vento_direcao_graus = vento_direcao_graus;
        this.vento_direcao = vento_direcao;
        this.vento_madrugada_direcao_graus = vento_madrugada_direcao_graus;
        this.vento_madrugada_direcao = vento_madrugada_direcao;
        this.vento_madrugada_rajada = vento_madrugada_rajada;
        this.vento_madrugada_velocidade_max = vento_madrugada_velocidade_max;
        this.vento_manha_direcao_graus = vento_manha_direcao_graus;
        this.vento_manha_direcao = vento_manha_direcao;
        this.vento_manha_rajada = vento_manha_rajada;
        this.vento_manha_velocidade_max = vento_manha_velocidade_max;
        this.vento_tarde_direcao_graus = vento_tarde_direcao_graus;
        this.vento_tarde_direcao = vento_tarde_direcao;
        this.vento_tarde_rajada = vento_tarde_rajada;
        this.vento_tarde_velocidade_max = vento_tarde_velocidade_max;
        this.vento_noite_direcao_graus = vento_noite_direcao_graus;
        this.vento_noite_direcao = vento_noite_direcao;
        this.vento_noite_rajada = vento_noite_rajada;
        this.vento_noite_velocidade_max = vento_noite_velocidade_max;

        this.uv = uv;
        this.sensacao_min = sensacao_min;
        this.sensacao_max = sensacao_max;

        this.icone_madrugada = icone_madrugada;
        this.icone_manha = icone_manha;
        this.icone_tarde = icone_tarde;
        this.icone_noite = icone_noite;
        this.icone_dia = icone_dia;

        this.texto_clima = texto_clima;
        this.texto_dia_todo = texto_dia_todo;
        this.texto_madrugada = texto_madrugada;
        this.texto_manha = texto_manha;
        this.texto_tarde = texto_tarde;
        this.texto_noite = texto_noite;

        this.temperatura_min = temperatura_min;
        this.temperatura_max = temperatura_max;
        this.temperatura_madrugada_min = temperatura_madrugada_min;
        this.temperatura_madrugada_max = temperatura_madrugada_max;
        this.temperatura_manha_min = temperatura_manha_min;
        this.temperatura_manha_max = temperatura_manha_max;
        this.temperatura_tarde_min = temperatura_tarde_min;
        this.temperatura_tarde_max = temperatura_tarde_max;
        this.temperatura_noite_min = temperatura_noite_min;
        this.temperatura_noite_max = temperatura_noite_max;


    }

    public Integer getCod_clima_15() {
        return cod_clima_15;
    }

    public void setCod_clima_15(Integer cod_clima_15) {
        this.cod_clima_15 = cod_clima_15;
    }

    public Integer getCodcid() {
        return codcid;
    }

    public void setCodcid(Integer codcid) {
        this.codcid = codcid;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getHumidade_min() {
        return humidade_min;
    }

    public void setHumidade_min(double humidade_min) {
        this.humidade_min = humidade_min;
    }

    public double getHumidade_max() {
        return humidade_max;
    }

    public void setHumidade_max(double humidade_max) {
        this.humidade_max = humidade_max;
    }

    public double getHumidade_madrugada_min() {
        return humidade_madrugada_min;
    }

    public void setHumidade_madrugada_min(double humidade_madrugada_min) {
        this.humidade_madrugada_min = humidade_madrugada_min;
    }

    public double getHumidade_madrugada_max() {
        return humidade_madrugada_max;
    }

    public void setHumidade_madrugada_max(double humidade_madrugada_max) {
        this.humidade_madrugada_max = humidade_madrugada_max;
    }

    public double getHumidade_manha_min() {
        return humidade_manha_min;
    }

    public void setHumidade_manha_min(double humidade_manha_min) {
        this.humidade_manha_min = humidade_manha_min;
    }

    public double getHumidade_manha_max() {
        return humidade_manha_max;
    }

    public void setHumidade_manha_max(double humidade_manha_max) {
        this.humidade_manha_max = humidade_manha_max;
    }

    public double getHumidade_tarde_min() {
        return humidade_tarde_min;
    }

    public void setHumidade_tarde_min(double humidade_tarde_min) {
        this.humidade_tarde_min = humidade_tarde_min;
    }

    public double getHumidade_tarde_max() {
        return humidade_tarde_max;
    }

    public void setHumidade_tarde_max(double humidade_tarde_max) {
        this.humidade_tarde_max = humidade_tarde_max;
    }

    public double getHumidade_noite_min() {
        return humidade_noite_min;
    }

    public void setHumidade_noite_min(double humidade_noite_min) {
        this.humidade_noite_min = humidade_noite_min;
    }

    public double getHumidade_noite_max() {
        return humidade_noite_max;
    }

    public void setHumidade_noite_max(double humidade_noite_max) {
        this.humidade_noite_max = humidade_noite_max;
    }

    public double getChuva_probabilidade() {
        return chuva_probabilidade;
    }

    public void setChuva_probabilidade(double chuva_probabilidade) {
        this.chuva_probabilidade = chuva_probabilidade;
    }

    public double getChuva_precipitacao() {
        return chuva_precipitacao;
    }

    public void setChuva_precipitacao(double chuva_precipitacao) {
        this.chuva_precipitacao = chuva_precipitacao;
    }


    public double getVento_velocidade_min() {
        return vento_velocidade_min;
    }

    public void setVento_velocidade_min(double vento_velocidade_min) {
        this.vento_velocidade_min = vento_velocidade_min;
    }

    public double getVento_velocidade_max() {
        return vento_velocidade_max;
    }

    public void setVento_velocidade_max(double vento_velocidade_max) {
        this.vento_velocidade_max = vento_velocidade_max;
    }

    public double getVento_velocidade_media() {
        return vento_velocidade_media;
    }

    public void setVento_velocidade_media(double vento_velocidade_media) {
        this.vento_velocidade_media = vento_velocidade_media;
    }

    public double getVento_rajada() {
        return vento_rajada;
    }

    public void setVento_rajada(double vento_rajada) {
        this.vento_rajada = vento_rajada;
    }

    public double getVento_direcao_graus() {
        return vento_direcao_graus;
    }

    public void setVento_direcao_graus(double vento_direcao_graus) {
        this.vento_direcao_graus = vento_direcao_graus;
    }

    public String getVento_direcao() {
        return vento_direcao;
    }

    public void setVento_direcao(String vento_direcao) {
        this.vento_direcao = vento_direcao;
    }

    public double getVento_madrugada_direcao_graus() {
        return vento_madrugada_direcao_graus;
    }

    public void setVento_madrugada_direcao_graus(double vento_madrugada_direcao_graus) {
        this.vento_madrugada_direcao_graus = vento_madrugada_direcao_graus;
    }

    public String getVento_madrugada_direcao() {
        return vento_madrugada_direcao;
    }

    public void setVento_madrugada_direcao(String vento_madrugada_direcao) {
        this.vento_madrugada_direcao = vento_madrugada_direcao;
    }

    public double getVento_madrugada_rajada() {
        return vento_madrugada_rajada;
    }

    public void setVento_madrugada_rajada(double vento_madrugada_rajada) {
        this.vento_madrugada_rajada = vento_madrugada_rajada;
    }

    public double getVento_madrugada_velocidade_max() {
        return vento_madrugada_velocidade_max;
    }

    public void setVento_madrugada_velocidade_max(double vento_madrugada_velocidade_max) {
        this.vento_madrugada_velocidade_max = vento_madrugada_velocidade_max;
    }

    public double getVento_manha_direcao_graus() {
        return vento_manha_direcao_graus;
    }

    public void setVento_manha_direcao_graus(double vento_manha_direcao_graus) {
        this.vento_manha_direcao_graus = vento_manha_direcao_graus;
    }

    public String getVento_manha_direcao() {
        return vento_manha_direcao;
    }

    public void setVento_manha_direcao(String vento_manha_direcao) {
        this.vento_manha_direcao = vento_manha_direcao;
    }

    public double getVento_manha_rajada() {
        return vento_manha_rajada;
    }

    public void setVento_manha_rajada(double vento_manha_rajada) {
        this.vento_manha_rajada = vento_manha_rajada;
    }

    public double getVento_manha_velocidade_max() {
        return vento_manha_velocidade_max;
    }

    public void setVento_manha_velocidade_max(double vento_manha_velocidade_max) {
        this.vento_manha_velocidade_max = vento_manha_velocidade_max;
    }

    public double getVento_tarde_direcao_graus() {
        return vento_tarde_direcao_graus;
    }

    public void setVento_tarde_direcao_graus(double vento_tarde_direcao_graus) {
        this.vento_tarde_direcao_graus = vento_tarde_direcao_graus;
    }

    public String getVento_tarde_direcao() {
        return vento_tarde_direcao;
    }

    public void setVento_tarde_direcao(String vento_tarde_direcao) {
        this.vento_tarde_direcao = vento_tarde_direcao;
    }

    public double getVento_tarde_rajada() {
        return vento_tarde_rajada;
    }

    public void setVento_tarde_rajada(double vento_tarde_rajada) {
        this.vento_tarde_rajada = vento_tarde_rajada;
    }

    public double getVento_tarde_velocidade_max() {
        return vento_tarde_velocidade_max;
    }

    public void setVento_tarde_velocidade_max(double vento_tarde_velocidade_max) {
        this.vento_tarde_velocidade_max = vento_tarde_velocidade_max;
    }

    public double getVento_noite_direcao_graus() {
        return vento_noite_direcao_graus;
    }

    public void setVento_noite_direcao_graus(double vento_noite_direcao_graus) {
        this.vento_noite_direcao_graus = vento_noite_direcao_graus;
    }

    public String getVento_noite_direcao() {
        return vento_noite_direcao;
    }

    public void setVento_noite_direcao(String vento_noite_direcao) {
        this.vento_noite_direcao = vento_noite_direcao;
    }

    public double getVento_noite_rajada() {
        return vento_noite_rajada;
    }

    public void setVento_noite_rajada(double vento_noite_rajada) {
        this.vento_noite_rajada = vento_noite_rajada;
    }

    public double getVento_noite_velocidade_max() {
        return vento_noite_velocidade_max;
    }

    public void setVento_noite_velocidade_max(double vento_noite_velocidade_max) {
        this.vento_noite_velocidade_max = vento_noite_velocidade_max;
    }

    public double getUv() {
        return uv;
    }

    public void setUv(double uv) {
        this.uv = uv;
    }

    public double getSensacao_min() {
        return sensacao_min;
    }

    public void setSensacao_min(double sensacao_min) {
        this.sensacao_min = sensacao_min;
    }

    public double getSensacao_max() {
        return sensacao_max;
    }

    public void setSensacao_max(double sensacao_max) {
        this.sensacao_max = sensacao_max;
    }

    public String getIcone_madrugada() {
        return icone_madrugada;
    }

    public void setIcone_madrugada(String icone_madrugada) {
        this.icone_madrugada = icone_madrugada;
    }

    public String getIcone_manha() {
        return icone_manha;
    }

    public void setIcone_manha(String icone_manha) {
        this.icone_manha = icone_manha;
    }

    public String getIcone_tarde() {
        return icone_tarde;
    }

    public void setIcone_tarde(String icone_tarde) {
        this.icone_tarde = icone_tarde;
    }

    public String getIcone_noite() {
        return icone_noite;
    }

    public void setIcone_noite(String icone_noite) {
        this.icone_noite = icone_noite;
    }

    public String getIcone_dia() {
        return icone_dia;
    }

    public void setIcone_dia(String icone_dia) {
        this.icone_dia = icone_dia;
    }

    public String getTexto_clima() {
        return texto_clima;
    }

    public void setTexto_clima(String texto_clima) {
        this.texto_clima = texto_clima;
    }

    public String getTexto_dia_todo() {
        return texto_dia_todo;
    }

    public void setTexto_dia_todo(String texto__dia_todo) {
        this.texto_dia_todo = texto__dia_todo;
    }

    public String getTexto_madrugada() {
        return texto_madrugada;
    }

    public void setTexto_madrugada(String texto__madrugada) {
        this.texto_madrugada = texto__madrugada;
    }

    public String getTexto_manha() {
        return texto_manha;
    }

    public void setTexto_manha(String texto__manha) {
        this.texto_manha = texto__manha;
    }

    public String getTexto_tarde() {
        return texto_tarde;
    }

    public void setTexto_tarde(String texto__tarde) {
        this.texto_tarde = texto__tarde;
    }

    public String getTexto_noite() {
        return texto_noite;
    }

    public void setTexto_noite(String texto__noite) {
        this.texto_noite = texto__noite;
    }

    public double getTemperatura_min() {
        return temperatura_min;
    }

    public void setTemperatura_min(double temperatura_min) {
        this.temperatura_min = temperatura_min;
    }

    public double getTemperatura_max() {
        return temperatura_max;
    }

    public void setTemperatura_max(double temperatura_max) {
        this.temperatura_max = temperatura_max;
    }

    public double getTemperatura_madrugada_min() {
        return temperatura_madrugada_min;
    }

    public void setTemperatura_madrugada_min(double temperatura_madrugada_min) {
        this.temperatura_madrugada_min = temperatura_madrugada_min;
    }

    public double getTemperatura_madrugada_max() {
        return temperatura_madrugada_max;
    }

    public void setTemperatura_madrugada_max(double temperatura_madrugada_max) {
        this.temperatura_madrugada_max = temperatura_madrugada_max;
    }

    public double getTemperatura_manha_min() {
        return temperatura_manha_min;
    }

    public void setTemperatura_manha_min(double temperatura_manha_min) {
        this.temperatura_manha_min = temperatura_manha_min;
    }

    public double getTemperatura_manha_max() {
        return temperatura_manha_max;
    }

    public void setTemperatura_manha_max(double temperatura_manha_max) {
        this.temperatura_manha_max = temperatura_manha_max;
    }

    public double getTemperatura_tarde_min() {
        return temperatura_tarde_min;
    }

    public void setTemperatura_tarde_min(double temperatura_tarde_min) {
        this.temperatura_tarde_min = temperatura_tarde_min;
    }

    public double getTemperatura_tarde_max() {
        return temperatura_tarde_max;
    }

    public void setTemperatura_tarde_max(double temperatura_tarde_max) {
        this.temperatura_tarde_max = temperatura_tarde_max;
    }

    public double getTemperatura_noite_min() {
        return temperatura_noite_min;
    }

    public void setTemperatura_noite_min(double temperatura_noite_min) {
        this.temperatura_noite_min = temperatura_noite_min;
    }

    public double getTemperatura_noite_max() {
        return temperatura_noite_max;
    }

    public void setTemperatura_noite_max(double temperatura_noite_max) {
        this.temperatura_noite_max = temperatura_noite_max;
    }


}
