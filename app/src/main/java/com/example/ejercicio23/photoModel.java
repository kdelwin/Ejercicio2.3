package com.example.ejercicio23;

import android.graphics.Bitmap;

public class photoModel {
    Bitmap image;
    String description;

    public photoModel(Bitmap imagen, String descripcion)
    {
        this.image = imagen;
        this.description = descripcion;
    }

    public Bitmap getImage()
    {
        return image;
    }

    public String getDescription()
    {
        return description;
    }
}
