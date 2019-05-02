package com.example.proyectofinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SuppressWarnings("ALL")
@SpringBootApplication

public class ProyectofinalApplication {

    @SuppressWarnings("PackageAccessibility")
    public static void main(String[] args) {
        SpringApplication.run(ProyectofinalApplication.class, args);
    }

    //disable autoconfiguration spring security
    /*@Configuration
    static class ApplicationSecurity extends WebSecurityConfigurerAdapter{
        @Override
        public void configure(WebSecurity web)throws Exception{
            web.ignoring()
                    .antMatchers("/**");
        }
    }*/
}
