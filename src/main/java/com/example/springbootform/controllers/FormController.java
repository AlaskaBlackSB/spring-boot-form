package com.example.springbootform.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.springbootform.editors.CountryPropertyEditor;
import com.example.springbootform.editors.NombreMayusculaEditor;
import com.example.springbootform.editors.RolesPropertyEditor;
import com.example.springbootform.models.domain.Country;
import com.example.springbootform.models.domain.Role;
import com.example.springbootform.models.domain.User;
import com.example.springbootform.services.CountryService;
import com.example.springbootform.services.RoleService;
import com.example.springbootform.validations.UserValidator;

@Controller
// Va mantener el modelo user los va a mantener de forma persistente
@SessionAttributes("user")
public class FormController {

    @Autowired
    private UserValidator validator;

    @Autowired
    private CountryService countryService;

    @Autowired
    private CountryPropertyEditor countryEditor;

    @Autowired
    private RoleService roleService;

    @Autowired
    private RolesPropertyEditor rolesEditor;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // Valida solo con con la clase UserValidator y no valida las anotaciones @ de
        // la clase User
        // binder.setValidator(validator);

        // Valida con la clase UserValidator y con las anotaciones @ en la clase User
        binder.addValidators(validator);

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        // Evita que reciba fechas con mal formato y que las auto corrija
        dateFormat.setLenient(false);

        // Cambia el formado de la fecha a yyyyy-MM-dd SOLO al atributo date, si se
        // quiere aplicar a TODOS los atributos, se tiene que eliminar el nombre del
        // campo, en este caso <date>
        binder.registerCustomEditor(Date.class, "date", new CustomDateEditor(dateFormat, false));

        // Convierte a mayusculas el campo <name>
        binder.registerCustomEditor(String.class, "name", new NombreMayusculaEditor());

        // Convierte a mayusculas el campo <lastName>
        binder.registerCustomEditor(String.class, "lastName", new NombreMayusculaEditor());

        // Rellena la lista de paises
        binder.registerCustomEditor(Country.class, "country", countryEditor);

        // Rellena los checkboxes de los roles
        binder.registerCustomEditor(Role.class, "roles", rolesEditor);

    }

    @GetMapping("/form")
    public String formGet(Model model) {

        // Se manda un usuario vacio para que no proboque un error al intentar acceder a
        // sus atributos cuando no existe un modelo usuario
        User user = new User();

        user.setPattern("12.123.123-S");
        user.setEnabled(true);
        user.setUsername("algo");
        user.setEmail("algo@algo.com");
        user.setCuenta(1234);
        user.setSecretValue("esto es secreto");

        user.setRoles(Arrays.asList(
                new Role(2, "User", "ROLE_USER"),
                new Role(1, "Administrator", "ROLE_ADMIN")));
        user.setCountry(new Country(1, "MX", "México"));

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

        // Valida el campo patterns
        // validator.validate(user, result);

        if (result.hasErrors()) {
            return "form";
        }

        return "redirect:/ver";
    }

    // Este metodo es para mostrar la informacion y se evite el reenvio del
    // formulario al recargar la pagina
    @GetMapping("/ver")
    public String ver(@SessionAttribute(name = "user", required = false) User user, Model model, SessionStatus status) {

        // Una vez se muestra toda la informacion, no se podra actualizar la pagina
        // porque sino te redirige al formulario ya que el user se habra eliminado de la
        // sesion
        if (user == null) {
            return "redirect:/form";
        }

        // Debido a quie ya se esta inyectando el modelo <User> con:
        // @SessionAttribute("user") User user, ya no es necesario agregar un atributo
        // con model.addAttribute("user", user);

        // Elimina el modelo user de la sesion
        status.setComplete();
        return "resultado";
    }

    @ModelAttribute("countries")
    public List<String> countries() {

        return Arrays.asList("México", "USA", "España", "Chile");
    }

    @ModelAttribute("countriesList")
    public List<Country> countriesList() {

        return Arrays.asList(
                new Country(1, "MX", "México"),
                new Country(2, "ES", "España"),
                new Country(3, "CL", "Chile"),
                new Country(4, "CO", "Colombia"),
                new Country(5, "PE", "Perú"));
    }

    @ModelAttribute("countriesMap")
    public Map<String, String> countriesMap() {

        Map<String, String> countries = new HashMap<String, String>();

        countries.put("ES", "España");
        countries.put("MX", "México");
        countries.put("CL", "Chile");
        countries.put("PE", "Peru");
        countries.put("CO", "Colombia");
        countries.put("VE", "Venezuela");

        return countries;

    }

    @ModelAttribute("rolesList")
    public List<String> getRoles() {
        List<String> roles = new ArrayList<>();

        roles.add("ROLE_ADMIN");
        roles.add("ROLE_USER");
        roles.add("ROLE_MODERATOR");

        return roles;
    }

    @ModelAttribute("rolesMap")
    public Map<String, String> getRolesMap() {
        Map<String, String> roles = new HashMap<String, String>();

        roles.put("ROLE_ADMIN", "Administrator");
        roles.put("ROLE_USER", "User");
        roles.put("ROLE_MODERATOR", "Moderator");

        return roles;
    }

    @ModelAttribute("rolesListModel")
    public List<Role> getRolesModel() {
        return this.roleService.all();
    }

    @ModelAttribute("genders")
    public List<String> getGenders() {
        return Arrays.asList("Hombre", "Mujer");
    }

}