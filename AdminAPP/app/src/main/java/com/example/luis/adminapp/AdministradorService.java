package com.example.luis.adminapp;

import java.util.List;
import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by Adrián on 30/11/2016.
 */

public interface AdministradorService {

    @GET("/administrador")
    void getAdministradores(Callback<List<administrador>> callback);

}
