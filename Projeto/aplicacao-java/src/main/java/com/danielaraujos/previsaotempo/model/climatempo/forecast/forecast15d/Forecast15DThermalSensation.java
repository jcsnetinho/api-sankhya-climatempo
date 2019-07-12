package com.danielaraujos.previsaotempo.model.climatempo.forecast.forecast15d;

/**
 * Classe representa o modelo da Previsão 15d dentro do Clima Tempo
 * -Dados de sensação termica.
 * -Forecast15DThermalSensation
 *
 * @author Daniel Araújo
 */
public class Forecast15DThermalSensation {
    private double min;
    private double max;

    /**
     * Sensação termica miníma (°C).
     *
     * @return double - Sensação termica miníma (°C).
     */
    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    /**
     * Sensação termica máxima (°C).
     *
     * @return double - Sensação termica máxima (°C).
     */
    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return "\n--Min: " + this.getMin() + "\n--Max: " + this.getMax() + "\n";
    }
}
