package com.example.examenprom_ev1;

import android.graphics.drawable.Drawable;

public class Localidad {
    private String localidad, provincia, ubicacion , url;
    private Drawable img;

    public Localidad (String localidad, String provincia, String ubicacion, Drawable img, String url){
        this.localidad =localidad;
        this.provincia = provincia;
        this.ubicacion = ubicacion;
        this.img = img;
        this.url = url;
    }

    public Drawable getImg() {
        return img;
    }

    public String getUrl() {
        return url;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getUbicacion() {
        return ubicacion;
    }
}
