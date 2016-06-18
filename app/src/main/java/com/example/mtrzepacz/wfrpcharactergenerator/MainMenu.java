package com.example.mtrzepacz.wfrpcharactergenerator;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

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
        startActivity(new Intent(MainMenu.this, PodstawoweInfo.class));
    }


    public void saveCahra_click(View v) {
        Serializer serializer = new Persister();
        Profesja prof = new Profesja(Postac.getInstance().imie_naziwsko, 666);
        File file = new File(getFilesDir(), "postac.xml");

        try {
            serializer.write(prof, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadChara_click(View v) {
        Serializer serializer = new Persister();
        File source = new File(getFilesDir(), "postac.xml");
        try {
            Profesja prof = serializer.read(Profesja.class, source);
            Postac.getInstance().imie_naziwsko = prof.getNazwa();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



//tworzenie/sprawdzanie bazy danych

}
