package com.example.springbootform.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springbootform.models.domain.User;

@Controller
public class FormController {

    @GetMapping("/form")
    public String formGet(Model model) {

        // Se manda un usuario vacio para que no proboque un error al intentar acceder a
        // sus atributos cuando no existe un modelo usuario
        User user = new User();
        model.addAttribute("user", user);

        return "form";
    }

    /**
     * 
     * @param user   Modelo que va almanecenar los datos del formulario
     * @param result Contiene los errores de la formulario, este parametro siempre
     *               debe estara la derecha del modelo user
     * 
     * @param model  Modelo para pasar los datos a la vista
     * @return Nombre de la vista
     */

    @PostMapping("/form")
    public String formPost(@Valid User user, BindingResult result, Model model) {

        if (result.hasErrors()) {
            Map<String, String> errors = new HashMap<>();

            // Forma manual de obtener los errores
            result.getFieldErrors().forEach(err -> {
                errors.put(err.getField(),
                        "El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
            });

            model.addAttribute("errors", errors);

            return "form";
        }

        model.addAttribute("user", user);

        return "resultado";
    }

}