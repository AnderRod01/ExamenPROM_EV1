package com.example.examenprom_ev1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListaLocalidades extends AppCompatActivity {

    private ArrayList <Localidad> arrayListLocalidades;
    private ListView lstLocalidad;
    private TextView lblTitulo;
    private Button btnVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_localidades);

        generarDatos();

        AdaptadorLocalidad adaptadorLocalidad = new AdaptadorLocalidad(this, arrayListLocalidades);

        lstLocalidad = (ListView) findViewById(R.id.lstLocalidades);
        lstLocalidad.setAdapter(adaptadorLocalidad);
        lblTitulo = (TextView) findViewById(R.id.lblTitulo);
        btnVolver = (Button) findViewById(R.id.btnVolver);



        Bundle extras = getIntent().getExtras();

        lblTitulo.setText("--" + extras.getString("provincia") + "--\n(" + extras.getString("ubicacion") + ")");


        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =  new Intent(ListaLocalidades.this, ActividadLocalidades.class);
                startActivity(intent);
            }
        });
    }


    private void generarDatos (){

        arrayListLocalidades = new ArrayList<Localidad>();
        Localidad localidad;

        localidad = new Localidad("Orduña", "Bizkaia", "Interior", ContextCompat.getDrawable(this, R.drawable.orduna),"http://www.urduna.com/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Ondarroa", "Bizkaia", "Costa", ContextCompat.getDrawable(this, R.drawable.ondarroa),"http://www.ondarroa.eu/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Areatza", "Bizkaia", "Interior", ContextCompat.getDrawable(this, R.drawable.areatza),"http://www.areatza.net/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Gernika", "Bizkaia", "Interior", ContextCompat.getDrawable(this, R.drawable.gernika), "http://www.gernika-lumo.net/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Bermeo", "Bizkaia", "Costa", ContextCompat.getDrawable(this, R.drawable.bermeo),"http://www.bermeo.eus/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Balmaseda", "Bizkaia", "Interior", ContextCompat.getDrawable(this, R.drawable.balmaseda),"http://www.balmaseda.net/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Karrantza", "Bizkaia", "Interior", ContextCompat.getDrawable(this, R.drawable.karrantza),"http://www.karrantza.org/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Lekeitio", "Bizkaia", "Costa", ContextCompat.getDrawable(this, R.drawable.lekeitio),"http://www.lekeitio.com/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Getxo", "Bizkaia", "Costa", ContextCompat.getDrawable(this, R.drawable.getxo),"http://www.getxo.eus/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Laguardia", "Araba", "Interior", ContextCompat.getDrawable(this, R.drawable.laguardia),"http://www.laguardia-alava.net/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Hondarribia", "Gipuzkoa", "Costa", ContextCompat.getDrawable(this, R.drawable.hondarribia),"http://www.hondarribia.eus/es/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Zarautz", "Gipuzkoa", "Costa", ContextCompat.getDrawable(this, R.drawable.zarautz),"http://www.zarautz.org/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Pasaia", "Gipuzkoa", "Costa", ContextCompat.getDrawable(this, R.drawable.pasaia),"http://www.pasaia.eus/es");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Astigarraga", "Gipuzkoa", "Interior", ContextCompat.getDrawable(this, R.drawable.astigarraga),"http://astigarraga.eus");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Donostia", "Gipuzkoa", "Costa", ContextCompat.getDrawable(this, R.drawable.donostia),"http://www.donostia.eus");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Vitoria-Gasteiz", "Araba", "Interior", ContextCompat.getDrawable(this, R.drawable.vitoria_gasteiz),"http://www.vitoria-gasteiz.org/");
        arrayListLocalidades.add(localidad);
        localidad = new Localidad("Añana", "Araba", "Interior", ContextCompat.getDrawable(this, R.drawable.anana),"http://www.cuadrilladeanana.es/anana/");
        arrayListLocalidades.add(localidad);
    }

    class AdaptadorLocalidad extends ArrayAdapter<Localidad>{
        public AdaptadorLocalidad(@NonNull Context context, ArrayList<Localidad> datos) {
            super(context, R.layout.listitem_localidad, datos);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.listitem_localidad, null);

            TextView lblLocalidad= (TextView) item.findViewById(R.id.lblLocalidad);
            lblLocalidad.setText(arrayListLocalidades.get(position).getLocalidad());

            ImageView imgPortada = (ImageView) item.findViewById(R.id.img);
            imgPortada.setImageDrawable(arrayListLocalidades.get(position).getImg());

            return item;
        }


    }

}