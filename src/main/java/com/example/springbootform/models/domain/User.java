package com.example.springbootform.models.domain;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
// import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

// import org.springframework.format.annotation.DateTimeFormat;

import com.example.springbootform.validations.IdentificadorRegex;
import com.example.springbootform.validations.Required;

public class User {

    private String id;

    // \\d indica numeros de 0 al 9
    // @Pattern(regexp = "[\\d]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")
    @IdentificadorRegex
    private String pattern;

    // @NotEmpty(message = "El nombre es obligatorio.")
    private String name;

    // @NotEmpty
    @Required
    private String lastName;

    @NotBlank // Valida si tiene espacios en blanco
    @Size(min = 3, max = 8)
    private String username;

    @NotEmpty
    @Size(min = 3, max = 8)
    private String password;

    @NotEmpty
    @Email(message = "Formato incorrecto de Email.")
    private String email;

    @NotNull // Es para objetos
    @Min(5)
    @Max(5000)
    private Integer cuenta;

    @NotNull
    // @DateTimeFormat(pattern = "yyyy-MM-dd")
    // @Past
    @Future
    private Date date;

    // @NotEmpty
    // private String country;

    @NotNull
    private Country country;

    @NotEmpty
    private List<Role> roles;

    private Boolean enabled;

    @NotEmpty
    private String gender;

    // Este valor no sera modificado con el formulario
    private String secretValue;

    public User() {
    }

    public User(String username, String password, String email, String gender) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.gender = gender;
    }

    /**
     * @return String return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return String return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return String return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return String return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return String return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return String return the pattern
     */
    public String getPattern() {
        return pattern;
    }

    /**
     * @param pattern the pattern to set
     */
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /**
     * @return Integer return the cuenta
     */
    public Integer getCuenta() {
        return cuenta;
    }

    /**
     * @param cuenta the cuenta to set
     */
    public void setCuenta(Integer cuenta) {
        this.cuenta = cuenta;
    }

    /**
     * @return Date return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return Country return the country
     */
    public Country getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(Country country) {
        this.country = country;
    }

    /**
     * @return List<Role> return the roles
     */
    public List<Role> getRoles() {
        return roles;
    }

    /**
     * @param roles the roles to set
     */
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    /**
     * @return Boolean return the enabled
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * @param enabled the enabled to set
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * @return Boolean return the enabled
     */
    public Boolean isEnabled() {
        return enabled;
    }

    /**
     * @return String return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return String return the secretValue
     */
    public String getSecretValue() {
        return secretValue;
    }

    /**
     * @param secretValue the secretValue to set
     */
    public void setSecretValue(String secretValue) {
        this.secretValue = secretValue;
    }

}