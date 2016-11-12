package com.example.luis.adminapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class AddProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);


    }

    public void onClickCancell(View view){
        finish();
    }

    public void onClickGuardar(View view){
        Toast.makeText(getApplicationContext(),"@strings/exitSaving",Toast.LENGTH_SHORT).show();
        finish();
    }
}
