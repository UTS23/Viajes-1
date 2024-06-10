package com.viajes.brayan.entidades;




import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "compras")
public class Compra {
    @Id
    private String id;
    private String usuarioId;
    private String rutaId;
    private Date fechaCompra;

    // Getters y setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(String usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getRutaId() {
        return rutaId;
    }

    public void setRutaId(String rutaId) {
        this.rutaId = rutaId;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }
}

