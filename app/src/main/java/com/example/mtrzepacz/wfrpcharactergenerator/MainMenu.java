package com.example.mtrzepacz.wfrpcharactergenerator;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        //client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void newChara_click(View v) {
        Postac.Wyczysc();
        Intent i = new Intent(MainMenu.this, PodstawoweInfo.class);
        startActivity(i);
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

        startActivity(new Intent(MainMenu.this, PodstawoweInfo.class));

    }



//tworzenie/sprawdzanie bazy danych

}
