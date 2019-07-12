package com.danielaraujos.previsaotempo;

import com.danielaraujos.previsaotempo.controller.*;
import com.danielaraujos.previsaotempo.model.climatempo.DefaultInterface;
import com.danielaraujos.previsaotempo.model.climatempo.city.City;
import com.danielaraujos.previsaotempo.model.climatempo.climate.Climate;
import com.danielaraujos.previsaotempo.model.climatempo.climate.ClimateData;
import com.danielaraujos.previsaotempo.model.climatempo.forecast.forecast15d.Forecast15D;
import com.danielaraujos.previsaotempo.model.climatempo.forecast.forecast15d.Forecast15DDate;
import com.danielaraujos.previsaotempo.model.climatempo.forecast.forecast72h.Forecast72H;
import com.danielaraujos.previsaotempo.model.climatempo.forecast.forecast72h.Forecast72HDate;
import com.danielaraujos.previsaotempo.model.climatempo.weather.Weather;
import com.danielaraujos.previsaotempo.model.sankhya.Estado;
import com.danielaraujos.previsaotempo.provider.API;
import com.danielaraujos.previsaotempo.provider.ExcecaoPersona;
import com.danielaraujos.previsaotempo.provider.FunctionsGenerics;
import org.apache.log4j.Logger;

import java.util.List;

public class Tarefas {

    private static Logger logger = Logger.getLogger(Tarefas.class);

    public static void ClimaAtualTarefas(Integer cidadeRequest, Integer cidadeSankhya) {

        logger.warn("Clima tempo atual");
        logger.info("URL DA REQUISIÇÃO: " + API.getUrlWeather(cidadeRequest));
        Weather weather = null;

        try {
            weather = new DefaultInterface().getWeatherJson(API.getUrlWeather(cidadeRequest));
            logger.info("URL DA REQUISIÇÃO: " + API.getUrlWeather(cidadeRequest));
        } catch (ExcecaoPersona excecaoPersona) {
            logger.error(excecaoPersona);
        }

        PrevisaoAtualController previsaoAtualController = new PrevisaoAtualController();

        if (weather != null) {
            if (previsaoAtualController.jaExisteInformacao(weather.getData().getDate().subSequence(0, 10).toString(), cidadeSankhya)) {
                System.out.print(".");
                logger.info(".");
                previsaoAtualController.atualizaPrevisaoAtual(
                        cidadeSankhya, weather.getData().getTemperature(), weather.getData().getWind_direction(), weather.getData().getWind_velocity(),
                        weather.getData().getHumidity(), weather.getData().getCondition(), weather.getData().getPressure(), weather.getData().getIcon(),
                        weather.getData().getSensation(), FunctionsGenerics.converterDateWeather(weather.getData().getDate()),
                        weather.getData().getDate().subSequence(0, 10).toString());
            } else {
                System.out.print("!");
                logger.info("!");
                previsaoAtualController.inserirPrevisaoAtual(
                        cidadeSankhya,
                        weather.getData().getTemperature(), weather.getData().getWind_direction(), weather.getData().getWind_velocity(),
                        weather.getData().getHumidity(), weather.getData().getCondition(), weather.getData().getPressure(),
                        weather.getData().getIcon(), weather.getData().getSensation(), FunctionsGenerics.converterDateWeather(weather.getData().getDate()));
            }
        } else {
            System.out.print("?");
            logger.error("?");
        }
    }


    public static void Previsao72hTarefas(Integer cidadeRequest, Integer cidadeSankhya) {

        logger.info("Previsao 72 horas");
        logger.info("URL DA REQUISIÇÃO: " + API.getUrlForecast72h(cidadeRequest));
        Forecast72H forecast = null;
        try {
            forecast = new DefaultInterface().getForecastJson(API.getUrlForecast72h(cidadeRequest));
            logger.info("URL DA REQUISIÇÃO: " + API.getUrlForecast72h(cidadeRequest));
        } catch (ExcecaoPersona excecaoPersona) {
            logger.error(excecaoPersona);
        }

        Previsao72hController previsao72hController = new Previsao72hController();

        if (forecast != null) {
            for (Forecast72HDate forecastDate : forecast.getData()) {
                if (previsao72hController.jaExisteInformacao(forecastDate.getDate(), cidadeSankhya)) {
                    System.out.print(".");
                    logger.info(".");
                    previsao72hController.atualizarPrevisao72h(cidadeSankhya, forecastDate.getDate(), forecastDate.getRain().getPrecipitation(),
                            forecastDate.getWind().getVelocity(), forecastDate.getWind().getDirection(), forecastDate.getWind().getGust(),
                            forecastDate.getWind().getDirectiondegrees(), forecastDate.getTemperature().getTemperature());
                } else {
                    System.out.print("!");
                    logger.info("!");
                    previsao72hController.inserirPrevisao72h(cidadeSankhya, FunctionsGenerics.converterDateWeather(forecastDate.getDate()),
                            forecastDate.getRain().getPrecipitation(), forecastDate.getWind().getVelocity(), forecastDate.getWind().getDirection(),
                            forecastDate.getWind().getDirectiondegrees(), forecastDate.getWind().getGust(), forecastDate.getTemperature().getTemperature());
                }
            }

        } else {
            System.out.print("?");
            logger.error("?");
        }
    }

    public static void Previsao15dTarefas(Integer cidadeRequest, Integer cidadeSankhya) {

        logger.info("Previsao 15 dias");
        Forecast15D forecast = null;
        logger.info("URL DA REQUISIÇÃO: " + API.getUrlForecast15d(cidadeRequest));
        try {
            forecast = new DefaultInterface().getGeoForecastJson(API.getUrlForecast15d(cidadeRequest));
        } catch (ExcecaoPersona excecaoPersona) {
            logger.error(excecaoPersona);
        }

        Previsao15dController previsao15dController = new Previsao15dController();

        if (forecast != null) {
            for (Forecast15DDate fordate : forecast.getData()) {

                if (previsao15dController.jaExisteInformacao(fordate.getDate(), cidadeSankhya)) {
                    System.out.print(".");
                    logger.info(".");

                    previsao15dController.atualizaPrevisao15d(cidadeSankhya, fordate.getDate(), fordate.getHumidity().getMin(),
                            fordate.getHumidity().getMax(), fordate.getHumidity().getDawn().getMin(), fordate.getHumidity().getDawn().getMax(),
                            fordate.getHumidity().getMorning().getMin(), fordate.getHumidity().getMorning().getMax(), fordate.getHumidity().getAfternoon().getMin(),
                            fordate.getHumidity().getAfternoon().getMax(), fordate.getHumidity().getNight().getMin(), fordate.getHumidity().getNight().getMax(),
                            fordate.getRain().getProbability(), fordate.getRain().getPrecipitation(), fordate.getWind().getVelocity_min(),
                            fordate.getWind().getVelocity_max(), fordate.getWind().getVelocity_avg(), fordate.getWind().getGust_max(),
                            fordate.getWind().getDirection_degrees(), fordate.getWind().getDirection(), fordate.getWind().getDawn().getDirection_degrees(),
                            fordate.getWind().getDawn().getDirection(), fordate.getWind().getDawn().getGust_max(), fordate.getWind().getDawn().getVelocity_max(),
                            fordate.getWind().getMorning().getDirection_degrees(), fordate.getWind().getMorning().getDirection(), fordate.getWind().getMorning().getGust_max(),
                            fordate.getWind().getMorning().getVelocity_max(), fordate.getWind().getAfternoon().getDirection_degrees(),
                            fordate.getWind().getAfternoon().getDirection(), fordate.getWind().getAfternoon().getGust_max(), fordate.getWind().getAfternoon().getVelocity_max(),
                            fordate.getWind().getNight().getDirection_degrees(), fordate.getWind().getNight().getDirection(), fordate.getWind().getNight().getGust_max(),
                            fordate.getWind().getNight().getVelocity_max(), 0, fordate.getThermal_sensation().getMin(), fordate.getThermal_sensation().getMax(),
                            fordate.getText_icon().getIcon().getDawn(), fordate.getText_icon().getIcon().getMorning(), fordate.getText_icon().getIcon().getAfternoon(),
                            fordate.getText_icon().getIcon().getNight(), fordate.getText_icon().getIcon().getDay(), fordate.getText_icon().getText().getPt(),
                            fordate.getText_icon().getText().getPhrase().getReduced(), fordate.getText_icon().getText().getPhrase().getDawn(),
                            fordate.getText_icon().getText().getPhrase().getMorning(), fordate.getText_icon().getText().getPhrase().getAfternoon(),
                            fordate.getText_icon().getText().getPhrase().getNight(), fordate.getTemperature().getMin(), fordate.getTemperature().getMax(),
                            fordate.getTemperature().getDawn().getMin(), fordate.getTemperature().getDawn().getMax(), fordate.getTemperature().getMorning().getMin(),
                            fordate.getTemperature().getMorning().getMax(), fordate.getTemperature().getAfternoon().getMin(), fordate.getTemperature().getAfternoon().getMax(),
                            fordate.getTemperature().getNight().getMin(), fordate.getTemperature().getNight().getMax());
                } else {
                    System.out.print("!");
                    logger.info("!");
                    previsao15dController.inserirPrevisao15d(cidadeSankhya, FunctionsGenerics.converterDateExceptionHours(fordate.getDate()),
                            fordate.getHumidity().getMin(), fordate.getHumidity().getMax(), fordate.getHumidity().getDawn().getMin(),
                            fordate.getHumidity().getDawn().getMax(), fordate.getHumidity().getMorning().getMin(), fordate.getHumidity().getMorning().getMax(),
                            fordate.getHumidity().getAfternoon().getMin(), fordate.getHumidity().getAfternoon().getMax(), fordate.getHumidity().getNight().getMin(),
                            fordate.getHumidity().getNight().getMax(), fordate.getRain().getProbability(), fordate.getRain().getPrecipitation(),
                            fordate.getWind().getVelocity_min(), fordate.getWind().getVelocity_max(), fordate.getWind().getVelocity_avg(), fordate.getWind().getGust_max(),
                            fordate.getWind().getDirection_degrees(), fordate.getWind().getDirection(), fordate.getWind().getDawn().getDirection_degrees(),
                            fordate.getWind().getDawn().getDirection(), fordate.getWind().getDawn().getGust_max(), fordate.getWind().getDawn().getVelocity_max(),
                            fordate.getWind().getMorning().getDirection_degrees(), fordate.getWind().getMorning().getDirection(), fordate.getWind().getMorning().getGust_max(),
                            fordate.getWind().getMorning().getVelocity_max(), fordate.getWind().getAfternoon().getDirection_degrees(), fordate.getWind().getAfternoon().getDirection(),
                            fordate.getWind().getAfternoon().getGust_max(), fordate.getWind().getAfternoon().getVelocity_max(), fordate.getWind().getNight().getDirection_degrees(),
                            fordate.getWind().getNight().getDirection(), fordate.getWind().getNight().getGust_max(), fordate.getWind().getNight().getVelocity_max(),
                            0, fordate.getThermal_sensation().getMin(), fordate.getThermal_sensation().getMax(), fordate.getText_icon().getIcon().getDawn(),
                            fordate.getText_icon().getIcon().getMorning(), fordate.getText_icon().getIcon().getAfternoon(), fordate.getText_icon().getIcon().getNight(),
                            fordate.getText_icon().getIcon().getDay(), fordate.getText_icon().getText().getPt(), fordate.getText_icon().getText().getPhrase().getReduced(),
                            fordate.getText_icon().getText().getPhrase().getDawn(), fordate.getText_icon().getText().getPhrase().getMorning(),
                            fordate.getText_icon().getText().getPhrase().getAfternoon(), fordate.getText_icon().getText().getPhrase().getNight(), fordate.getTemperature().getMin(),
                            fordate.getTemperature().getMax(), fordate.getTemperature().getDawn().getMin(), fordate.getTemperature().getDawn().getMax(), fordate.getTemperature().getMorning().getMin(),
                            fordate.getTemperature().getMorning().getMax(), fordate.getTemperature().getAfternoon().getMin(), fordate.getTemperature().getAfternoon().getMax(),
                            fordate.getTemperature().getNight().getMin(), fordate.getTemperature().getNight().getMax());
                }
            }
        } else {
            System.out.print("?");
            logger.error("?");
        }
    }

    public static void ChuvaClimaticaTarefas(Integer cidadeRequest, Integer cidadeSankhya) {

        logger.info("Request Climate");
        Climate climate = null;
        try {
            climate = new DefaultInterface().getClimateJson(API.getUrlClimate(cidadeRequest));
        } catch (ExcecaoPersona excecaoPersona) {
            logger.error(excecaoPersona);
        }
        ChuvaClimaticaController chuvaClimaticaController = new ChuvaClimaticaController();

        if (climate != null) {
            for (ClimateData climateData : climate.getData()) {
                System.out.print("!");
                chuvaClimaticaController.inserirChuvaClimatica(climate.getId(),
                        FunctionsGenerics.converterDateExceptionHours(climateData.getDate()),
                        climateData.getClimate_rain().getLast_year(), climateData.getClimate_rain().getNormal(),
                        climateData.getClimate_rain().getForecast());
            }
        } else {
            System.out.print("?");
            logger.error("?");
        }
    }


    public static void CidadeTarefas() throws InterruptedException {

        CidadeController cidadeController = new CidadeController();
        EstadoController estadoController = new EstadoController();
        int i = 0;

        List<Estado> estados = estadoController.getEstado();
        i = i + 1;
        System.out.println(i);
        City[] cities = null;

        for (Estado estado : estados) {
            System.out.println(estado.getDescricao());
            logger.info(estado.getDescricao());

            try {
                cities = new DefaultInterface().getCityJson(API.getUrlCity(estado.getUf()));
            } catch (ExcecaoPersona excecaoPersona) {
                logger.error(excecaoPersona);
            }

            if (cities != null) {
                for (City city : cities) {
                    String ponto = cidadeController.getCompararCidade(
                            city.getId(),
                            FunctionsGenerics.removerAcentos(city.getName()),
                            city.getState());
                    System.out.print(ponto);
                    logger.info(ponto);
                }
            } else {
                logger.error("?");
                System.out.println("?");
            }

            if (i == 9) {
                System.out.println("Aguardando 70 segundos");
                logger.info("Aguardando 70 segundos");
                Thread.sleep(70000);
                i = 0;
            }
            System.out.print("\n");
        }
    }
}