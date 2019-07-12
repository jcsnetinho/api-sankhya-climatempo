package com.danielaraujos.previsaotempo.model.sankhya;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "AD_PRETEMHT")
public class HistoricoTempo {

    @Id
    @Column(name = "CODPRETEMHT")
    private Integer cod_his_tempo;
    @Column(name = "CODCID")
    private Integer codcid;
    @Column(name = "DATA")
    private Date data_historico;
    @Column(name = "PRECIPITACAOCHUVA")
    private double precipitacao_chuva;
    @Column(name = "FONTEPRECIPITACAO")
    private String fonte_precipitacao;
    @Column(name = "TEMPERATURAMIN")
    private double temperatura_min;
    @Column(name = "TEMPERATURAMAX")
    private double temperatura_max;
    @Column(name = "FONTETEMPERATURA")
    private String fonte_temperatura;

    public Integer getCod_his_tempo() {
        return cod_his_tempo;
    }

    public void setCod_his_tempo(Integer cod_his_tempo) {
        this.cod_his_tempo = cod_his_tempo;
    }

    public Integer getCodcid() {
        return codcid;
    }

    public void setCodcid(Integer codcid) {
        this.codcid = codcid;
    }

    public Date getData_historico() {
        return data_historico;
    }

    public void setData_historico(Date data_historico) {
        this.data_historico = data_historico;
    }

    public double getPrecipitacao_chuva() {
        return precipitacao_chuva;
    }

    public void setPrecipitacao_chuva(double precipitacao_chuva) {
        this.precipitacao_chuva = precipitacao_chuva;
    }

    public String getFonte_precipitacao() {
        return fonte_precipitacao;
    }

    public void setFonte_precipitacao(String fonte_precipitacao) {
        this.fonte_precipitacao = fonte_precipitacao;
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

    public String getFonte_temperatura() {
        return fonte_temperatura;
    }

    public void setFonte_temperatura(String fonte_temperatura) {
        this.fonte_temperatura = fonte_temperatura;
    }
}
