package com.example.luis.adminapp;

/**
 * Created by Adrián on 30/11/2016.
 */

public class administrador extends Persona {

    public String departamento;
    public int salario;
    public String cedula;

    public administrador(int id, String nombre, String login, String password, int telefono, int tipo, String departamento, int salario, String cedula) {
        super(id, nombre, login, password, telefono, tipo);
        this.departamento = departamento;
        this.salario = salario;
        this.cedula = cedula;
    }

    public administrador() {
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}
