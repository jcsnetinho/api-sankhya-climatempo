package com.danielaraujos.previsaotempo.model.climatempo.history.historyRays;

public class HistoryRays {
    private String date;
    private String date_br;
    private String source;
    private HistoryRaysLocation location;

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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public HistoryRaysLocation getLocation() {
        return location;
    }

    public void setLocation(HistoryRaysLocation location) {
        this.location = location;
    }
}
