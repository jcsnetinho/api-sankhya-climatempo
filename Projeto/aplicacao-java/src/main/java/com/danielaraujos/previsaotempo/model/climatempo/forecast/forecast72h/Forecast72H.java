package com.danielaraujos.previsaotempo.model.climatempo.forecast.forecast72h;

import java.util.List;

/**
 * Classe representa o modelo da Previsão 72h dentro do Clima Tempo
 * Forecast72H
 *
 * @author Daniel Araújo
 */

public class Forecast72H {

    private int id;
    private String name;
    private List<Forecast72HDate> data;

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
     * @return String - Nome da cidade
     */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Lista de objetos com dados de previsão por hora.
     *
     * @return List - Lista de objetos com dados de previsão por hora.
     */
    public List<Forecast72HDate> getData() {
        return data;
    }

    public void setData(List<Forecast72HDate> data) {
        this.data = data;
    }


    @Override
    public String toString() {

        String string = this.getId() + " - " + this.getName() + " = ";

        for (Forecast72HDate forecastDate : this.getData()) {
            string += forecastDate;
        }
        return string;
    }
}
