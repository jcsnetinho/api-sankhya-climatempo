package com.danielaraujos.previsaotempo.model.climatempo.forecast.forecast72h;

/**
 * Classe representa o modelo da Previsão 72h dentro do Clima Tempo
 * Forecast72HDateWind
 *
 * @author Daniel Araújo
 */
public class Forecast72HDateWind {
    private float velocity;
    private String direction;
    private float directiondegrees;
    private float gust;

    /**
     * Intensidade do vento em km/h.
     *
     * @return float - Intensidade do vento em km/h.
     */
    public float getVelocity() {
        return velocity;
    }

    public void setVelocity(float velocity) {
        this.velocity = velocity;
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
     * Direção do vento em graus.
     *
     * @return float - Direção do vento em graus.
     */
    public float getDirectiondegrees() {
        return directiondegrees;
    }

    public void setDirectiondegrees(float directiondegrees) {
        this.directiondegrees = directiondegrees;
    }

    /**
     * Rajada do vento em km/h.
     *
     * @return float - Rajada do vento em km/h.
     */
    public float getGust() {
        return gust;
    }

    public void setGust(float gust) {
        this.gust = gust;
    }

    @Override
    public String toString() {
        return this.getDirection() + " - " + this.getDirectiondegrees() + " - " + this.getGust() + " - " + this.getVelocity();
    }
}
