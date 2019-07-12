package com.danielaraujos.previsaotempo.provider;

import com.danielaraujos.previsaotempo.model.climatempo.DefaultInterface;
import com.danielaraujos.previsaotempo.model.preferencias.Config;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public class JPAUtil {

    private static EntityManagerFactory entityManagerFactory;
    private static Logger logger = Logger.getLogger(JPAUtil.class);

    static {
        try {
            try {
                Config config = new DefaultInterface().getConfig("src/main/resources/config/config.json");

                Map<String, Object> configOverrides = new HashMap<String, Object>();
                configOverrides.put("javax.persistence.jdbc.driver", config.getDriver());
                configOverrides.put("hibernate.dialect", config.getDialeto());
                configOverrides.put("javax.persistence.jdbc.url", config.getUrl());
                configOverrides.put("javax.persistence.jdbc.user", config.getUsuario());
                configOverrides.put("javax.persistence.jdbc.password", config.getSenha());
                entityManagerFactory = Persistence.createEntityManagerFactory("mapeamento", configOverrides);

            } catch (ExcecaoPersona e) {
                System.out.println(e);
                logger.error(e);
                System.exit(0);
            }

        } catch (HibernateException exception) {
            System.out.println("Problem creating session factory");
            exception.printStackTrace();
        } catch (Throwable ex) {
            System.out.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
