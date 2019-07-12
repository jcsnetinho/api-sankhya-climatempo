package com.danielaraujos.previsaotempo.model.climatempo.forecast.forecast15d;

/**
 * Classe representa o modelo da Previsão 15d dentro do Clima Tempo
 * -Dados de humidade.
 * -Forecast15DHumidity
 *
 * @author Daniel Araújo
 */
public class Forecast15DHumidity {
    private double min;
    private double max;
    private Forecast15DGeneric dawn;
    private Forecast15DGeneric morning;
    private Forecast15DGeneric afternoon;
    private Forecast15DGeneric night;

    /**
     * Umidade Relativa minima (%).
     *
     * @return double - Umidade Relativa minima (%).
     */
    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    /**
     * Umidade Relativa máxima (%).
     *
     * @return double - Umidade Relativa máxima (%).
     */
    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    /**
     * Umidade Relativa madrugada (%).
     *
     * @return Forecast15DGeneric - Umidade Relativa madrugada (%).
     */
    public Forecast15DGeneric getDawn() {
        return dawn;
    }

    public void setDawn(Forecast15DGeneric dawn) {
        this.dawn = dawn;
    }

    /**
     * Umidade Relativa manhã (%).
     *
     * @return Forecast15DGeneric - Umidade Relativa manhã (%).
     */
    public Forecast15DGeneric getMorning() {
        return morning;
    }

    public void setMorning(Forecast15DGeneric morning) {
        this.morning = morning;
    }

    /**
     * Umidade Relativa tarde (%).
     *
     * @return Forecast15DGeneric - Umidade Relativa tarde (%).
     */
    public Forecast15DGeneric getAfternoon() {
        return afternoon;
    }

    public void setAfternoon(Forecast15DGeneric afternoon) {
        this.afternoon = afternoon;
    }

    /**
     * Umidade Relativa noite (%).
     *
     * @return Forecast15DGeneric - Umidade Relativa noite (%).
     */
    public Forecast15DGeneric getNight() {
        return night;
    }

    public void setNight(Forecast15DGeneric night) {
        this.night = night;
    }

    @Override
    public String toString() {
        return "\n\n Humidity:  MIN: " + this.getMin() + " - MAX: " + this.getMax() + "\n-- DAWN: " + this.getDawn() +
                "\n-- MORNING: " + this.getMorning() + "\n-- AFTERNOON:  " + this.getAfternoon() + "\n-- NIGHT: " + this.getNight();
    }
}
