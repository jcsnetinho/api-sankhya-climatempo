package com.danielaraujos.previsaotempo;

import com.danielaraujos.previsaotempo.provider.LoggerUtil;

/**
 * Classe principal
 *
 * @author Daniel Araújo
 */
public class Main {

    /**
     * Método principal.
     * @param args
     * @throws InterruptedException
     *
     **/
    public static void main(String[] args) throws InterruptedException {
        LoggerUtil.CreatLog();
        AcoesPrincipais.principal();
    }
}
