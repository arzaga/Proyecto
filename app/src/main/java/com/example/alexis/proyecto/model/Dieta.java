package com.example.alexis.proyecto.model;


/**
 * Created by Alexis on 19/03/2017.
 */
public class Dieta {

    private int id;
    private String nombre;
    private String telefono;
    private String email;
    private int foto;


    public Dieta(int foto, String nombre, String telefono, String email) {
        this.foto = foto;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;

    }

    public Dieta() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
