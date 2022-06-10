package com.example.springbootform.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.springbootform.models.domain.User;

@Controller
public class FormController {

    @GetMapping("/form")
    public String formGet(Model model) {

        // Se manda un usuario vacio para que no proboque un error al intentar acceder a
        // sus atributos cuando no existe un modelo usuario
        User user = new User();

        user.setId("123.123.123-k");

        user.setName("Nombre por defecto");
        user.setLastName("Apellido por defecto");

        model.addAttribute("user", user);

        return "form";
    }

    /**
     * 
     * @param user                    Modelo que va almanecenar los datos del
     *                                formulario
     * @param @ModelAttribute("user") Nombre con el que se pasara el modelo User en
     *                                caso de que falle la validacion
     * @param result                  Contiene los errores de la formulario, este
     *                                parametro
     *                                siempre
     *                                debe estara la derecha del modelo user
     * 
     * @param model                   Modelo para pasar los datos a la vista
     * @return Nombre de la vista
     */

    @PostMapping("/form")
    public String formPost(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {

        if (result.hasErrors()) {
            return "form";
        }

        model.addAttribute("user", user);

        return "resultado";
    }

}