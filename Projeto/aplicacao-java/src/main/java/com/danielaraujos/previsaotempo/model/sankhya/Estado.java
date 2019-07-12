package com.danielaraujos.previsaotempo.model.sankhya;

import javax.persistence.*;
import java.util.List;

/**
 * Classe representa o modelo de Estado - Sankhya
 *
 * @author Daniel Araújo
 */
@Entity
@Table(name = "TSIUFS")
public class Estado {

    @Id
    @Column(name = "CODUF")
    private Integer coduf;

    @Column(name = "UF")
    private String uf;

    @Column(name = "DESCRICAO")
    private String descricao;

    @OneToMany(mappedBy = "estado")
    private List<Cidade> cidades;

    /**
     * Código do Estado
     *
     * @return Integer - Código do Estado
     */
    public Integer getCoduf() {
        return coduf;
    }

    public void setCoduf(Integer coduf) {
        this.coduf = coduf;
    }

    /**
     * Sigla do Estado
     *
     * @return String - Sigla do Estado
     */
    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * Nome do Estado
     *
     * @return String - Nome do Estado
     */
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Lista de Cidades Vinculado a este estado
     *
     * @return List - Lista de Cidades Vinculado a este estado
     */
    public List<Cidade> getCidades() {
        return cidades;
    }

    public void setCidades(List<Cidade> cidades) {
        this.cidades = cidades;
    }

}
