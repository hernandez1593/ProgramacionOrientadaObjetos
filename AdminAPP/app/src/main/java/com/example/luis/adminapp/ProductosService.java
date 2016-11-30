package com.example.luis.adminapp;

import java.util.List;
import retrofit.Callback;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.GET;
import retrofit.http.POST;

/**
 * Created by Adrián on 30/11/2016.
 */

public interface ProductosService {

    @GET("/productos")
    void getProductos(Callback<List<Productos>> callback);

    @FormUrlEncoded
    @POST("/DellProducto")
    void deleteProduct(@Field("name") String name, Callback<Boolean> callback);

    @FormUrlEncoded
    @POST("/AddProducto")
    void addProduct(@Field("name") String name,@Field("description") String description,
                    @Field("amount") int amount,@Field("price") int price, Callback<Boolean> callback);
    @FormUrlEncoded
    @POST("/UpdateProducto")
    void editProduct(@Field("name") String name,@Field("description") String description,
                     @Field("amount") int amount,@Field("price") int price, Callback<Boolean> callback);
}
