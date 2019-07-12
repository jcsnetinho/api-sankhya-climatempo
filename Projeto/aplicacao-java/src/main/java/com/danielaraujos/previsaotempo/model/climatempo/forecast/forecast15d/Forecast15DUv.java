package com.danielaraujos.previsaotempo.model.climatempo.forecast.forecast15d;

/**
 * Classe representa o modelo da Previsão 15d dentro do Clima Tempo
 * -Dados de Radiação ultravioleta.
 * -Forecast15DUv
 *
 * @author Daniel Araújo
 */
public class Forecast15DUv {

    private double max;

    /**
     * Indice máaimo
     *
     * @return double - Indice máaimo.
     */
    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    @Override
    public String toString() {
        return "\n--Max: " + this.getMax() + "\n";
    }
}
