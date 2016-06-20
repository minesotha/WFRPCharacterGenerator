package com.example.mtrzepacz.wfrpcharactergenerator;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;

import java.security.Key;

/**
 * Created by mtrzepacz on 18.06.2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    static final String dbName="WarammerDB";

    static final String ProfesjeTab="Profesje";


    public DatabaseHelper(Context context) {
        super(context, dbName, null, 1);
    }


    private SQLiteDatabase db;


    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        this.db = db;

//        db.execSQL("CREATE TABLE IF NOT EXISTS "+ProfesjeTab+" ("+ProfesjaID+ " INTEGER PRIMARY KEY , "+
//                nazwaProfesji+ " TEXT)");
        db.execSQL("CREATE TABLE 'Profesje' (`id`	INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,`nazwa`	TEXT, `czyPodstawowa`INTEGER,`ww`	INTEGER, `us`	INTEGER,`k`	INTEGER,`odp`	INTEGER,`zr`	INTEGER,`inte`	INTEGER,`sw`	INTEGER,`ogd`	INTEGER, `a`	INTEGER,`zyw`	INTEGER,`szy`	INTEGER,`mag`INTEGER"
        );
        db.execSQL("INSERT INTO `Profesje` VALUES (1,'akolita',1,5,5,0,5,0,10,10,10,0,2,0,0); " +
                "INSERT INTO `Profesje` VALUES (2,'banita',1,10,10,',',0,10,5,0,0,1,2,0,0); " +
                "COMMIT;");
        db.close(); // Closing database connection
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub


        this.db = db;
        db.execSQL("DROP TABLE IF EXISTS 'Profesje'");

        onCreate(db);
    }

    public Profesja getProfesja(String nazwa) {

        Cursor c = db.rawQuery("select * from list where nazwa = ?", new String[] {nazwa+""});





        Profesja prof = new Profesja();
        prof.nazwaProfesji = c.getString(0);
                //c.getString(1), c.getString(2));
        // return contact

        db.close();
        return prof;
    }


}
