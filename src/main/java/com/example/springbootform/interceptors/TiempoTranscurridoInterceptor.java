package com.example.springbootform.interceptors;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component("tiempoTranscurridoInterceptor")
public class TiempoTranscurridoInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(TiempoTranscurridoInterceptor.class);

    // Este metodo sera ejecutado despues de una peticion
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {

        if (request.getMethod().equalsIgnoreCase("post")) {
            return;
        }

        logger.info("TiempoTranscurridoInterceptor: postHandle() saliendo...");
        logger.info("Interceptando: " + handler);

        long tiempoFinal = System.currentTimeMillis();

        long tiempoTranscurrido = tiempoFinal - (Long) request.getAttribute("tiempoInicial");

        // Comprueba que el modelo y la vista no sea nulo
        if (handler instanceof HandlerMethod && modelAndView != null) {
            // Pasamos el tiempo a la vista
            modelAndView.addObject("tiempoTranscurrido", tiempoTranscurrido);
        }

        logger.info("TiempoTranscurrido: " + tiempoTranscurrido);

    }

    // Este metodo sera ejecutado antes de una peticion
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        if (request.getMethod().equalsIgnoreCase("post")) {
            return true;
        }

        logger.info("TiempoTranscurridoInterceptor: preHandle() entrando...");

        long tiempoInicial = System.currentTimeMillis();
        request.setAttribute("tiempoInicial", tiempoInicial);

        Random random = new Random();
        Integer delay = random.nextInt(100); // Milisegundos entre 0 y 499
        Thread.sleep(delay);

        return true;
    }

}