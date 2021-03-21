package com.ichangemycity.ichangemycommunity.model;

import android.graphics.Bitmap;

public class LuminosityRowItem {

    private Bitmap image;
    private float lumens;

    public LuminosityRowItem(Bitmap image, float lumens) {
        this.image = image;
        this.lumens = lumens;
    }

    public Bitmap getImage() {
        return image;
    }

    public float getLumens() {
        return lumens;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public void setLumens(float lumens) {
        this.lumens = lumens;
    }
}
