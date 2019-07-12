package com.danielaraujos.previsaotempo.model.climatempo.forecast.forecast15d;

/**
 * Classe representa o modelo da Previsão 15d dentro do Clima Tempo
 * -Dados de vento
 * -Forecast15DWindGeneric
 *
 * @author Daniel Araújo
 */
public class Forecast15DWindGeneric {

    private String direction;
    private double direction_degrees;
    private double gust_max;
    private double velocity_max;

    /**
     * Direção do vento
     *
     * @return String - Direção do vento
     */
    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    /**
     * Direção do vento em graus
     *
     * @return String - Direção do vento em graus
     */
    public double getDirection_degrees() {
        return direction_degrees;
    }

    public void setDirection_degrees(double direction_degrees) {
        this.direction_degrees = direction_degrees;
    }

    /**
     * Rajada máxima do vento madrugada em km/h.
     *
     * @return Double - Rajada máxima do vento em km/h.
     */
    public double getGust_max() {
        return gust_max;
    }

    public void setGust_max(double gust_max) {
        this.gust_max = gust_max;
    }

    /**
     * Intensidade máxima do vento em km/h.
     *
     * @return Double - Intensidade máxima do vento em km/h.
     */
    public double getVelocity_max() {
        return velocity_max;
    }

    public void setVelocity_max(double velocity_max) {
        this.velocity_max = velocity_max;
    }

    @Override
    public String toString() {
        return "\n---Direction: " + this.getDirection() + "\n---Direction_degrees: " + this.getDirection_degrees() +
                "\n---getGust Max: " + this.getGust_max() + "\n---Velocity Max: " + this.getVelocity_max() + "\n";
    }
}

