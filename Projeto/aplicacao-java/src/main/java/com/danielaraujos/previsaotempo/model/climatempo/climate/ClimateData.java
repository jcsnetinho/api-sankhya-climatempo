package com.danielaraujos.previsaotempo.model.climatempo.climate;


public class ClimateData {
    private String date;
    private String date_br;
    private ClimateDataRain climate_rain;

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

    public ClimateDataRain getClimate_rain() {
        return climate_rain;
    }

    public void setClimate_rain(ClimateDataRain climate_rain) {
        this.climate_rain = climate_rain;
    }
}
