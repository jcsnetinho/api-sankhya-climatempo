package com.danielaraujos.previsaotempo.model.climatempo.history.historyWeather;

public class HistoryData {
    private String date;
    private String date_br;
    private HistoryDataRain rain;
    private HistoryDataTemperature temperature;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate_br() {
        return date_br;
    }

    public void setDate_br(String date_br) {
        this.date_br = date_br;
    }

    public HistoryDataRain getRain() {
        return rain;
    }

    public void setRain(HistoryDataRain rain) {
        this.rain = rain;
    }

    public HistoryDataTemperature getTemperature() {
        return temperature;
    }

    public void setTemperature(HistoryDataTemperature temperature) {
        this.temperature = temperature;
    }
}
