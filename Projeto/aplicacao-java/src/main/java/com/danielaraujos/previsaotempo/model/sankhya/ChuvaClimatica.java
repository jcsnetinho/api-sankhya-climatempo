package com.danielaraujos.previsaotempo.model.sankhya;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "AD_PRETEMCC")
public class ChuvaClimatica {

    @Id
    @Column(name = "CODPRETEMCC")
    private Integer cod_chuva_climatica;

    @Column(name = "CODCID")
    private Integer codcid;

    @Column(name = "DATA")
    private Date data;

    @Column(name = "ANOANTERIORCHUVA")
    private double chuva_anterior;

    @Column(name = "MEDIACHUVA")
    private double media_chuva;

    @Column(name = "PREVISAOCHUVA")
    private double previsao_chuva;


    @Deprecated
    public ChuvaClimatica(){}

    public ChuvaClimatica(Integer cod_chuva_climatica, Integer codcid, Date data, double chuva_anterior,
                          double media_chuva, double previsao_chuva){
        this.cod_chuva_climatica = cod_chuva_climatica;
        this.codcid = codcid;
        this.data = data;
        this.chuva_anterior = chuva_anterior;
        this.media_chuva = media_chuva;
        this.previsao_chuva = previsao_chuva;
    }


    public Integer getCod_chuva_climatica() {
        return cod_chuva_climatica;
    }

    public void setCod_chuva_climatica(Integer cod_chuva_climatica) {
        this.cod_chuva_climatica = cod_chuva_climatica;
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

    public double getChuva_anterior() {
        return chuva_anterior;
    }

    public void setChuva_anterior(double chuva_anterior) {
        this.chuva_anterior = chuva_anterior;
    }

    public double getMedia_chuva() {
        return media_chuva;
    }

    public void setMedia_chuva(double media_chuva) {
        this.media_chuva = media_chuva;
    }

    public double getPrevisao_chuva() {
        return previsao_chuva;
    }

    public void setPrevisao_chuva(double previsao_chuva) {
        this.previsao_chuva = previsao_chuva;
    }
}

