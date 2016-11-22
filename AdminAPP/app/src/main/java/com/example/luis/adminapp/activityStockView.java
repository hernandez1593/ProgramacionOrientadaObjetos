package com.example.luis.adminapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;

import java.util.ArrayList;

public class activityStockView extends AppCompatActivity {

    ListView lvProducts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_view);
        lvProducts = (ListView) findViewById(R.id.lvProducts);

        //Datos de pruebas
        String []arregloPaises = {"Acetaminofen","Panadol","Extasis","Mota Medicinal"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,arregloPaises);
        lvProducts.setAdapter(adapter);

        lvProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                PopupMenu popupMenu = new PopupMenu(activityStockView.this, view);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.item_edit:
                                Toast.makeText(activityStockView.this,"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.item_delete:
                                AlertDialog.Builder builder = new AlertDialog.Builder(activityStockView.this);

                                builder.setMessage("¿Confirma la acción seleccionada?")
                                        .setTitle("Confirmacion")
                                        .setPositiveButton("Aceptar", new DialogInterface.OnClickListener()  {
                                            public void onClick(DialogInterface dialog, int id) {
                                                Log.i("Dialogos", "Confirmacion Aceptada.");
                                                dialog.cancel();
                                            }
                                        })
                                        .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                Log.i("Dialogos", "Confirmacion Cancelada.");
                                                dialog.cancel();
                                            }
                                        });

                                AlertDialog alert = builder.create();
                                alert.show();
                                return true;
                        }

                        return true;
                    }
                });
                popupMenu.show();
            }
        });

       /* lvProducts.setOnLongClickListener(new AdapterView.OnItemLongClickListener(){
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l){

                Log.v("long clicked","pos: " + i);

                return true;
            }
        }); */
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activitystockactions, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();


        if(id == R.id.addProducts){
            Intent intent = new Intent(getApplicationContext(),AddProduct.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item_edit:
                Toast.makeText(this, "Comedy Clicked", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item_delete:
                Toast.makeText(this, "Movies Clicked", Toast.LENGTH_SHORT).show();
                return true;
        }
        return true;
    }
}
