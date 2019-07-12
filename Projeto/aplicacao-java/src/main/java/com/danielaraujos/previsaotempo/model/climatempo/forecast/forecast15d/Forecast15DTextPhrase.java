package com.danielaraujos.previsaotempo.model.climatempo.forecast.forecast15d;

/**
 * Classe representa o modelo da Previsão 15d dentro do Clima Tempo
 * -Frase de previsão.
 * -Forecast15DTextPhrase
 *
 * @author Daniel Araújo
 */
public class Forecast15DTextPhrase {

    private String reduced;
    private String morning;
    private String afternoon;
    private String night;
    private String dawn;

    /**
     * Frase de previsão do dia inteiro reduzida.
     *
     * @return String - Frase de previsão do dia inteiro reduzida.
     */
    public String getReduced() {
        return reduced;
    }

    public void setReduced(String reduced) {
        this.reduced = reduced;
    }

    /**
     * Frase de previsão manhã.
     *
     * @return String - Frase de previsão manhã.
     */
    public String getMorning() {
        return morning;
    }

    public void setMorning(String morning) {
        this.morning = morning;
    }

    /**
     * Frase de previsão tarde.
     *
     * @return String - Frase de previsão tarde.
     */
    public String getAfternoon() {
        return afternoon;
    }

    public void setAfternoon(String afternoon) {
        this.afternoon = afternoon;
    }

    /**
     * Frase de previsão noite.
     *
     * @return String - Frase de previsão noite.
     */
    public String getNight() {
        return night;
    }

    public void setNight(String night) {
        this.night = night;
    }

    /**
     * Frase de previsão madrugada.
     *
     * @return String -  Frase de previsão madrugada.
     */
    public String getDawn() {
        return dawn;
    }

    public void setDawn(String dawn) {
        this.dawn = dawn;
    }

    @Override
    public String toString() {
        return "\n--Reduced: " + this.getReduced() + "\n--Morning: " + this.getMorning()
                + "\n--Afternnon: " + this.getAfternoon() + "\n--Night: " + this.getNight()
                + "\n--Dawn: " + this.getDawn() + "\n";
    }
}
