package com.projetocoach;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("application")
public class ProjetoCoachApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjetoCoachApplication.class, args);
    }
}
