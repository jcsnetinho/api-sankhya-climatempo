package com.danielaraujos.previsaotempo.model.climatempo.forecast.forecast15d;

/**
 * Classe representa o modelo da Previsão 15d dentro do Clima Tempo
 * -Icone e Texto de previsão.
 * -Forecast15DTextIcon
 *
 * @author Daniel Araújo
 */
public class Forecast15DTextIcon {

    private Forecast15DIcon icon;
    private Forecast15DText text;

    /**
     * Icone da previsão
     *
     * @return Forecast15DIcon - Icone da previsão
     */
    public Forecast15DIcon getIcon() {
        return icon;
    }

    public void setIcon(Forecast15DIcon icon) {
        this.icon = icon;
    }

    /**
     * Texto de previsão.
     *
     * @return Forecast15DText - Texto de previsão.
     */
    public Forecast15DText getText() {
        return text;
    }

    public void setText(Forecast15DText text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "\n-Icon: " + this.getIcon() + "\n-Texto: " + this.getText() + "\n";
    }
}

