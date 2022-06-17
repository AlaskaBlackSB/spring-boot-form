package com.example.springbootform.editors;

import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.springbootform.services.CountryService;

@Component
public class CountryPropertyEditor extends PropertyEditorSupport {

    @Autowired
    private CountryService service;

    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        try {
            // Parsea de string a integer
            Integer id = Integer.parseInt(text);
            this.setValue(service.get(id));

        } catch (NumberFormatException e) {
            this.setValue(null);
        }

    }

}