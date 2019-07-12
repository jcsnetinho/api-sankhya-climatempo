package com.danielaraujos.previsaotempo.model.climatempo.forecast.forecast15d;

/**
 * Classe representa o modelo da Previsão 15d dentro do Clima Tempo
 * Forecast15DGeneric
 *
 * @author Daniel Araújo
 */
public class Forecast15DGeneric {
    private double min;
    private double max;

    /**
     * Minimo em graus celsius.
     *
     * @return Double - Minimo em graus celsius.
     */
    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    /**
     * Máxima em graus celsius.
     *
     * @return Double - Máxima em graus celsius.
     */
    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return ": " + this.getMin() + " - " + this.getMax();
    }
}