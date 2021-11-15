package com.example.examenprom_ev1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class ActividadLocalidades extends AppCompatActivity {

    private Spinner spinnerLoc;
    private TextView lblUbicacion;
    private RadioGroup rdgroup;
    private RadioButton rbCosta, rbInterior;
    private Button btnVisualizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_localidades);

        lblUbicacion = (TextView) findViewById(R.id.lblUbicacion);
        rdgroup = (RadioGroup) findViewById(R.id.rdGroup);
        btnVisualizar = (Button) findViewById(R.id.btnVisualizar);
        rbCosta = (RadioButton) findViewById(R.id.rdCosta);
        rbInterior = (RadioButton) findViewById(R.id.rdInterior);

        //Declaracion del spinner y su adaptador
        spinnerLoc = (Spinner) findViewById(R.id.spinnerLoc);

        String [] datos = new String[] {"", "Bizkaia", "Araba", "Gipuzkoa", "Nafarroa","Lapurdi",  "Behe-Nafarroa", "Zuberoa"};

        ArrayAdapter<String> adaptador =  new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos);

        adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinnerLoc.setAdapter(adaptador);

        //Listener para los radiobuttons de interior/costa
        spinnerLoc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 1 || i== 3 || i==5){
                    lblUbicacion.setVisibility(View.VISIBLE);
                    rdgroup.setVisibility(View.VISIBLE);
                    rbCosta.setChecked(true);
                }else{
                    lblUbicacion.setVisibility(View.INVISIBLE);
                    rdgroup.setVisibility(View.INVISIBLE);
                    rbInterior.setChecked(true);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnVisualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton radioButton = (RadioButton) findViewById(rdgroup.getCheckedRadioButtonId());

                Intent intent =  new Intent(ActividadLocalidades.this, ListaLocalidades.class);
                intent.putExtra("provincia", spinnerLoc.getSelectedItem().toString());
                intent.putExtra("ubicacion", radioButton.getText().toString());
                startActivity(intent);
            }
        });

    }
}