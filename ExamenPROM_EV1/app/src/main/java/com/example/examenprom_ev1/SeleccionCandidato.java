package com.example.examenprom_ev1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SeleccionCandidato extends AppCompatActivity {

    private Button btnAceptar, btnRechazar;
    private TextView txtNombre, txtFecha, txtProvincia, txtSexo, txtConocimientos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_candidato);

        btnAceptar = (Button) findViewById(R.id.btnAceptar);
        btnRechazar = (Button) findViewById(R.id.btnRechazar);

        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtFecha = (TextView) findViewById(R.id.txtFecha);
        txtProvincia =  (TextView) findViewById(R.id.txtProvincia);
        txtSexo = (TextView) findViewById(R.id.txtSexo);
        txtConocimientos = (TextView) findViewById( R.id.txtConocimiento);

        Bundle extras = getIntent().getExtras();

        txtNombre.setText(extras.getString("nombre"));
        txtFecha.setText(extras.getString("dia") + "/" + extras.getString("mes") + "/" + extras.getString("anio"));
        txtProvincia.setText(extras.getString("provincia"));
        txtSexo.setText(extras.getString("sexo"));
        txtConocimientos.setText(extras.getString("conocimientos"));


        btnAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        btnRechazar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                setResult(RESULT_CANCELED, intent);
                finish();
            }
        });
    }
}