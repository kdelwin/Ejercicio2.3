package com.example.ejercicio23;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Adapter extends ArrayAdapter<photoModel>{

    ArrayList<photoModel> imagesList = new ArrayList<>();

    public Adapter(Context context, int textViewResourceId, ArrayList<photoModel> objects) {
        super(context, textViewResourceId, objects);
        imagesList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View setView, ViewGroup parent) {
        View v = setView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.data_grid, null);
        ImageView imageView = (ImageView) v.findViewById(R.id.viewImage);
        imageView.setImageBitmap(imagesList.get(position).getImage());
        TextView textView = (TextView) v.findViewById(R.id.txtDescription);
        textView.setText(imagesList.get(position).getDescription());
        return v;
    }
}
