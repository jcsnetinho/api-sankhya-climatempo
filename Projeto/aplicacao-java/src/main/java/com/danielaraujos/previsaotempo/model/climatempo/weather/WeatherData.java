package com.danielaraujos.previsaotempo.model.climatempo.weather;

/**
 * Classe representa o modelo da Previsão Atual dentro do Clima Tempo
 * Dados de tempo no momento para a cidade.
 * WeatherData
 *
 * @author Daniel Araújo
 */
public class WeatherData {
    private double temperature;
    private String wind_direction;
    private double wind_velocity;
    private double humidity;
    private String condition;
    private double pressure;
    private String icon;
    private int sensation;
    private String date;

    /**
     * Temperatura em graus celsius (°C).
     *
     * @return double - Temperatura em graus celsius (°C).
     */
    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    /**
     * Direção do vento.
     *
     * @return String - Direção do vento.
     */
    public String getWind_direction() {
        return wind_direction;
    }

    public void setWind_direction(String wind_direction) {
        this.wind_direction = wind_direction;
    }

    /**
     * Intensidade do vento em km/h.
     *
     * @return double - Intensidade do vento em km/h.
     */
    public double getWind_velocity() {
        return wind_velocity;
    }

    public void setWind_velocity(double wind_velocity) {
        this.wind_velocity = wind_velocity;
    }

    /**
     * Umidade relativa do ar (%).
     *
     * @return double - Umidade relativa do ar (%).
     */
    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    /**
     * Condição
     *
     * @return String - Condição
     */
    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    /**
     * Pressão (hPa).
     *
     * @return double - Pressão (hPa).
     */
    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    /**
     * Sensação em graus celsius (°C).
     *
     * @return Integer - Sensação em graus celsius (°C).
     */
    public int getSensation() {
        return sensation;
    }

    public void setSensation(int sensation) {
        this.sensation = sensation;
    }

    /**
     * Icone da previsão
     *
     * @return String - Icone da previsão
     */
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    /**
     * Data
     *
     * @return String - Data
     */
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return this.getTemperature() + " - " + this.getWind_velocity() + " - " + this.getWind_direction() +
                " - " + this.getHumidity() + " - " + this.getCondition() + " - " + this.getPressure() +
                " - " + this.getSensation() + " - " + this.getDate();
    }
}
