package com.example.mtrzepacz.wfrpcharactergenerator;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.net.Uri;
import android.os.Environment;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
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
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class MainMenu extends AppCompatActivity {
    private static String DB_NAME ="profesje";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
//    private GoogleApiClient client;

    ViewFlipper viewFlipper;
    private float lastX;
    boolean isFirstTime=true;
    DataHelper dbHelper;
    Profesja profesja;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewFlipper);
       InitializeDB();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        //client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void InitializeDB(){
        //baza danych

        dbHelper = new DataHelper(this, getFilesDir().getAbsolutePath());
        try {
            dbHelper.prepareDatabase();
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    public void newChara_click(View v) {
        Postac.Wyczysc();
        PodstawoweInfoPopulateFields();
        isFirstTime=false;

        viewFlipper.setInAnimation(this, R.anim.in_from_right);
        viewFlipper.setOutAnimation(this, R.anim.out_to_left);
        viewFlipper.showNext();

        profesja= dbHelper.getProfesja("akolita");


//        Intent i = new Intent(MainMenu.this, PodstawoweInfo.class);
//        startActivity(i);
    }


    public void saveCahra_click(View v) {
        PodstawoweInfoApplyChanges();
        Serializer serializer = new Persister();
        //File file = new File(getFilesDir(), "postac.xml");
        File file = new File(getAlbumStorageDir(this),Postac.getInstance().imie_naziwsko+".xml");



        try {
            serializer.write(Postac.getInstance(), file);
            Toast.makeText(getBaseContext(), "Zapisano pomyślnie postać: "+Postac.getInstance().imie_naziwsko.toString(), Toast.LENGTH_LONG).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadChara_click(View v) {
        Postac.Wyczysc();

        File f = getAlbumStorageDir(this);
        File file[] = f.listFiles();
        final List<String> stuff = new ArrayList<String>();
        for (int i=0; i < file.length; i++)
        {
            stuff.add(file[i].getName());
        }

        final CharSequence[] postacie = stuff.toArray(new CharSequence[stuff.size()]);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Wybierz postać do wysłania:");
        builder.setItems(postacie, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // the user clicked on postacie[which]
                File wybrana = new File(getAlbumStorageDir(getBaseContext()), stuff.get(which));


                Serializer serializer = new Persister();
                //File source = new File(getAlbumStorageDir(this), "postac.xml");
                try {
                    // Profesja prof = serializer.read(Profesja.class, source);
                    Postac.setInstance(serializer.read(Postac.class, wybrana));
                    //Postac.getInstance().imie_naziwsko = prof.getNazwa();
                    Toast.makeText(getBaseContext(), "Wczytano postac: "+Postac.getInstance().imie_naziwsko, Toast.LENGTH_SHORT).show();
                    PodstawoweInfoPopulateFields();
                    isFirstTime=false;
                    viewFlipper.setInAnimation(getBaseContext(), R.anim.in_from_right);
                    viewFlipper.setOutAnimation(getBaseContext(), R.anim.out_to_left);
                    viewFlipper.showNext();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        builder.show();

    }


    public File getAlbumStorageDir(Context context) {
        // Get the directory for the app's private pictures directory.
        File file = new File(context.getExternalFilesDir(
                Environment.DIRECTORY_DOCUMENTS), "WarhammerSaveFiles");
        if (!file.mkdirs()) {
            //Toast.makeText(getBaseContext(),"Directory not created",Toast.LENGTH_LONG).show();
        }
        return file;
    }


    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }

    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }





    public boolean onTouchEvent(MotionEvent touchevent) {
        switch (touchevent.getAction()) {

            case MotionEvent.ACTION_DOWN: {
                PodstawoweInfoApplyChanges();
                UpdateFinalFields();
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
                    if(isFirstTime){
                        Postac.Wyczysc();
                        isFirstTime=false;
                    }
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
                ((InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE))
                        .toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0);
                break;
            case 1:
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


        //cechy1
        currText = (EditText) findViewById(R.id.baseWW);
        currText.setText(String.valueOf(Postac.getInstance().walkaWrecz));

        currText = (EditText) findViewById(R.id.baseUS);
        currText.setText(String.valueOf(Postac.getInstance().umiejetnosciStrzeleckie));

        currText = (EditText) findViewById(R.id.baseK);
        currText.setText(String.valueOf(Postac.getInstance().krzepa));

        currText = (EditText) findViewById(R.id.baseOdp);
        currText.setText(String.valueOf(Postac.getInstance().odpornosc));

        currText = (EditText) findViewById(R.id.baseZr);
        currText.setText(String.valueOf(Postac.getInstance().zrecznosc));

        currText = (EditText) findViewById(R.id.baseInt);
        currText.setText(String.valueOf(Postac.getInstance().inteligencja));

        currText = (EditText) findViewById(R.id.baseSW);
        currText.setText(String.valueOf(Postac.getInstance().silaWoli));

        currText = (EditText) findViewById(R.id.baseOgd);
        currText.setText(String.valueOf(Postac.getInstance().oglada));






        //cechy2

        currText = (EditText) findViewById(R.id.baseA);
        currText.setText(String.valueOf(Postac.getInstance().ataki));

        currText = (EditText) findViewById(R.id.baseZyw);
        currText.setText(String.valueOf(Postac.getInstance().zywotnosc));



        currText = (EditText) findViewById(R.id.baseWt);
        currText.setText(String.valueOf(Postac.getInstance().wytrzymalosc));

        currText = (EditText) findViewById(R.id.baseSzy);
        currText.setText(String.valueOf(Postac.getInstance().szybkosc));

        currText = (EditText) findViewById(R.id.baseMag);
        currText.setText(String.valueOf(Postac.getInstance().magia));

        currText = (EditText) findViewById(R.id.basePO);
        currText.setText(String.valueOf(Postac.getInstance().punktyObledu));

        currText = (EditText) findViewById(R.id.basePP);
        currText.setText(String.valueOf(Postac.getInstance().punktyPrzeznaczenia));

        UpdateFinalFields();
    }


    void UpdateFinalFields(){


        EditText currText = (EditText) findViewById(R.id.sumWW);
        currText.setText(String.valueOf(Postac.getInstance().walkaWrecz+Postac.getInstance().walkaWreczPlus));

        currText = (EditText) findViewById(R.id.sumUS);
        currText.setText(String.valueOf(Postac.getInstance().umiejetnosciStrzeleckie+Postac.getInstance().umiejetnosciStrzeleckiePlus));

        currText = (EditText) findViewById(R.id.sumK);
        currText.setText(String.valueOf(Postac.getInstance().krzepa+Postac.getInstance().krzepaPlus));

        currText = (EditText) findViewById(R.id.sumOdp);
        currText.setText(String.valueOf(Postac.getInstance().odpornosc+Postac.getInstance().odpornoscPlus));

        currText = (EditText) findViewById(R.id.sumZr);
        currText.setText(String.valueOf(Postac.getInstance().zrecznosc+Postac.getInstance().zrecznoscPlus));

        currText = (EditText) findViewById(R.id.sumInt);
        currText.setText(String.valueOf(Postac.getInstance().inteligencja+Postac.getInstance().inteligencjaPlus));

        currText = (EditText) findViewById(R.id.sumSW);
        currText.setText(String.valueOf(Postac.getInstance().silaWoli+Postac.getInstance().silaWoliPlus));

        currText = (EditText) findViewById(R.id.sumOgd);
        currText.setText(String.valueOf(Postac.getInstance().oglada+Postac.getInstance().ogladaPlus));


        //cechy2 ---bonusy
        currText = (EditText) findViewById(R.id.currA);
        currText.setText(String.valueOf(Postac.getInstance().ataki+Postac.getInstance().atakiPlus));

        currText = (EditText) findViewById(R.id.currZyw);
        currText.setText(String.valueOf(Postac.getInstance().zywotnosc+Postac.getInstance().zywotnoscPlus));



        currText = (EditText) findViewById(R.id.currSzy);
        currText.setText(String.valueOf(Postac.getInstance().szybkosc+Postac.getInstance().szybkoscPlus));

        currText = (EditText) findViewById(R.id.currMag);
        currText.setText(String.valueOf(Postac.getInstance().magia+Postac.getInstance().magiaPlus));

        currText = (EditText) findViewById(R.id.currPO);
        currText.setText(String.valueOf(Postac.getInstance().punktyObledu+Postac.getInstance().punktyObleduPlus));

        currText = (EditText) findViewById(R.id.currPP);
        currText.setText(String.valueOf(Postac.getInstance().punktyPrzeznaczenia+Postac.getInstance().punktyPrzeznaczeniaPlus));



        currText = (EditText) findViewById(R.id.baseS);
        EditText krzepa = (EditText)findViewById(R.id.sumK);
        currText.setText(krzepa.getText().subSequence(0, 1));

        currText = (EditText) findViewById(R.id.baseWt);
        EditText odpornosc = (EditText)findViewById(R.id.sumOdp);
        currText.setText(odpornosc.getText().subSequence(0, 1));
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


        //cechy1
        currText = (EditText) findViewById(R.id.baseWW);
        Postac.getInstance().walkaWrecz = Integer.parseInt(currText.getText().toString());

        currText = (EditText) findViewById(R.id.baseUS);
        Postac.getInstance().umiejetnosciStrzeleckie = Integer.parseInt(currText.getText().toString());

        currText = (EditText) findViewById(R.id.baseK);
        Postac.getInstance().krzepa = Integer.parseInt(currText.getText().toString());

        currText = (EditText) findViewById(R.id.baseOdp);
        Postac.getInstance().odpornosc = Integer.parseInt(currText.getText().toString());

        currText = (EditText) findViewById(R.id.baseZr);
        Postac.getInstance().zrecznosc = Integer.parseInt(currText.getText().toString());

        currText = (EditText) findViewById(R.id.baseInt);
        Postac.getInstance().inteligencja = Integer.parseInt(currText.getText().toString());

        currText = (EditText) findViewById(R.id.baseSW);
        Postac.getInstance().silaWoli = Integer.parseInt(currText.getText().toString());

        currText = (EditText) findViewById(R.id.baseOgd);
        Postac.getInstance().oglada = Integer.parseInt(currText.getText().toString());

        //cechy2
        currText = (EditText) findViewById(R.id.baseA);
        Postac.getInstance().ataki = Integer.parseInt(currText.getText().toString());

        currText = (EditText) findViewById(R.id.baseZyw);
        Postac.getInstance().zywotnosc = Integer.parseInt(currText.getText().toString());

        currText = (EditText) findViewById(R.id.baseS);
        Postac.getInstance().sila = Integer.parseInt(currText.getText().toString());

        currText = (EditText) findViewById(R.id.baseWt);
        Postac.getInstance().wytrzymalosc = Integer.parseInt(currText.getText().toString());

        currText = (EditText) findViewById(R.id.baseSzy);
        Postac.getInstance().szybkosc = Integer.parseInt(currText.getText().toString());

        currText = (EditText) findViewById(R.id.baseMag);
        Postac.getInstance().magia = Integer.parseInt(currText.getText().toString());

        currText = (EditText) findViewById(R.id.basePO);
        Postac.getInstance().punktyObledu = Integer.parseInt(currText.getText().toString());

        currText = (EditText) findViewById(R.id.basePP);
        Postac.getInstance().punktyPrzeznaczenia = Integer.parseInt(currText.getText().toString());

    }


    public void Wyslij_click(View view){


        File f = getAlbumStorageDir(this);
        File file[] = f.listFiles();
        final List<String> stuff = new ArrayList<String>();
        for (int i=0; i < file.length; i++)
        {
            stuff.add(file[i].getName());
        }

        final CharSequence[] postacie = stuff.toArray(new CharSequence[stuff.size()]);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Wybierz postać do wysłania:");
        builder.setItems(postacie, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // the user clicked on postacie[which]
                File wybrana = new File(getAlbumStorageDir(getBaseContext()), stuff.get(which));

              //  Toast.makeText(getBaseContext(), "Wysyłanie...", Toast.LENGTH_LONG).show();
                // if (Postac.getInstance().imie_naziwsko.length() > 0) {
                // String filename = "postac.xml";
                // File filelocation = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), filename);
                //File filelocation = new File(getAlbumStorageDir(getBaseContext()), "postac.xml");
                Uri path = Uri.fromFile(wybrana);
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
// set the type to 'email'
                emailIntent.setType("vnd.android.cursor.dir/email");
                String to[] = {""};
                emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
// the attachment
                emailIntent.putExtra(Intent.EXTRA_STREAM, path);
// the mail subject
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Zapis postaci: " + wybrana.getName().substring(0, wybrana.getName().length()-4));
                startActivity(Intent.createChooser(emailIntent, "Wyślij postać emailem..."));
                // } else {
                // Toast.makeText(getBaseContext(), "Nadaj imie postaci", Toast.LENGTH_LONG).show();
                //  }


            }
        });
        builder.show();


    }
}