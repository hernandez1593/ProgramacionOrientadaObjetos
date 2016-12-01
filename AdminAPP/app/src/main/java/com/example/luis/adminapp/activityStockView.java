package com.example.luis.adminapp;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class activityStockView extends AppCompatActivity {

    ListView lvProducts; //listview para productos
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock_view);
        lvProducts = (ListView) findViewById(R.id.lvProducts); //inicializa el listview

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://farmaciaapi.herokuapp.com/api").build(); //Adapter de retrofit

        ProductosService service = restAdapter.create(ProductosService.class); // Interface de la clase productos

        service.getProductos(new Callback<List<Productos>>() { //Get del api
            @Override
            public void success(List<Productos> productoss, Response response) {

                AdaptadorProductos adaptador = new AdaptadorProductos(activityStockView.this, productoss);
                lvProducts.setAdapter(adaptador);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                Toast.makeText(activityStockView.this, "Error: "+retrofitError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

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
        if(id == R.id.lookUsers) {
            Intent intent = new Intent(getApplicationContext(), Contacts.class);
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    private class AdaptadorProductos extends ArrayAdapter<Productos>{
        private List<Productos> listaProductos;

        public AdaptadorProductos(Context context, List<Productos> productos){
            super(context, R.layout.productos_item, productos);
            listaProductos = productos;
        }

        public View getView(int position, View containerView, ViewGroup parent){
            LayoutInflater inflater = LayoutInflater.from(getContext());

            View item = inflater.inflate(R.layout.productos_item, null);

            TextView nombreProducto = (TextView)item.findViewById(R.id.nombreProducto);
            nombreProducto.setText(listaProductos.get(position).getNombre());

            return item;
        }

    }
}
