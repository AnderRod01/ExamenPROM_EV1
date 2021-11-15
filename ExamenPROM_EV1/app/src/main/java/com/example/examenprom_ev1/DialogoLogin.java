package com.example.examenprom_ev1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class DialogoLogin extends DialogFragment {

    private EditText txtUsuario, txtContrasena;
    private OnDialogoInicioSesion listener;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener= (OnDialogoInicioSesion)context;
        }catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "no Implemento OnDialogoInicioSesion");
        }
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        setCancelable(true);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = onCreateView(inflater, null,null);
        builder.setView(inflater.inflate(R.layout.activity_dialogo_login, null))
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listener.onPossitiveButtonClickInicio(txtUsuario.getText().toString(), txtContrasena.getText().toString());
                    }
                }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                listener.onNegativeButtonClick();
            }
        });
        return builder.create();
    }

    @Override
    public void onStart() {
        super.onStart();
        txtUsuario = (EditText) getDialog().findViewById(R.id.txtUsuario);
        txtContrasena = (EditText) getDialog().findViewById(R.id.txtContrasenia);
    }

    public interface OnDialogoInicioSesion {
        void onPossitiveButtonClickInicio(String usu, String pass);
        void onNegativeButtonClick();
    }
}