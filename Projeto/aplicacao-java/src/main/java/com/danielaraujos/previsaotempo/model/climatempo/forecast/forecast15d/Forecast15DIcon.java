package com.danielaraujos.previsaotempo.model.climatempo.forecast.forecast15d;

/**
 * Classe representa o modelo da Previsão 15d dentro do Clima Tempo
 * -Icone da previsão
 * -Forecast15DIcon
 *
 * @author Daniel Araújo
 */
public class Forecast15DIcon {

    private String dawn;
    private String morning;
    private String afternoon;
    private String night;
    private String day;

    /**
     * Icone madrugada.
     *
     * @return String - Icone madrugada.
     */
    public String getDawn() {
        return dawn;
    }

    public void setDawn(String dawn) {
        this.dawn = dawn;
    }

    /**
     * Icone manhã.
     *
     * @return String - Icone manhã.
     */
    public String getMorning() {
        return morning;
    }

    public void setMorning(String morning) {
        this.morning = morning;
    }

    /**
     * Icone tarde.
     *
     * @return String - Icone tarde.
     */
    public String getAfternoon() {
        return afternoon;
    }

    public void setAfternoon(String afternoon) {
        this.afternoon = afternoon;
    }

    /**
     * Icone noite.
     *
     * @return String - Icone noite.
     */
    public String getNight() {
        return night;
    }

    public void setNight(String night) {
        this.night = night;
    }

    /**
     * Icone  dia inteiro.
     *
     * @return String - Icone  dia inteiro.
     */
    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "\n--Dawn: " + this.getDawn() + "\n--Morning: " + this.getMorning() +
                "\n--Afternoon: " + this.getAfternoon() + "\n--Night: " + this.getNight() + "\n";
    }
}
