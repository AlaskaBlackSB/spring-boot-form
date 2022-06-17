package com.example.springbootform.editors;

import java.beans.PropertyEditorSupport;

public class NombreMayusculaEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {

        // Convierte a mayusculas y quita los espacios en blanco
        setValue(text.toUpperCase().trim());

    }

}