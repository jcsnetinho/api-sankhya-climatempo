package com.danielaraujos.previsaotempo.model.sankhya;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "AD_PRETEMHR")
public class HistoricoRaios {

    @Id
    @Column(name = "CODPRETEMHR")
    private Integer cod_his_raios;
    @Column(name = "DATA")
    private Date data;
    @Column(name = "FONTE")
    private String fonte;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "LATITUDE")
    private String latitude;
    @Column(name = "LONGITUDE")
    private String longitude;

    public Integer getCod_his_raios() {
        return cod_his_raios;
    }

    public void setCod_his_raios(Integer cod_his_raios) {
        this.cod_his_raios = cod_his_raios;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
