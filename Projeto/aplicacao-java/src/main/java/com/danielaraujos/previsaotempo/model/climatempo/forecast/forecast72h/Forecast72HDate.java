package com.danielaraujos.previsaotempo.model.climatempo.forecast.forecast72h;

/**
 * Classe representa o modelo da Previsão 72h dentro do Clima Tempo
 * Forecast72HDate
 *
 * @author Daniel Araújo
 */
public class Forecast72HDate {

    private String date;
    private Forecast72HDateRain rain;
    private Forecast72HDateWind wind;
    private Forecast72HDateTemperature temperature;

    /**
     * Data no formato "aaaa-mm-dd" (Ex.: 2017-10-01).
     *
     * @return String - Data no formato "aaaa-mm-dd" (Ex.: 2017-10-01).
     */
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Dados de chuva.
     *
     * @return Forecast72HDateRain - Dados de chuva.
     */
    public Forecast72HDateRain getRain() {
        return rain;
    }

    public void setRain(Forecast72HDateRain rain) {
        this.rain = rain;
    }

    /**
     * Dados de vento.
     *
     * @return Forecast72HDateWind - Dados de vento.
     */
    public Forecast72HDateWind getWind() {
        return wind;
    }

    public void setWind(Forecast72HDateWind wind) {
        this.wind = wind;
    }

    /**
     * Dados de temperatura
     *
     * @return Forecast72HDateTemperature - Dados de temperatura
     */
    public Forecast72HDateTemperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Forecast72HDateTemperature temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "\n " + this.getDate() + " - " + this.getRain() + " - " + this.getTemperature() + " - " + this.getWind();
    }
}






