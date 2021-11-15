package com.example.examenprom_ev1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class ActividadCandidato extends AppCompatActivity {

    private Spinner spinnerProvincia;
    private CheckBox[] arrChkBox;
    private int cont=0;
    private TextView lblNumCandidatos;
    private Button btnSalir, btnEvaluar;
    private EditText txtNombre;
    private EditText txtDia;
    private EditText txtMes;
    private EditText txtAnio;
    private RadioGroup rg;
    private RadioButton rbMasc, rbFem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_candidato);

        spinnerProvincia = (Spinner) findViewById(R.id.spinnerProvincia);

        final String [] datos = new String[] {"Álava", "Bizkaia", "Gipuzkoa"};
        ArrayAdapter<String> adaptador =  new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, datos);

        adaptador.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);
        spinnerProvincia.setAdapter(adaptador);

        btnEvaluar = (Button) findViewById(R.id.btnEvaluar);
        btnSalir = (Button) findViewById(R.id.btnSalir);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtDia = (EditText) findViewById(R.id.txtDia);
        txtMes = (EditText) findViewById(R.id.txtMes);
        txtAnio = (EditText) findViewById(R.id.txtAnio);

        lblNumCandidatos = (TextView) findViewById(R.id.lblNumCandidatos);


        rg = (RadioGroup) findViewById(R.id.rdGroup);
        rbFem = (RadioButton) findViewById(R.id.rdFemenino);
        rbMasc =(RadioButton) findViewById(R.id.rdMasculino);


        arrChkBox = new CheckBox[4];
        arrChkBox[0] = (CheckBox) findViewById(R.id.PHP);
        arrChkBox[1] = (CheckBox) findViewById(R.id.cboxJAVA);
        arrChkBox[2] = (CheckBox) findViewById(R.id.cboxHTML);
        arrChkBox[3] = (CheckBox) findViewById(R.id.cboxCSS);


        //Paso todos los datos necesarios a la actividad "SeleccionCandidato"
        btnEvaluar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioButton radioButton = (RadioButton) findViewById(rg.getCheckedRadioButtonId());

                Intent intent = new Intent(ActividadCandidato.this, SeleccionCandidato.class);
                intent.putExtra("nombre", txtNombre.getText().toString());
                intent.putExtra("dia", txtDia.getText().toString());
                intent.putExtra("mes", txtMes.getText().toString());
                intent.putExtra("anio", txtAnio.getText().toString());
                intent.putExtra("provincia", spinnerProvincia.getSelectedItem().toString());
                intent.putExtra("sexo", radioButton.getText().toString());
                intent.putExtra("conocimientos", getCheckString());
                startActivityForResult(intent, 111);
            }
        });

        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActividadCandidato.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    //Metodo para coger el texto de los checkbox seleccionados
    private String getCheckString(){
        String strCheck ="";

        for(CheckBox check : arrChkBox){

            if(check.isChecked())
                strCheck += (check.getText().toString() + ", ");
        }
        return strCheck;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 111 && resultCode == RESULT_OK) {
            cont++;
            lblNumCandidatos.setText(cont +"");

            txtNombre.setText("");
            txtDia.setText("");
            txtMes.setText("");
            txtAnio.setText("");

            rg.setSelected(false);
            rbMasc.setSelected(false);
            rbFem.setSelected(false);
            spinnerProvincia.setSelection(0);

            for(CheckBox check : arrChkBox){

                check.setChecked(false);

            }

            if (cont == 4){

                btnSalir.setVisibility(View.VISIBLE);
                btnEvaluar.setVisibility(View.INVISIBLE);
            }
        }
    }
}