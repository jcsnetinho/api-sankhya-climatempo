package com.danielaraujos.previsaotempo.provider;

import com.danielaraujos.previsaotempo.controller.ParametrosController;

public class API {

    private static String PATH_REQUEST = "https://apiadvisor.climatempo.com.br/api/v1/";

    public static String PATH_TOKEN = ParametrosController.getToken().getTexto();

    public static String getUrlWeather (int cidade){
        return PATH_REQUEST+"weather/locale/"+cidade+"/current?token="+ PATH_TOKEN;
    }

    public static String getUrlForecast72h (int cidade){
        return PATH_REQUEST+"forecast/locale/"+cidade+"/hours/72?token="+ PATH_TOKEN;
    }

    public static String getUrlForecast15d (int cidade){
        return PATH_REQUEST+"forecast/locale/"+cidade+"/days/15?token="+ PATH_TOKEN;
    }

    public static String getUrlClimate (int cidade){
        return PATH_REQUEST+"climate/rain/locale/"+cidade+"?token="+ PATH_TOKEN;
    }

    public static String getUrlCity (String sigla){
        return PATH_REQUEST+"locale/city?state="+sigla+"&token="+ PATH_TOKEN;
    }

    public static String getUrlHistoryRain (int cidade, String data){
        return PATH_REQUEST+"history/locale/"+cidade+"?token="+ PATH_TOKEN + "&from="+data;
    }

    public static String getUrlHistoryRays ( String dataInicial, String dataFinal,String latitude, String londitude){
        return PATH_REQUEST+"lightning/strikes?token="+ PATH_TOKEN + "&from=" +
                dataInicial+"&to="+dataFinal+"&latitude="+latitude+"&longitude="+londitude;
    }

    public static String getUrlGeoReferencedForecast15d (String latitude, String londitude){
        return PATH_REQUEST+"forecast/geo/days/15?latitude="+latitude+"&longitude="+londitude+"&token="+ PATH_TOKEN;
    }

    public static String getUrlGeoReferencedForecast72h (String latitude, String londitude){
        return PATH_REQUEST+"forecast/geo/hours/72?latitude="+latitude+"&longitude="+londitude+"&token="+ PATH_TOKEN;
    }

}