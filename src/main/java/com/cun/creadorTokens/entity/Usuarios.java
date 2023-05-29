package com.cun.creadorTokens.entity;

import jakarta.persistence.*;

@Entity
@Table(name="USUARIOS")
public class Usuarios {
    @Id
    private String ID;
    private String Correo;
    public String getID() {
        return ID;
    }
    public void setID(String ID) {
        this.ID = ID;
    }
    public String getCorreo() {
        return Correo;
    }
    public void setCorreo(String correo) {
        Correo = correo;
    }
}
