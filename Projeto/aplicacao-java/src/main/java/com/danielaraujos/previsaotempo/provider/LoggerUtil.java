package com.danielaraujos.previsaotempo.provider;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;

public class LoggerUtil {

    private static Logger logger = Logger.getLogger(LoggerUtil.class);
    public static void CreatLog() {
        try {
            File log4jfile = new File("src/main/resources/config/log4j.properties");
            PropertyConfigurator.configure(log4jfile.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Problema na leitura do arquivo:log4j.properties");
            System.exit(0);
        }

        //Desable log Hibernate
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);
    }
}
