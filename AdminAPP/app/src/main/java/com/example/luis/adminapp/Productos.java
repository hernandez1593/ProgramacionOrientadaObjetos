package com.example.luis.adminapp;

/**
 * Created by Adrián on 30/11/2016.
 */

public class Productos {

    public int id;
    public String nombre;
    public String descripción;
    public int cantidad;
    public int precio;

    public Productos() {
    }

    public Productos(int id, String nombre, String descripción, int cantidad, int precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripción = descripción;
        this.cantidad = cantidad;
        this.precio = precio;
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

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}
