package com.example.springbootform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Autowired
    @Qualifier("tiempoTranscurridoInterceptor")
    private HandlerInterceptor tiempoTranscurridoInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // Agregamos el interceptor a todas las rutas que existan en el proyecto
        // registry.addInterceptor(tiempoTranscurridoInterceptor);

        // Agregamos el interceptor a un conjunto de rutas
        registry.addInterceptor(tiempoTranscurridoInterceptor).addPathPatterns("/form/**");

    }

}