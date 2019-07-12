package com.danielaraujos.previsaotempo.model.climatempo.forecast.forecast15d;

/**
 * Classe representa o modelo da Previsão 15d dentro do Clima Tempo
 * -Texto de previsão.
 * -Forecast15DText
 *
 * @author Daniel Araújo
 */
public class Forecast15DText {
    private String pt;
    private Forecast15DTextPhrase phrase;

    /**
     * Texto de previsão em português.
     *
     * @return String - Texto de previsão em português.
     */
    public String getPt() {
        return pt;
    }

    public void setPt(String pt) {
        this.pt = pt;
    }

    /**
     * Frase de previsão.
     *
     * @return Forecast15DTextPhrase - Frase de previsão.
     */
    public Forecast15DTextPhrase getPhrase() {
        return phrase;
    }

    public void setPhrase(Forecast15DTextPhrase phrase) {
        this.phrase = phrase;
    }

    @Override
    public String toString() {
        return "\n--Pt: " + this.getPt() + "\n--Phrase: " + this.getPhrase() + "\n";
    }
}