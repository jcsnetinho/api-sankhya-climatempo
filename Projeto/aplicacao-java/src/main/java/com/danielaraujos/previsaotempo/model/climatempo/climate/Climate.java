package com.danielaraujos.previsaotempo.model.climatempo.climate;

import java.util.List;

public class Climate {

    private int id;
    private String name;
    private String state;
    private String country;
    private List<ClimateData> data;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public List<ClimateData> getData() {
        return data;
    }

    public void setData(List<ClimateData> data) {
        this.data = data;
    }
}
