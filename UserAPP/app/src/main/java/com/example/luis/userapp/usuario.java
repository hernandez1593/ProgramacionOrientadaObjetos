package com.example.luis.userapp;

/**
 * Created by Adrián on 30/11/2016.
 */

public class usuario extends Persona {

    public String fechaRegistro;
    public String ultimoLogin;

    public usuario(int id, String nombre, String login, String password, int telefono, int tipo, String fechaRegistro, String ultimoLogin) {
        super(id, nombre, login, password, telefono, tipo);
        this.fechaRegistro = fechaRegistro;
        this.ultimoLogin = ultimoLogin;
    }

    public usuario() {

    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(String ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }
}
