package com.danielaraujos.previsaotempo.model.climatempo.weather;


/**
 * Classe representa o modelo da Previsão Atual dentro do Clima Tempo
 * Weather
 *
 * @author Daniel Araújo
 */

public class Weather {

    private int id;
    private String name;
    private String state;
    private WeatherData data;

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
     * Nome da cidade.
     *
     * @return String - Nome da cidade.
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Estado da cidade.
     *
     * @return String - Estado da cidade.
     */
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    /**
     * Dados de tempo no momento para a cidade.
     *
     * @return WeatherData - Dados de tempo no momento para a cidade.
     */
    public WeatherData getData() {
        return data;
    }

    public void setData(WeatherData data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return this.getId() + " - " + this.getName() + " - " + this.getState() + " - " + this.getData();
    }


}

