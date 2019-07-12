package com.danielaraujos.previsaotempo.model.climatempo.city;

/**
 * Classe representa o modelo da Cidade dentro do Clima Tempo
 * City
 *
 * @author Daniel Araújo
 */
public class City {
    private int id;
    private String name;
    private String state;
    private String country;

    /**
     * Código da cidade
     *
     * @return Integer - Código da cidade
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Nome da Cidade
     *
     * @return String - Nome da Cidade
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Nome do estado
     *
     * @return String - Nome do estado
     */
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    /**
     * Nome do país
     *
     * @return String - Nome do país
     */
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

}
