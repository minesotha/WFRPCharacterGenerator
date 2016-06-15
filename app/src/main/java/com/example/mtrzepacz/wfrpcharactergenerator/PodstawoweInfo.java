package com.example.mtrzepacz.wfrpcharactergenerator;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.Toast;

public class PodstawoweInfo extends AppCompatActivity {
    private float x1, x2;
    ScrollView sw;
     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_karta);
        sw = (ScrollView)findViewById(R.id.pi_scrollview);
         sw.setOnTouchListener(
                 new View.OnTouchListener() {
                     @Override
                     public boolean onTouch(View v, MotionEvent event) {
                         switch (event.getAction()) {
                             case MotionEvent.ACTION_DOWN:
                                 x1 = event.getX();
                                 break;
                             case MotionEvent.ACTION_UP:
                                 x2 = event.getX();
                                 float deltaX = x2 - x1;
                                 if (deltaX < 0) {
                                     ApplyChanges();
                                     startActivity(new Intent(PodstawoweInfo.this, Cechy1.class));
                                 }
                                 else if(deltaX >0){
                                     ApplyChanges();
                                    finish();
                                 }
                                 break;
                         }

                         return false;
                     }
                 });
    }

    void ApplyChanges(){
        EditText currText;

        currText = (EditText)findViewById(R.id.imie_nazwisko);
        Postac.getInstance().imie_naziwsko = currText.getText().toString();
        //TODO - przełączanie płci
        RadioButton rb = (RadioButton)findViewById(R.id.plec_m);
        if(rb.isChecked()){
            Postac.getInstance().czyMężczyzna = true;
        }
        else{
            Postac.getInstance().czyMężczyzna=false;
        }



        try {
            currText = (EditText) findViewById(R.id.currPD);
        }
        catch(NumberFormatException e){
            Postac.getInstance().expCurrent =  Integer.parseInt(currText.getText().toString());
        }
        try{
            currText = (EditText)findViewById(R.id.allPD);
        }
        catch(NumberFormatException e) {
            Postac.getInstance().expAll = Integer.parseInt(currText.getText().toString());
        }
        currText = (EditText)findViewById(R.id.pochodzenie);
        Postac.getInstance().miejsce_urodzenia = currText.getText().toString();
        currText = (EditText)findViewById(R.id.rasa);
        Postac.getInstance().rasa = currText.getText().toString();
        currText = (EditText)findViewById(R.id.wzrost);
        try {
            Postac.getInstance().wzrost = Integer.parseInt(currText.getText().toString());
        }
        catch(NumberFormatException e){
            Postac.getInstance().wzrost =0;
        }
        currText = (EditText)findViewById(R.id.waga);
        try {
            Postac.getInstance().waga = Integer.parseInt(currText.getText().toString());
        }
        catch(NumberFormatException e){
            Postac.getInstance().waga = 0;
        }
        currText = (EditText)findViewById(R.id.wlosy);
        Postac.getInstance().kolor_wlosow = currText.getText().toString();
        currText = (EditText)findViewById(R.id.oczy);
        Postac.getInstance().kolor_oczu = currText.getText().toString();
        currText = (EditText)findViewById(R.id.wiek);
        try {
            Postac.getInstance().wiek = Integer.parseInt(currText.getText().toString());
        }
        catch(NumberFormatException e){
            Postac.getInstance().wiek= 0;
        }
        currText = (EditText)findViewById(R.id.rodzenstwo);
        Postac.getInstance().rodzeństwo = currText.getText().toString();
        currText = (EditText)findViewById(R.id.znak);
        Postac.getInstance().znak_gwiezdny = currText.getText().toString();
        currText = (EditText)findViewById(R.id.znakiSzczeg);
        Postac.getInstance().znaki_szczegolne = currText.getText().toString();




    }

}
