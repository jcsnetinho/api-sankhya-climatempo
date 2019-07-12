package com.danielaraujos.previsaotempo.model.climatempo.forecast.forecast15d;

/**
 * Classe representa o modelo da Previsão 15d dentro do Clima Tempo
 * -Dados de chuva.
 * -Forecast15DRain
 *
 * @author Daniel Araújo
 */
public class Forecast15DRain {
    private double probability;
    private double precipitation;

    /**
     * Probabilidade de chuva em porcentagem.
     *
     * @return Integer - Probabilidade de chuva em porcentagem.
     */
    public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    /**
     * Precipitação em milímetro.
     *
     * @return Integer - Precipitação em milímetro.
     */
    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    @Override
    public String toString() {
        return "\n--Precipitation: "+this.getPrecipitation()+  "\n--Probability: "+this.getProbability()+ "\n";
    }
}
