package com.danielaraujos.previsaotempo.provider;

import java.text.Normalizer;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;


/**
 * Classe responsável pela manipulação de funções genéricas
 *
 * @author Daniel Araújo
 */
public class FunctionsGenerics {

    /**
     * Método responsável por manipular datas. Converter uma data String em Data no formato
     * Ano-Mes-Dia - Hora-Minutos-Segundos
     *
     * @param dataJson Data em String
     * @return Date - Retorna uma data
     **/
    public static Date converterDateWeather(String dataJson) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date data = formato.parse(dataJson);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Método responsável por manipular datas. Converter uma data String em Data no formato
     * Ano-Mes-Dia
     *
     * @param dataJson Data em String
     * @return Date - Retorna uma data
     **/
    public static Date converterDateExceptionHours(String dataJson) {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date data = formato.parse(dataJson);
            return data;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Método responsável por manipular Strings. Removendo todas acentuações e caracteres especiais.
     *
     * @param str Data em String
     * @return String - Retorna uma string sem acentos
     **/
    public static String removerAcentos(String str) {
        String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(nfdNormalizedString).replaceAll("");
    }
}
