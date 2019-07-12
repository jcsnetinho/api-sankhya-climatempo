package com.danielaraujos.previsaotempo.model.climatempo.history.historyRays;

import java.util.Map;

public class HistoryRaysLocation {
    private String type;
    private Map<String, String> coordinates;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, String> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Map<String, String> coordinates) {
        this.coordinates = coordinates;
    }
}
