package com.example.mtrzepacz.wfrpcharactergenerator;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

/**
 * Created by mtrzepacz on 18.06.2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    static final String dbName="WarammerDB";
    static final String ProfesjeTab="Profesje";
    static final String ProfesjaID="id";
    static final String nazwaProfesji="nazwa";
    static final String czyPodstawowa="czyPodstawowa";
    //Cechy główne
    /**walka wręcz*/
    public static final String walkaWrecz="WW";
    /** umiejętności strzeleckie*/
    public static final String umiejetnosciStrzeleckie ="US";
    /** krzepa */
    public static final String krzepa="K";
    /** odporność */
    public static final String odpornosc ="ODP";
    /** zręcznosć */
    public static final String zrecznosc="ZR";
    /** inteligencja */
    public static final String inteligencja="INT";
    /** siła woli */
    public static final String silaWoli="SW";
    /** ogłada */
    public static final String oglada="OGD";

    //cechy drugorzędne
    /** ataki */
    public static final String ataki="A";
    /** żywotność */
    public static final String zywotnosc="ZYW";
    /** siła */
    public static final String sila="S";
    /** wytrzymalosc */
    public static final String wytrzymalosc="WT";
    /**szybkosc */
    public static final String szybkosc="SZ";
    /**magia */
    public static final String magia="MAG";
    /** punkty obledu */
    public static final String punktyObledu="PO";
    /** punkty przeznaczenia */
    public static final String punktyPrzeznaczenia="PP";


    public DatabaseHelper(Context context) {
        super(context, dbName, null,1);
    }



    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub

        db.execSQL("CREATE TABLE IF NOT EXISTS "+ProfesjeTab+" ("+ProfesjaID+ " INTEGER PRIMARY KEY , "+
                nazwaProfesji+ " TEXT)");
        db.execSQL("CREATE TABLE " + ProfesjeTab + "(id INTEGER PRIMARY KEY AUTOINCREMENT, nazwa TEXT,czyPodstawowa Integer,WW Integer,US Integer,K Integer, ODP Integer,ZR Integer,INT Integer,SW Integer,OGD Integer, A Integer,ZYW Integer,SZ Integer,MAG Integer,PO Integer)");

        XmlPullParser xmlParser = Xml.newPullParser();

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub

        db.execSQL("DROP TABLE IF EXISTS "+ProfesjeTab);

        onCreate(db);
    }
}
