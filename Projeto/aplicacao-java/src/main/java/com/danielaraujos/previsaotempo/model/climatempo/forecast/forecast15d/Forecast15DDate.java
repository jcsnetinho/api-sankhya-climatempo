package com.danielaraujos.previsaotempo.model.climatempo.forecast.forecast15d;

/**
 * Classe representa o modelo da Previsão 15d dentro do Clima Tempo
 * -Lista de objetos com dados de previsão por dia.
 * -Forecast15DDate
 *
 * @author Daniel Araújo
 */
public class Forecast15DDate {

    private String date;
    private Forecast15DHumidity humidity;
    private Forecast15DRain rain;
    private Forecast15DWind wind;
    //private Forecast15DUv uv;
    private Forecast15DThermalSensation thermal_sensation;
    private Forecast15DTextIcon text_icon;
    private Forecast15DTemperature temperature;

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
     * Dados de humidade.
     *
     * @return Forecast15DHumidity - Dados de humidade.
     */
    public Forecast15DHumidity getHumidity() {
        return humidity;
    }

    public void setHumidity(Forecast15DHumidity humidity) {
        this.humidity = humidity;
    }

    /**
     * Dados de chuva.
     *
     * @return Forecast15DRain - Dados de chuva.
     */
    public Forecast15DRain getRain() {
        return rain;
    }

    public void setRain(Forecast15DRain rain) {
        this.rain = rain;
    }

    /**
     * Dados de vento.
     *
     * @return Forecast15DWind - Dados de vento.
     */
    public Forecast15DWind getWind() {
        return wind;
    }

    public void setWind(Forecast15DWind wind) {
        this.wind = wind;
    }


    /**
     * Dados de sensação termica.
     *
     * @return Forecast15DThermalSensation - Dados de sensação termica
     */
    public Forecast15DThermalSensation getThermal_sensation() {
        return thermal_sensation;
    }

    public void setThermal_sensation(Forecast15DThermalSensation thermal_sensation) {
        this.thermal_sensation = thermal_sensation;
    }

    /**
     * Icone e Texto de previsão.
     *
     * @return Forecast15DTextIcon - Icone e Texto de previsão.
     */
    public Forecast15DTextIcon getText_icon() {
        return text_icon;
    }

    public void setText_icon(Forecast15DTextIcon text_icon) {
        this.text_icon = text_icon;
    }

    /**
     * Dados de temperatura em graus celsius.
     *
     * @return Forecast15DTemperature - Dados de temperatura em graus celsius.
     */
    public Forecast15DTemperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Forecast15DTemperature temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return "\nData: " + this.getDate() + this.getHumidity() + "\n\n" + "Rain: " + this.getRain() + "\n" + "Wind: " + this.getWind()
                +  "\n" + "Thermal Sensation: " + this.getThermal_sensation() + "\n" + "Text Icon: " + this.getText_icon() + " - " + this.getTemperature();
    }
}


