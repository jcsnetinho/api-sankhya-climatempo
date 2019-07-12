package com.danielaraujos.previsaotempo.model.sankhya;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Classe representa o modelo dos Parametros - Sankhya
 *
 * @author Daniel Araújo
 */
@Entity
@Table(name = "TSIPAR")
public class Parametro {

    @Id
    @Column(name = "CHAVE")
    private String chave;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Column(name = "TEXTO")
    private String texto;

    /**
     * Chave
     *
     * @return String - Chave
     */
    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    /**
     * Informações do parametro
     *
     * @return String - Informações do parametro
     */
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Texto
     *
     * @return String - Texto
     */
    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
}
