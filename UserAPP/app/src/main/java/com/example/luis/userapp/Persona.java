package com.example.luis.userapp;

/**
 * Created by Adrián on 30/11/2016.
 */

public class Persona {

    public int id;
    public String nombre;
    public String login;
    public String password;
    public int telefono;
    public int tipo;

    public Persona(int id, String nombre, String login, String password, int telefono, int tipo) {
        this.id = id;
        this.nombre = nombre;
        this.login = login;
        this.password = password;
        this.telefono = telefono;
        this.tipo = tipo;
    }

    public Persona() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
