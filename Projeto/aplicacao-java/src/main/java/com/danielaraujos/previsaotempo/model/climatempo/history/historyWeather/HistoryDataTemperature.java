package com.danielaraujos.previsaotempo.model.climatempo.history.historyWeather;

public class HistoryDataTemperature {
    private double min;
    private double max;
    private String source;

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
