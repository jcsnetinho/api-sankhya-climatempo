package com.danielaraujos.previsaotempo.model.sankhya;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


/**
 * Classe representa o modelo da Previsao das próximas 72h - Sankhya
 *
 * @author Daniel Araújo
 */

@Entity
@Table(name = "AD_PRETEMH")
public class Previsao72h {

    @Id
    @Column(name = "CODPRETEMH")
    private Integer cod_clima_72;
    @Column(name = "CODCID")
    private Integer codcid;
    @Column(name = "DATAPREVISAO")
    private Date data;
    @Column(name = "PRECIPITACAOCHUVA")
    private double precipitacao_chuva;
    @Column(name = "VELOCIDADEVENTO")
    private double velocidade_vento;
    @Column(name = "DIRECAOVENTO")
    private String direcao_vento;
    @Column(name = "DIRECAOGRAUSVENTO")
    private double direcao_vento_graus;
    @Column(name = "RAJADAVENTO")
    private double rajada_vento;
    @Column(name = "TEMPERATURA")
    private double temperatura;


    @Deprecated
    public Previsao72h() {
    }

    /**
     * Construtor
     *
     * @param cod_clima_72        Número Único
     * @param codcid              Código da Cidade
     * @param temperatura         Temperatuda da Cidade
     * @param precipitacao_chuva  Precipitação em milímetro.
     * @param velocidade_vento    Velocidade dos Ventos
     * @param direcao_vento       Direção do vento
     * @param direcao_vento_graus Direção dos ventos em graus
     * @param rajada_vento        Rajada do vento em km/h.
     * @param data                Data da previsão
     * @author Daniel Araújo
     */

    public Previsao72h(Integer cod_clima_72, Integer codcid, Date data, double precipitacao_chuva,
                       double velocidade_vento, String direcao_vento,
                       double direcao_vento_graus, double rajada_vento, double temperatura) {

        this.cod_clima_72 = cod_clima_72;
        this.codcid = codcid;
        this.data = data;
        this.precipitacao_chuva = precipitacao_chuva;
        this.direcao_vento = direcao_vento;
        this.velocidade_vento = velocidade_vento;
        this.direcao_vento_graus = direcao_vento_graus;
        this.rajada_vento = rajada_vento;
        this.temperatura = temperatura;
    }


    /**
     * Número único incremental - chave primária
     *
     * @return Integer - Número único
     */
    public Integer getCod_clima_72() {
        return cod_clima_72;
    }

    public void setCod_clima_72(Integer cod_clima_72) {
        this.cod_clima_72 = cod_clima_72;
    }

    /**
     * Código da Cidade
     *
     * @return Integer - Código da Cidade
     */
    public Integer getCodcid() {
        return codcid;
    }

    public void setCodcid(Integer codcid) {
        this.codcid = codcid;
    }

    /**
     * Data da previsão
     *
     * @return Date - Data da previsão
     */
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    /**
     * Precipitação em milímetro.
     *
     * @return Double - Precipitação em milímetro.
     */
    public double getPrecipitacao_chuva() {
        return precipitacao_chuva;
    }

    public void setPrecipitacao_chuva(double precipitacao_chuva) {
        this.precipitacao_chuva = precipitacao_chuva;
    }

    /**
     * Intensidade do vento em km/h.
     *
     * @return Double - Intensidade do vento em km/h.
     */
    public double getVelocidade_vento() {
        return velocidade_vento;
    }

    public void setVelocidade_vento(double velocidade_vento) {
        this.velocidade_vento = velocidade_vento;
    }

    /**
     * Direção do vento.
     *
     * @return String - Direção do vento.
     */
    public String getDirecao_vento() {
        return direcao_vento;
    }

    public void setDirecao_vento(String direcao_vento) {
        this.direcao_vento = direcao_vento;
    }

    /**
     * Direção do vento em graus
     *
     * @return double - Direção do vento em graus
     */
    public double getDirecao_vento_graus() {
        return direcao_vento_graus;
    }

    public void setDirecao_vento_graus(double direcao_vento_graus) {
        this.direcao_vento_graus = direcao_vento_graus;
    }

    /**
     * Rajada do vento em km/h.
     *
     * @return double - Rajada do vento em km/h.
     */
    public double getRajada_vento() {
        return rajada_vento;
    }

    public void setRajada_vento(double rajada_vento) {
        this.rajada_vento = rajada_vento;
    }

    /**
     * Temperatura em graus celsius.
     *
     * @return double - Temperatura em graus celsius.
     */
    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }
}
