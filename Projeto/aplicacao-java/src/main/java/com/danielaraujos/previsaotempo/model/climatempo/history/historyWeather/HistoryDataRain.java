package com.danielaraujos.previsaotempo.model.climatempo.history.historyWeather;

public class HistoryDataRain {
    private double precipitation;
    private String source;

    public double getPrecipitation() {
        return precipitation;
    }

    public void setPrecipitation(double precipitation) {
        this.precipitation = precipitation;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
