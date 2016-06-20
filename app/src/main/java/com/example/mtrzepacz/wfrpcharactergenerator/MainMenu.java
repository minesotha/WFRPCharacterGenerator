package com.example.mtrzepacz.wfrpcharactergenerator;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import java.io.File;


public class MainMenu extends AppCompatActivity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
//    private GoogleApiClient client;

    ViewFlipper viewFlipper;
    private float lastX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        //client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void newChara_click(View v) {
        Postac.Wyczysc();
        BeforeMove();
        viewFlipper.showNext();
//        Intent i = new Intent(MainMenu.this, PodstawoweInfo.class);
//        startActivity(i);
    }


    public void saveCahra_click(View v) {
        Serializer serializer = new Persister();
        //Profesja prof = new Profesja(Postac.getInstance().imie_naziwsko, 666);
        File file = new File(getFilesDir(), "postac.xml");

        try {
            serializer.write(Postac.getInstance(), file);
            Toast.makeText(getBaseContext(), "Zapisano pomyślnie postać: "+Postac.getInstance().imie_naziwsko.toString(), Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadChara_click(View v) {
        Serializer serializer = new Persister();
        File source = new File(getFilesDir(), "postac.xml");
        try {
           // Profesja prof = serializer.read(Profesja.class, source);
            serializer.read(Postac.class, source);
            //Postac.getInstance().imie_naziwsko = prof.getNazwa();
            Toast.makeText(getBaseContext(), "Wczytano pomyślnie postać: "+Postac.getInstance().imie_naziwsko.toString(), Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }

       // startActivity(new Intent(MainMenu.this, PodstawoweInfo.class));

    }



    public boolean onTouchEvent(MotionEvent touchevent) {
        switch (touchevent.getAction()) {

            case MotionEvent.ACTION_DOWN: {
                lastX = touchevent.getX();
                break;
            }
            case MotionEvent.ACTION_UP: {
                float currentX = touchevent.getX();

                if (lastX < currentX) {

                    if (viewFlipper.getDisplayedChild() == 0)
                        break;
                    BeforeMove();
                    viewFlipper.setInAnimation(this, R.anim.in_from_left);
                    viewFlipper.setOutAnimation(this, R.anim.out_to_right);
                    // Show The Previous Screen
                    viewFlipper.showPrevious();
                    AfterMove();
                }

                // if right to left swipe on screen
                if (lastX > currentX) {
                    if (viewFlipper.getDisplayedChild() == 4)
                        break;
                    BeforeMove();
                    viewFlipper.setInAnimation(this, R.anim.in_from_right);
                    viewFlipper.setOutAnimation(this, R.anim.out_to_left);
                    // Show the next Screen
                    viewFlipper.showNext();
                    AfterMove();
                }
                break;
            }
        }
        return false;
    }


    private  void BeforeMove(){
        switch(viewFlipper.getDisplayedChild()){
            case 0:
                break;
            case 1:
                PodstawoweInfoApplyChanges();
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }
    private void AfterMove(){
        switch(viewFlipper.getDisplayedChild()){
            case 0:
                break;
            case 1:
                PodstawoweInfoPopulateFields();
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }




    //podstawoe info

    private void PodstawoweInfoPopulateFields(){
        EditText currText= (EditText) findViewById(R.id.imie_nazwisko);
        currText.setText(Postac.getInstance().imie_naziwsko);
        currText = (EditText) findViewById(R.id.rasa);
        currText.setText(Postac.getInstance().rasa);
        currText = (EditText) findViewById(R.id.profesja);
        currText.setText(Postac.getInstance().profesja);
        currText = (EditText) findViewById(R.id.poprzedniaprofesja);
        currText.setText(Postac.getInstance().poprzedniaprofesja);
        currText = (EditText) findViewById(R.id.currPD);
        currText.setText(String.valueOf(Postac.getInstance().expCurrent));
        currText = (EditText) findViewById(R.id.allPD);
        currText.setText(String.valueOf(Postac.getInstance().expAll));


        RadioButton rb = (RadioButton) findViewById(R.id.plec_m);
        RadioButton rb2 = (RadioButton) findViewById(R.id.plec_k);
        if (Postac.getInstance().czyMężczyzna) {
            rb.setChecked(true);
            rb2.setChecked(false);
        }
        else {
            rb2.setChecked(true);
            rb.setChecked(false);
        }

        currText = (EditText) findViewById(R.id.pochodzenie);
        currText.setText(Postac.getInstance().miejsce_urodzenia);
        currText = (EditText) findViewById(R.id.wzrost);
        currText.setText(String.valueOf(Postac.getInstance().wzrost));
        currText = (EditText) findViewById(R.id.waga);
        currText.setText(String.valueOf(Postac.getInstance().waga));
        currText = (EditText) findViewById(R.id.wlosy);
        currText.setText(Postac.getInstance().kolor_wlosow);
        currText = (EditText) findViewById(R.id.oczy);
        currText.setText(Postac.getInstance().kolor_oczu);
        currText = (EditText) findViewById(R.id.wiek);
        currText.setText(String.valueOf(Postac.getInstance().wiek));
        currText = (EditText) findViewById(R.id.rodzenstwo);
        currText.setText(Postac.getInstance().rodzeństwo);
        currText = (EditText) findViewById(R.id.znak);
        currText.setText(Postac.getInstance().znak_gwiezdny);
        currText = (EditText) findViewById(R.id.znakiSzczeg);
        currText.setText(Postac.getInstance().znaki_szczegolne);
    }

    void PodstawoweInfoApplyChanges() {
       EditText currText = (EditText) findViewById(R.id.imie_nazwisko);
        Postac.getInstance().imie_naziwsko = currText.getText().toString();
        //TODO - przełączanie płci
        RadioButton rb = (RadioButton) findViewById(R.id.plec_m);
        if (rb.isChecked()) {
            Postac.getInstance().czyMężczyzna = true;
        } else {
            Postac.getInstance().czyMężczyzna = false;
        }


        try {
            currText = (EditText) findViewById(R.id.currPD);
            Postac.getInstance().expCurrent = Integer.parseInt(currText.getText().toString());
        } catch (NumberFormatException e) {
            Postac.getInstance().expCurrent = 0;
        }
        try {
            currText = (EditText) findViewById(R.id.allPD);
            Postac.getInstance().expAll = Integer.parseInt(currText.getText().toString());
        } catch (NumberFormatException e) {
            Postac.getInstance().expAll = 0;
        }
        currText = (EditText) findViewById(R.id.pochodzenie);
        Postac.getInstance().miejsce_urodzenia = currText.getText().toString();
        currText = (EditText) findViewById(R.id.rasa);
        Postac.getInstance().rasa = currText.getText().toString();

        currText = (EditText) findViewById(R.id.profesja);
        Postac.getInstance().profesja  = currText.getText().toString();
        currText = (EditText) findViewById(R.id.poprzedniaprofesja);
        Postac.getInstance().poprzedniaprofesja = currText.getText().toString();


        currText = (EditText) findViewById(R.id.wzrost);
        try {
            Postac.getInstance().wzrost = Integer.parseInt(currText.getText().toString());
        } catch (NumberFormatException e) {
            Postac.getInstance().wzrost = 0;
        }
        currText = (EditText) findViewById(R.id.waga);
        try {
            Postac.getInstance().waga = Integer.parseInt(currText.getText().toString());
        } catch (NumberFormatException e) {
            Postac.getInstance().waga = 0;
        }
        currText = (EditText) findViewById(R.id.wlosy);
        Postac.getInstance().kolor_wlosow = currText.getText().toString();
        currText = (EditText) findViewById(R.id.oczy);
        Postac.getInstance().kolor_oczu = currText.getText().toString();
        currText = (EditText) findViewById(R.id.wiek);
        try {
            Postac.getInstance().wiek = Integer.parseInt(currText.getText().toString());
        } catch (NumberFormatException e) {
            Postac.getInstance().wiek = 0;
        }
        currText = (EditText) findViewById(R.id.rodzenstwo);
        Postac.getInstance().rodzeństwo = currText.getText().toString();
        currText = (EditText) findViewById(R.id.znak);
        Postac.getInstance().znak_gwiezdny = currText.getText().toString();
        currText = (EditText) findViewById(R.id.znakiSzczeg);
        Postac.getInstance().znaki_szczegolne = currText.getText().toString();


    }


//tworzenie/sprawdzanie bazy danych

}
