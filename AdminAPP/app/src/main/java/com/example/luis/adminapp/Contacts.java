package com.example.luis.adminapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Contacts extends AppCompatActivity {

    ListView lvClients;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        lvClients = (ListView) findViewById(R.id.lvClients);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("http://farmaciaapi.herokuapp.com/api").build(); //Adapter de retrofit

        UsuarioService service = restAdapter.create(UsuarioService.class); //Obtiene el servicio

        service.getUsuarios(new Callback<List<usuario>>() { //carga los datos
            @Override
            public void success(List<usuario> usuarios, Response response) {
                AdaptadorContactos adapter = new AdaptadorContactos(Contacts.this, usuarios);
                lvClients.setAdapter(adapter);
            }

            @Override
            public void failure(RetrofitError retrofitError) {
                Toast.makeText(Contacts.this, "Error: "+retrofitError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.contacts_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        // Accion para el activity agregar usuario
        if(id == R.id.addProducts){
            Intent intent = new Intent(getApplicationContext(),AddProduct.class); //cambiar por agregar cliente
            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //Clase adaptador para contactos
    private class AdaptadorContactos extends ArrayAdapter<usuario> {
        private List<usuario> listaContactos;

        public AdaptadorContactos(Context context, List<usuario> contactos){
            super(context,R.layout.contacts_item,contactos);
            listaContactos = contactos;
        }
    //infla el listView personalizado
        public View getView(int position, View containerView, ViewGroup parent){
            LayoutInflater inflater = LayoutInflater.from(getContext());

            View item = inflater.inflate(R.layout.contacts_item, null);

            TextView nombreContacto = (TextView)item.findViewById(R.id.textViewNameItem);
            nombreContacto.setText(listaContactos.get(position).getNombre());

            TextView loginContacto= (TextView)item.findViewById(R.id.textViewLoginItem);
            loginContacto.setText(listaContactos.get(position).getLogin());

            TextView registroContacto= (TextView)item.findViewById(R.id.textViewRegisDateItem);
            registroContacto.setText(listaContactos.get(position).getFechaRegistro());

            TextView ultimoLoginContacto= (TextView)item.findViewById(R.id.textViewLeastLoginItem);
            ultimoLoginContacto.setText(listaContactos.get(position).getUltimoLogin());

            Button btn1 = (Button) item.findViewById(R.id.buttonEdit);
            Button btn2 = (Button) item.findViewById(R.id.buttonDelete);
            Button btn3 = (Button) item.findViewById(R.id.buttonCall);

            return item;
        }

    }
}
