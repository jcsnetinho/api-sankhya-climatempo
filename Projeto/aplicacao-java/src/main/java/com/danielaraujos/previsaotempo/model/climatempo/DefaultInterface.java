package com.danielaraujos.previsaotempo.model.climatempo;

import com.danielaraujos.previsaotempo.model.climatempo.city.City;
import com.danielaraujos.previsaotempo.model.climatempo.climate.Climate;
import com.danielaraujos.previsaotempo.model.climatempo.forecast.forecast15d.Forecast15D;
import com.danielaraujos.previsaotempo.model.climatempo.forecast.forecast72h.Forecast72H;
import com.danielaraujos.previsaotempo.model.climatempo.weather.Weather;
import com.danielaraujos.previsaotempo.model.preferencias.Config;
import com.danielaraujos.previsaotempo.provider.ErrorCode;
import com.danielaraujos.previsaotempo.provider.ExcecaoPersona;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import org.apache.log4j.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DefaultInterface {

    /*
     * Metodo generico para fazer as requisições
     * @return Object - Returna o Json das informações
     **/

    /*
    -- PROBLEMA NA FUNÇÃO
    public Object getInfo(String url, Class tClass) {
        Client c = Client.create();
        WebResource wr = c.resource(url);
        String json = wr.get(String.class);
        Gson gson = new GsonBuilder().create();
        return gson.fromJson(json, tClass);
    }
    */


    public Object getInfo(String url, Class tClass) {
        Gson gson = new GsonBuilder().create();
        try {
            URL newURL = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) newURL.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
            conn.connect();

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));

            return gson.fromJson(br, tClass);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return gson;
    }

    public Weather getWeatherJson(String url) throws ExcecaoPersona {
        try {
            return (Weather) getInfo(url, Weather.class);
        } catch (UniformInterfaceException e) {
            throw new ExcecaoPersona(e.getResponse().getStatus(), ErrorCode.fromCode(e.getResponse().getStatus()));
        }
    }

    public Forecast72H getForecastJson(String url) throws ExcecaoPersona {
        try {
            return (Forecast72H) getInfo(url, Forecast72H.class);
        } catch (UniformInterfaceException e) {
            throw new ExcecaoPersona(e.getResponse().getStatus(), ErrorCode.fromCode(e.getResponse().getStatus()));
        }
    }

    public Forecast15D getGeoForecastJson(String url) throws ExcecaoPersona {
        try {
            return (Forecast15D) getInfo(url, Forecast15D.class);
        } catch (UniformInterfaceException e) {
            throw new ExcecaoPersona(e.getResponse().getStatus(), ErrorCode.fromCode(e.getResponse().getStatus()));
        }
    }

    public City[] getCityJson(String url)throws ExcecaoPersona {
        try {
            Client c = Client.create();
            WebResource wr = c.resource(url);
            String json = wr.get(String.class);
            Gson gson = new GsonBuilder().create();
            return gson.fromJson(json, City[].class);
        } catch (UniformInterfaceException e) {
            throw new ExcecaoPersona(e.getResponse().getStatus(), ErrorCode.fromCode(e.getResponse().getStatus()));
        }
    }

    public Climate getClimateJson(String url) throws ExcecaoPersona {
        try {
            return (Climate) getInfo(url, Climate.class);
        } catch (UniformInterfaceException e) {
            throw new ExcecaoPersona(e.getResponse().getStatus(), ErrorCode.fromCode(e.getResponse().getStatus()));
        }
    }

    public Config getConfig(String diretorio) throws ExcecaoPersona  {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(diretorio));
            Gson gson = new GsonBuilder().create();
            return gson.fromJson(bufferedReader, Config.class);
        } catch (Exception e) {
            throw new ExcecaoPersona(0, ErrorCode.fromCode(0));
        }
    }
}