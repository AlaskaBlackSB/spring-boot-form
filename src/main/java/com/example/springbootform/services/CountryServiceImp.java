package com.example.springbootform.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springbootform.models.domain.Country;

@Service
public class CountryServiceImp implements CountryService {

    private List<Country> countries;

    public CountryServiceImp() {
        // Inicializa la lista
        countries = Arrays.asList(
                new Country(1, "MX", "México"),
                new Country(2, "ES", "España"),
                new Country(3, "CL", "Chile"),
                new Country(4, "CO", "Colombia"),
                new Country(5, "PE", "Perú"));
    }

    @Override
    public List<Country> all() {
        return countries;
    }

    @Override
    public Country get(Integer id) {
        for (Country country : countries) {
            if (country.getId() == id) {
                return country;
            }
        }
        return null;
    }

}