package com.example.mtrzepacz.wfrpcharactergenerator;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
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

                    viewFlipper.setInAnimation(this, R.anim.in_from_left);
                    viewFlipper.setOutAnimation(this, R.anim.out_to_right);
                    // Show The Previous Screen
                    viewFlipper.showPrevious();
                }

                // if right to left swipe on screen
                if (lastX > currentX) {
                    if (viewFlipper.getDisplayedChild() == 4)
                        break;

                    viewFlipper.setInAnimation(this, R.anim.in_from_right);
                    viewFlipper.setOutAnimation(this, R.anim.out_to_left);
                    // Show the next Screen
                    viewFlipper.showNext();
                }
                break;
            }
        }
        return false;
    }



//tworzenie/sprawdzanie bazy danych

}
