package com.example.mtrzepacz.wfrpcharactergenerator;
        import java.io.File;
        import java.io.FileOutputStream;
        import java.io.IOException;
        import java.io.InputStream;
        import java.io.OutputStream;
        import java.util.ArrayList;
        import java.util.List;
        import android.content.Context;
        import android.database.Cursor;
        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteException;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.util.Log;
public class DataHelper extends SQLiteOpenHelper {
    private final static String TAG = "DatabaseHelper";
    private final Context myContext;
    private static final String DATABASE_NAME = "profesje.db";
    private static final int DATABASE_VERSION = 1;
    private String pathToSaveDBFile;
    public DataHelper(Context context, String filePath) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.myContext = context;
        pathToSaveDBFile = new StringBuffer(filePath).append("/").append(DATABASE_NAME).toString();
    }
    public void prepareDatabase() throws IOException {
        boolean dbExist = checkDataBase();
        if(dbExist) {
            Log.d(TAG, "Database exists.");
           // int currentDBVersion = getVersionId();
           // if (DATABASE_VERSION > currentDBVersion) {
                Log.d(TAG, "Database version is higher than old.");
                deleteDb();
                try {
                    copyDataBase();
                } catch (IOException e) {
                    Log.e(TAG, e.getMessage());
                }
         //   }
       // } else {
//            try {
//                copyDataBase();
//            } catch (IOException e) {
//                Log.e(TAG, e.getMessage());
//            }
        }
    }
    private boolean checkDataBase() {
        boolean checkDB = false;
        try {
            File file = new File(pathToSaveDBFile);
            checkDB = file.exists();
        } catch(SQLiteException e) {
            Log.d(TAG, e.getMessage());
        }
        return checkDB;
    }
    private void copyDataBase() throws IOException {
        OutputStream os = new FileOutputStream(pathToSaveDBFile);
        InputStream is = myContext.getAssets().open(DATABASE_NAME);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = is.read(buffer)) > 0) {
            os.write(buffer, 0, length);
        }
        is.close();
        os.flush();
        os.close();
    }
    public void deleteDb() {
        File file = new File(pathToSaveDBFile);
        if(file.exists()) {
            file.delete();
            Log.d(TAG, "Database deleted.");
        }
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate");
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }




    public Profesja getProfesja(String nazwa) {
        SQLiteDatabase db = SQLiteDatabase.openDatabase(pathToSaveDBFile, null, SQLiteDatabase.OPEN_READONLY);
        String query = "SELECT id,nazwa,czyPodstawowa,ww,us,k,odp,zr,inte,sw,ogd,a,zyw,szy,mag FROM Profesje  WHERE nazwa = ?";
        Cursor cursor = db.rawQuery(query,  new String[] {nazwa});
        List<Profesja> list = new ArrayList<Profesja>();
        while(cursor.moveToNext()) {
            Profesja prof = new Profesja();

            prof.nazwaProfesji=cursor.getString(1);
            prof.czyPodstawowa=cursor.getString(2);
            prof.walkaWrecz=cursor.getString(3);
            prof.umiejetnosciStrzeleckie=cursor.getString(4);
            prof.krzepa=cursor.getString(5);
            prof.odpornosc=cursor.getString(6);
            prof.zrecznosc=cursor.getString(7);
            prof.inteligencja=cursor.getString(8);
            prof.silaWoli=cursor.getString(9);
            prof.oglada=cursor.getString(10);
            prof.ataki=cursor.getString(11);
            prof.zywotnosc=cursor.getString(12);
            prof.szybkosc=cursor.getString(13);
            prof.magia=cursor.getString(14);

            list.add(prof);
        }
        db.close();
        return list.get(0);
    }


    public List<Profesja> getWszystkieProfesje() {
        SQLiteDatabase db = SQLiteDatabase.openDatabase(pathToSaveDBFile, null, SQLiteDatabase.OPEN_READONLY);
        String query = "SELECT id,nazwa,czyPodstawowa,ww,us,k,odp,zr,inte,sw,ogd,a,zyw,szy,mag FROM Profesje";
        Cursor cursor = db.rawQuery(query,  null);
        List<Profesja> list = new ArrayList<Profesja>();
        while(cursor.moveToNext()) {
            Profesja prof = new Profesja();
            prof.nazwaProfesji=cursor.getString(1);
            list.add(prof);
        }
        db.close();
        return list;
    }




    private int getVersionId() {
        SQLiteDatabase db = SQLiteDatabase.openDatabase(pathToSaveDBFile, null, SQLiteDatabase.OPEN_READONLY);
        String query = "SELECT version_id FROM dbVersion";
        Cursor cursor = db.rawQuery(query, null);
        cursor.moveToFirst();
        int v =  cursor.getInt(0);
        db.close();
        return v;
    }
}