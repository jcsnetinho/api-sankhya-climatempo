package com.danielaraujos.previsaotempo.provider;

import java.util.HashMap;
import java.util.Map;

public class  ErrorCode {

    private static Map<Integer, String> map;

    static {
        map = new HashMap<Integer, String>();
        map.put(0, "Diretorio não encontrado - Por favor criar o diretorio: Config/config.json.");
        map.put(404, "Not Found - Não foi possivel localizar requisição.");
        map.put(403, "Forbidden  - Diretório proibido.");
        map.put(429, "Too Many Requests - Foi atingido o máximo de requisição.");
        map.put(500, "Internal Server Error - Incompatibilidade ou configuração incorreta da aplicação Clima Tempo");
    }
    public static String fromCode(int code)
    {
        return map.get(code);
    }
}
