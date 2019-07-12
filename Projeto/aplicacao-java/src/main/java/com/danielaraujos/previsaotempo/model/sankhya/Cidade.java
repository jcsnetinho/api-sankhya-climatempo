package com.danielaraujos.previsaotempo.model.sankhya;

import javax.persistence.*;

/**
 * Classe representa o modelo de Cidade - Sankhya
 *
 * @author Daniel Araújo
 */
@Entity
@Table(name = "TSICID")
public class Cidade {

    @Id
    @Column(name = "CODCID")
    private Integer codcid;
    @Column(name = "NOMECID")
    private String nomecid;
    @Column(name = "AD_CODCIDCLIMA")
    private Integer cod_clima;
    @Column(name = "AD_MAPEARCIDADE")
    private String mapeado;
    
    @ManyToOne
    @JoinColumn(name = "UF")
    private Estado estado;

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
     * Nome da Cidade
     *
     * @return String - Nome da Cidade
     */
    public String getNomecid() {
        return nomecid;
    }

    public void setNomecid(String nomecid) {
        this.nomecid = nomecid;
    }

    /**
     * Código da Cidade no Clima Tempo
     *
     * @return Integer - Código da Cidade no Clima Tempo
     */
    public Integer getCod_clima() {
        return cod_clima;
    }

    public void setCod_clima(Integer cod_clima) {
        this.cod_clima = cod_clima;
    }

    /**
     * Ckekbox para validar se o campo será mapeado ou não
     *
     * @return String - Ckekbox para validar se o campo será mapeado ou não
     */
    public String getMapeado() {
        return mapeado;
    }

    public void setMapeado(String mapeado) {
        this.mapeado = mapeado;
    }

    /**
     * Estado vinculado a cidade
     *
     * @return Estado - Estado vinculado a cidade
     */
    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

}