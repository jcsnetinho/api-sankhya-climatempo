package com.danielaraujos.previsaotempo.model.climatempo.forecast.forecast15d;

/**
 * Classe representa o modelo da Previsão 15d dentro do Clima Tempo
 * -Dados de temperatura em graus celsius.
 * -Forecast15DTemperature
 *
 * @author Daniel Araújo
 */
public class Forecast15DTemperature {

    private double min;
    private double max;
    private Forecast15DGeneric dawn;
    private Forecast15DGeneric morning;
    private Forecast15DGeneric afternoon;
    private Forecast15DGeneric night;

    /**
     * Temperatura minima em graus celsius.
     *
     * @return double - Temperatura minima em graus celsius.
     */
    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    /**
     * Temperatura máxima em graus celsius.
     *
     * @return double - Temperatura máxima em graus celsius.
     */
    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    /**
     * Temperatura madrugada em graus celsius.
     *
     * @return Forecast15DGeneric - Temperatura madrugada em graus celsius.
     */
    public Forecast15DGeneric getDawn() {
        return dawn;
    }

    public void setDawn(Forecast15DGeneric dawn) {
        this.dawn = dawn;
    }

    /**
     * Temperatura manhã  em graus celsius.
     *
     * @return Forecast15DGeneric - Temperatura manhã  em graus celsius.
     */
    public Forecast15DGeneric getMorning() {
        return morning;
    }

    public void setMorning(Forecast15DGeneric morning) {
        this.morning = morning;
    }

    /**
     * Temperatura tarde   em graus celsius.
     *
     * @return Forecast15DGeneric - Temperatura tarde   em graus celsius.
     */
    public Forecast15DGeneric getAfternoon() {
        return afternoon;
    }

    public void setAfternoon(Forecast15DGeneric afternoon) {
        this.afternoon = afternoon;
    }

    /**
     * Temperatura noite em graus celsius.
     *
     * @return Forecast15DGeneric - Temperatura noite em graus celsius.
     */
    public Forecast15DGeneric getNight() {
        return night;
    }

    public void setNight(Forecast15DGeneric night) {
        this.night = night;
    }

    @Override
    public String toString() {
        return "\n--MIN: " + this.getMin() + "\n--MAX: " + this.getMax() +
                "\n--Dawn: " + this.getDawn() + "\n--Morning: " + this.getMorning() +
                "\n--Afternoon: " + this.getAfternoon() + "\n--Night: " + this.getNight() + "\n";
    }

}
