package com.bigasssolutions.pmc.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
@ComponentScan(basePackages = { "com.bigasssolutions.pmc" })
@PropertySource("classpath:config.properties")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Value("${persistenceunit.name}")
    private String persistenceUnit;

    @Bean
    public EntityManagerFactory entityManagerFactory() {
//        return entityManagerFactory.createEntityManager();
        return Persistence.createEntityManagerFactory(persistenceUnit);
    }

}
