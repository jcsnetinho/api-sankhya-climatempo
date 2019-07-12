package com.danielaraujos.previsaotempo.model.climatempo.forecast.forecast72h;

/**
 * Classe representa o modelo da Previsão 72h dentro do Clima Tempo
 * Forecast72HDateTemperature
 *
 * @author Daniel Araújo
 */
public class Forecast72HDateTemperature {
    private float temperature;

    /**
     * Temperatura em graus celsius.
     *
     * @return float - Temperatura em graus celsius.
     */
    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    @Override
    public String toString() {
        return this.getTemperature()+  "";
    }
}