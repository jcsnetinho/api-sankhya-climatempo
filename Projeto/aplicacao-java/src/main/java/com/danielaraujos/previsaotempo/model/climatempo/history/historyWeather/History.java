package com.danielaraujos.previsaotempo.model.climatempo.history.historyWeather;

import java.util.List;

public class History {
    private Integer id;
    private String name;
    private String state;
    private String country;
    private List<HistoryData> data;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<HistoryData> getData() {
        return data;
    }

    public void setData(List<HistoryData> data) {
        this.data = data;
    }
}
