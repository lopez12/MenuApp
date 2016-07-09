package com.example.arturo.menuoption;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Cuenta extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuenta);

        /*Intent intent = getIntent();
        Bundle args = intent.getBundleExtra("BUNDLE");
        ArrayList<DisplayMenu.Food> object = (ArrayList<DisplayMenu.Food>) args.getSerializable("ARRAYLIST");

        List<DisplayMenu.Food> challenge = this.getIntent().getExtras().getParcelableArrayList("Birds");


        for(int index = 0; index < object.size(); index++){

            DisplayMenu.Food Cuenta = object.get(index);
            Toast.makeText(getApplicationContext(), Cuenta.name+": "+Cuenta.price, Toast.LENGTH_SHORT).show();*/
        }

       // Toast.makeText(getApplicationContext(), object , Toast.LENGTH_SHORT).show();
/*
            // Get the Bundle Object
            Bundle bundleObject = getIntent().getExtras();

            // Get ArrayList Bundle
            ArrayList<DisplayMenu.Food> classObject = (ArrayList<DisplayMenu.Food>) bundleObject.getSerializable("key");

            //Retrieve Objects from Bundle
            for(int index = 0; index < classObject.size(); index++){

                DisplayMenu.Food Object = classObject.get(index);
                Toast.makeText(getApplicationContext(), Object.name+": "+Object.price, Toast.LENGTH_SHORT).show();
            }
*/
    }


