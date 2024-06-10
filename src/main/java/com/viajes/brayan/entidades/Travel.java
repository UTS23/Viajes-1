package com.viajes.brayan.entidades;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "travels")
public class Travel {

    @Id
    private String id;
    private String nombre;
    private String urlImage;

    // Constructor por defecto
    public Travel() {}

    // Constructor con parámetros
    public Travel(String nombre, String urlImage) {
        this.nombre = nombre;
        this.urlImage = urlImage;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
