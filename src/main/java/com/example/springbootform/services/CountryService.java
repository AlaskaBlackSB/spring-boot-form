package com.example.springbootform.services;

import java.util.List;

import com.example.springbootform.models.domain.Country;

public interface CountryService {

    public List<Country> all();

    public Country get(Integer id);

}