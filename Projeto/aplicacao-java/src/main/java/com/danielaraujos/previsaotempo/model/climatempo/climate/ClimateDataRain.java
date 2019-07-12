package com.danielaraujos.previsaotempo.model.climatempo.climate;

public class ClimateDataRain {

    private Integer last_year;
    private Integer normal;
    private Integer forecast;

    public Integer getLast_year() {
        return last_year;
    }

    public void setLast_year(Integer last_year) {
        this.last_year = last_year;
    }

    public Integer getNormal() {
        return normal;
    }

    public void setNormal(Integer normal) {
        this.normal = normal;
    }

    public Integer getForecast() {
        return forecast;
    }

    public void setForecast(Integer forecast) {
        this.forecast = forecast;
    }
}
