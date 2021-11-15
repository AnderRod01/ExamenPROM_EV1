package com.example.examenprom_ev1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements DialogoLogin.OnDialogoInicioSesion {

    private static final String USER = "usuario", PSWD = "123456";
    private Button act1, act2, salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        DialogoLogin dialogoLogin = new DialogoLogin();
        dialogoLogin.show(fm, "tagLogin");

        act1 = (Button) findViewById(R.id.btnActividad1);
        act2 =(Button) findViewById(R.id.btnActividad2);
        salir = (Button) findViewById(R.id.btnExit);


        act1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActividadCandidato.class);
                startActivity(intent);
            }
        });

        act2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ActividadLocalidades.class);
                startActivity(intent);
            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                DialogoCerrar dialogoCerrar = new DialogoCerrar();
                dialogoCerrar.show(fragmentManager, "DialogoSalir");
            }
        });

    }


    @Override
    public void onPossitiveButtonClickInicio(String usu, String pass) {
        if(!usu.equals(USER) || !pass.equals(PSWD)) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            DialogoDatosIncorrectos dialogoCerrar = new DialogoDatosIncorrectos();
            dialogoCerrar.show(fragmentManager, "DialogoDatosIncorrectos");
        }
    }

    @Override
    public void onNegativeButtonClick() {
        FragmentManager fm = getSupportFragmentManager();
        DialogoCancelar dialogoCancelar = new DialogoCancelar();
        dialogoCancelar.show(fm, "DialogoCancelar");
    }


    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        DialogoCerrar dialogoCerrar = new DialogoCerrar();
        dialogoCerrar.show(fragmentManager, "DialogoSalir");
    }

}