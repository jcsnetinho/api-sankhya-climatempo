package com.danielaraujos.previsaotempo.model.climatempo.forecast.forecast72h;

/**
 * Classe representa o modelo da Previsão 72h dentro do Clima Tempo
 * Forecast72HDateRain
 *
 * @author Daniel Araújo
 */
public class Forecast72HDateRain {
    private float precipitation;

    /**
     * Precipitação em milímetro.
     *
     * @return float - Precipitação em milímetro.
     */
    public float getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(float precipitation) {
        this.precipitation = precipitation;
    }

    @Override
    public String toString() {
        return this.getPrecipitation() + "";
    }
}