package com.danielaraujos.previsaotempo.model.climatempo.forecast.forecast15d;

import java.util.List;

/**
 * Classe representa o modelo da Previsão 15d dentro do Clima Tempo
 * Forecast15D
 *
 * @author Daniel Araújo
 */
public class Forecast15D {

    private int id;
    private List<Forecast15DDate> data;

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
     * Lista de objetos com dados de previsão por dia.
     *
     * @return Forecast15DDate - Lista de objetos com dados de previsão por dia.
     */
    public List<Forecast15DDate> getData() {
        return data;
    }

    public void setData(List<Forecast15DDate> data) {
        this.data = data;
    }

    @Override
    public String toString() {

        String string = this.getId() + " - ";

        for (Forecast15DDate geoForecastDate : this.getData()) {
            string += geoForecastDate;
        }
        return string;
    }
}
