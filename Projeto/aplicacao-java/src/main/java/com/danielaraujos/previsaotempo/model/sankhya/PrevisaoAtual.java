package com.danielaraujos.previsaotempo.model.sankhya;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * Classe representa o modelo da Previsão Atual - Sankhya
 *
 * @author Daniel Araújo
 */

@Entity
@Table(name = "AD_PRETEMAT")
public class PrevisaoAtual {

    @Id
    @Column(name = "CODPRETEMAT")
    private Integer cod_clima_atual;
    @Column(name = "CODCID")
    private Integer codcid;
    @Column(name = "TEMPERATURA")
    private double temperatura;
    @Column(name = "DIRECAOVENTO")
    private String direcao_ventos;
    @Column(name = "VELOCIDADEVENTO")
    private double velocidade_ventos;
    @Column(name = "UMIDADE")
    private double umidade;
    @Column(name = "CONDICAO")
    private String condicao;
    @Column(name = "PRESSAO")
    private double pressao;
    @Column(name = "ICONE")
    private String icone;
    @Column(name = "SENSACAO")
    private double sensacao;
    @Column(name = "DATAPREVISAO")
    private Date data;


    @Deprecated
    public PrevisaoAtual() {
    }

    /**
     * Construtor criado para facilitar o ato de inserir
     *
     * @param codcid            Código da Cidade
     * @param temperatura       Temperatuda da Cidade
     * @param direcao_ventos    Direções dos Ventos
     * @param velocidade_ventos Velocidade dos Ventos
     * @param umidade           Umidade do ar
     * @param condicao          Texto explicando as condições do dia
     * @param pressao           Pressão do ar
     * @param icone             Icone responsavel pela visualização
     * @param sensacao          Sensação Termica para o dia
     * @param data              Data da previsão
     * @author Daniel Araújo
     */

    public PrevisaoAtual(Integer cod_clima_atual, Integer codcid, double temperatura, String direcao_ventos, double velocidade_ventos, double umidade,
                         String condicao, double pressao, String icone, double sensacao, Date data) {
        this.cod_clima_atual = cod_clima_atual;
        this.codcid = codcid;
        this.temperatura = temperatura;
        this.direcao_ventos = direcao_ventos;
        this.velocidade_ventos = velocidade_ventos;
        this.umidade = umidade;
        this.condicao = condicao;
        this.pressao = pressao;
        this.icone = icone;
        this.sensacao = sensacao;
        this.data = data;
    }

    /**
     * Número único incremental - chave primária
     *
     * @return Integer - Número único
     */
    public Integer getCod_clima_atual() {
        return cod_clima_atual;
    }

    public void setCod_clima_atual(Integer cod_clima_atual) {
        this.cod_clima_atual = cod_clima_atual;
    }

    /**
     * Código da Cidade
     *
     * @return Integer - Retorna o código da cidade
     */
    public Integer getCodcid() {
        return codcid;
    }

    public void setCodcid(Integer codcid) {
        this.codcid = codcid;
    }

    /**
     * Temperatura em graus celsius (°C).
     *
     * @return Double - Temperatura em graus celsius
     */
    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    /**
     * Direções dos ventos
     *
     * @return String - Direções dos ventos
     */
    public String getDirecao_ventos() {
        return direcao_ventos;
    }

    public void setDirecao_ventos(String direcao_ventos) {
        this.direcao_ventos = direcao_ventos;
    }

    /**
     * Intensidade do vento em km/h
     *
     * @return double - Intensidade do vento em km/h
     */
    public double getVelocidade_ventos() {
        return velocidade_ventos;
    }

    public void setVelocidade_ventos(double velocidade_ventos) {
        this.velocidade_ventos = velocidade_ventos;
    }

    /**
     * Condição
     *
     * @return String - Texto relatando as condições climáticas
     */
    public String getCondicao() {
        return condicao;
    }

    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }


    /**
     * Pressão (hPa).
     *
     * @return double - Pressão (hPa)
     */
    public double getPressao() {
        return pressao;
    }

    public void setPressao(double pressao) {
        this.pressao = pressao;
    }

    /**
     * Icone da previsão.
     *
     * @return String - Icone da previsão.
     */
    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    /**
     * Sensação em graus celsius (°C).
     *
     * @return double - Sensação em graus celsius (°C).
     */
    public double getSensacao() {
        return sensacao;
    }

    public void setSensacao(double sensacao) {
        this.sensacao = sensacao;
    }

    /**
     * Data
     *
     * @return Data - Data da Previsão
     */
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }


    /**
     * Umidade relativa do ar (%).
     *
     * @return double - Umidade relativa do ar (%).
     */
    public double getUmidade() {
        return umidade;
    }

    public void setUmidade(double umidade) {
        this.umidade = umidade;
    }
}