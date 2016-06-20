//package com.example.mtrzepacz.wfrpcharactergenerator;
//
//import android.app.Activity;
//import android.content.Context;
//import android.content.Intent;
//import android.net.Uri;
//import android.support.v7.app.AppCompatActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.GestureDetector;
//import android.view.GestureDetector.SimpleOnGestureListener;
//import android.view.MotionEvent;
//import android.view.View;
//import android.view.View.OnTouchListener;
//import android.widget.EditText;
//import android.widget.RadioButton;
//import android.widget.ScrollView;
//import android.widget.Toast;
//
//import com.google.android.gms.appindexing.Action;
//import com.google.android.gms.appindexing.AppIndex;
//import com.google.android.gms.common.api.GoogleApiClient;
//
//public class PodstawoweInfo extends AppCompatActivity {
//    private float x1, x2;
//    ScrollView sw;
//    EditText currText;
//    /**
//     * ATTENTION: This was auto-generated to implement the App Indexing API.
//     * See https://g.co/AppIndexing/AndroidStudio for more information.
//     */
//    private GoogleApiClient client;
//
//    private void PopulateFields(){
//        currText= (EditText) findViewById(R.id.imie_nazwisko);
//        currText.setText(Postac.getInstance().imie_naziwsko);
//        currText = (EditText) findViewById(R.id.rasa);
//        currText.setText(Postac.getInstance().rasa);
//        currText = (EditText) findViewById(R.id.profesja);
//        currText.setText(Postac.getInstance().profesja);
//        currText = (EditText) findViewById(R.id.poprzedniaprofesja);
//        currText.setText(Postac.getInstance().poprzedniaprofesja);
//        currText = (EditText) findViewById(R.id.currPD);
//        currText.setText(String.valueOf(Postac.getInstance().expCurrent));
//        currText = (EditText) findViewById(R.id.allPD);
//        currText.setText(String.valueOf(Postac.getInstance().expAll));
//
//
//        RadioButton rb = (RadioButton) findViewById(R.id.plec_m);
//        RadioButton rb2 = (RadioButton) findViewById(R.id.plec_k);
//        if (Postac.getInstance().czyMężczyzna) {
//            rb.setChecked(true);
//            rb2.setChecked(false);
//        }
//        else {
//            rb2.setChecked(true);
//            rb.setChecked(false);
//        }
//
//        currText = (EditText) findViewById(R.id.pochodzenie);
//        currText.setText(Postac.getInstance().miejsce_urodzenia);
//        currText = (EditText) findViewById(R.id.wzrost);
//        currText.setText(String.valueOf(Postac.getInstance().wzrost));
//        currText = (EditText) findViewById(R.id.waga);
//        currText.setText(String.valueOf(Postac.getInstance().waga));
//        currText = (EditText) findViewById(R.id.wlosy);
//        currText.setText(Postac.getInstance().kolor_wlosow);
//        currText = (EditText) findViewById(R.id.oczy);
//        currText.setText(Postac.getInstance().kolor_oczu);
//        currText = (EditText) findViewById(R.id.wiek);
//        currText.setText(String.valueOf(Postac.getInstance().wiek));
//        currText = (EditText) findViewById(R.id.rodzenstwo);
//        currText.setText(Postac.getInstance().rodzeństwo);
//        currText = (EditText) findViewById(R.id.znak);
//        currText.setText(Postac.getInstance().znak_gwiezdny);
//        currText = (EditText) findViewById(R.id.znakiSzczeg);
//        currText.setText(Postac.getInstance().znaki_szczegolne);
//    }
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_karta);
//            PopulateFields();
//
//
//
//        //oblsyga swipe
//        sw = (ScrollView) findViewById(R.id.pi_scrollview);
//        sw.setOnTouchListener(
//                new OnTouchListener() {
//                    @Override
//                    public boolean onTouch(View v, MotionEvent event) {
//                        switch (event.getAction()) {
//                            case MotionEvent.ACTION_DOWN:
//                                x1 = event.getX();
//                                break;
//                            case MotionEvent.ACTION_UP:
//                                x2 = event.getX();
//                                float deltaX = x2 - x1;
//                                if (deltaX < -100) {
//                                    ApplyChanges();
//                                    startActivity(new Intent(PodstawoweInfo.this, Cechy1.class));
//                                } else if (deltaX > 100) {
//                                    ApplyChanges();
//                                    finish();
//                                }
//                                break;
//                        }
//
//                        return false;
//                    }
//                });
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
//    }
//
//    void ApplyChanges() {
//        currText = (EditText) findViewById(R.id.imie_nazwisko);
//        Postac.getInstance().imie_naziwsko = currText.getText().toString();
//        //TODO - przełączanie płci
//        RadioButton rb = (RadioButton) findViewById(R.id.plec_m);
//        if (rb.isChecked()) {
//            Postac.getInstance().czyMężczyzna = true;
//        } else {
//            Postac.getInstance().czyMężczyzna = false;
//        }
//
//
//        try {
//            currText = (EditText) findViewById(R.id.currPD);
//        } catch (NumberFormatException e) {
//            Postac.getInstance().expCurrent = Integer.parseInt(currText.getText().toString());
//        }
//        try {
//            currText = (EditText) findViewById(R.id.allPD);
//        } catch (NumberFormatException e) {
//            Postac.getInstance().expAll = Integer.parseInt(currText.getText().toString());
//        }
//        currText = (EditText) findViewById(R.id.pochodzenie);
//        Postac.getInstance().miejsce_urodzenia = currText.getText().toString();
//        currText = (EditText) findViewById(R.id.rasa);
//        Postac.getInstance().rasa = currText.getText().toString();
//        currText = (EditText) findViewById(R.id.wzrost);
//        try {
//            Postac.getInstance().wzrost = Integer.parseInt(currText.getText().toString());
//        } catch (NumberFormatException e) {
//            Postac.getInstance().wzrost = 0;
//        }
//        currText = (EditText) findViewById(R.id.waga);
//        try {
//            Postac.getInstance().waga = Integer.parseInt(currText.getText().toString());
//        } catch (NumberFormatException e) {
//            Postac.getInstance().waga = 0;
//        }
//        currText = (EditText) findViewById(R.id.wlosy);
//        Postac.getInstance().kolor_wlosow = currText.getText().toString();
//        currText = (EditText) findViewById(R.id.oczy);
//        Postac.getInstance().kolor_oczu = currText.getText().toString();
//        currText = (EditText) findViewById(R.id.wiek);
//        try {
//            Postac.getInstance().wiek = Integer.parseInt(currText.getText().toString());
//        } catch (NumberFormatException e) {
//            Postac.getInstance().wiek = 0;
//        }
//        currText = (EditText) findViewById(R.id.rodzenstwo);
//        Postac.getInstance().rodzeństwo = currText.getText().toString();
//        currText = (EditText) findViewById(R.id.znak);
//        Postac.getInstance().znak_gwiezdny = currText.getText().toString();
//        currText = (EditText) findViewById(R.id.znakiSzczeg);
//        Postac.getInstance().znaki_szczegolne = currText.getText().toString();
//
//
//    }
//
//    @Override
//    public void onStart() {
//        super.onStart();
//
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        client.connect();
//        Action viewAction = Action.newAction(
//                Action.TYPE_VIEW, // TODO: choose an action type.
//                "PodstawoweInfo Page", // TODO: Define a title for the content shown.
//                // TODO: If you have web page content that matches this app activity's content,
//                // make sure this auto-generated web page URL is correct.
//                // Otherwise, set the URL to null.
//                Uri.parse("http://host/path"),
//                // TODO: Make sure this auto-generated app deep link URI is correct.
//                Uri.parse("android-app://com.example.mtrzepacz.wfrpcharactergenerator/http/host/path")
//        );
//        AppIndex.AppIndexApi.start(client, viewAction);
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//
//        // ATTENTION: This was auto-generated to implement the App Indexing API.
//        // See https://g.co/AppIndexing/AndroidStudio for more information.
//        Action viewAction = Action.newAction(
//                Action.TYPE_VIEW, // TODO: choose an action type.
//                "PodstawoweInfo Page", // TODO: Define a title for the content shown.
//                // TODO: If you have web page content that matches this app activity's content,
//                // make sure this auto-generated web page URL is correct.
//                // Otherwise, set the URL to null.
//                Uri.parse("http://host/path"),
//                // TODO: Make sure this auto-generated app deep link URI is correct.
//                Uri.parse("android-app://com.example.mtrzepacz.wfrpcharactergenerator/http/host/path")
//        );
//        AppIndex.AppIndexApi.end(client, viewAction);
//        client.disconnect();
//    }
//}
