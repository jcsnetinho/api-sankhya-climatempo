package com.danielaraujos.previsaotempo.model.climatempo.forecast.forecast15d;

/**
 * Classe representa o modelo da Previsão 15d dentro do Clima Tempo
 * -Dados de vento.
 * -Forecast15DWind
 *
 * @author Daniel Araújo
 */
public class Forecast15DWind {

    private double velocity_min;
    private double velocity_max;
    private double velocity_avg;
    private double gust_max;
    private double direction_degrees;
    private String direction;
    private Forecast15DWindGeneric dawn;
    private Forecast15DWindGeneric morning;
    private Forecast15DWindGeneric afternoon;
    private Forecast15DWindGeneric night;


    /**
     * Intensidade minima do vento em km/h.
     *
     * @return double - Intensidade minima do vento em km/h.
     */
    public double getVelocity_min() {
        return velocity_min;
    }

    public void setVelocity_min(double velocity_min) {
        this.velocity_min = velocity_min;
    }

    /**
     * Intensidade máxima  do vento em km/h.
     *
     * @return double - Intensidade máxima  do vento em km/h.
     */
    public double getVelocity_max() {
        return velocity_max;
    }

    public void setVelocity_max(double velocity_max) {
        this.velocity_max = velocity_max;
    }

    /**
     * Intensidade média   do vento em km/h.
     *
     * @return double - Intensidade média   do vento em km/h.
     */
    public double getVelocity_avg() {
        return velocity_avg;
    }

    public void setVelocity_avg(double velocity_avg) {
        this.velocity_avg = velocity_avg;
    }

    /**
     * Rajada máxima do vento em km/h.
     *
     * @return double - Rajada máxima do vento em km/h.
     */
    public double getGust_max() {
        return gust_max;
    }

    public void setGust_max(double gust_max) {
        this.gust_max = gust_max;
    }

    /**
     * Direção do vento em graus.
     *
     * @return double - Direção do vento em graus.
     */
    public double getDirection_degrees() {
        return direction_degrees;
    }

    public void setDirection_degrees(double direction_degrees) {
        this.direction_degrees = direction_degrees;
    }

    /**
     * Direção do vento.
     *
     * @return String - Direção do vento.
     */
    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * Dados de vento madrugada.
     *
     * @return Forecast15DWindGeneric - Dados de vento madrugada.
     */
    public Forecast15DWindGeneric getDawn() {
        return dawn;
    }

    public void setDawn(Forecast15DWindGeneric dawn) {
        this.dawn = dawn;
    }

    /**
     * Dados de vento manhã.
     *
     * @return Forecast15DWindGeneric - Dados de vento manhã.
     */
    public Forecast15DWindGeneric getMorning() {
        return morning;
    }

    public void setMorning(Forecast15DWindGeneric morning) {
        this.morning = morning;
    }

    /**
     * Dados de vento tarde.
     *
     * @return Forecast15DWindGeneric - Dados de vento tarde.
     */
    public Forecast15DWindGeneric getAfternoon() {
        return afternoon;
    }

    public void setAfternoon(Forecast15DWindGeneric afternoon) {
        this.afternoon = afternoon;
    }

    /**
     * Dados de vento noite.
     *
     * @return Forecast15DWindGeneric - Dados de vento noite.
     */
    public Forecast15DWindGeneric getNight() {
        return night;
    }

    public void setNight(Forecast15DWindGeneric night) {
        this.night = night;
    }

    @Override
    public String toString() {
        return "\n--Velocity Min: " + this.getVelocity_min() + "\n--Velocity Max: " + this.getVelocity_max() +
                "\n--Velocity Avg: " + this.getVelocity_avg() + "\n--Gust Max: " + this.getGust_max() +
                "\n--Direction Degress: " + this.getDirection_degrees() + "\n--Direction: " + this.getDirection() +
                "\n--Dawn: " + this.getDawn() + "\n--Morning: " + this.getMorning() +
                "\n--Afternoon: " + this.getAfternoon() + "\n--Night: " + this.getNight() + "\n";
    }
}