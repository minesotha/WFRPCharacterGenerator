package com.example.mtrzepacz.wfrpcharactergenerator;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

import java.util.List;

/**
 * Created by mtrzepacz on 13.06.2016.
 */
@Root
public final class Postac {

    //konstruktor
    private static Postac instance = null;
    protected Postac(){
        walkaWrecz = new CechaGlowna(NazwyCech.walkaWrecz,0,0);
        umiejetnosciStrzeleckie = new CechaGlowna(NazwyCech.umiejetnosciStrzeleckie,0,0);
        krzepa = new CechaGlowna(NazwyCech.krzepa,0,0);
        odpornosc = new CechaGlowna(NazwyCech.odpornosc,0,0);
        zrecznosc = new CechaGlowna(NazwyCech.zrecznosc,0,0);
        inteligencja = new CechaGlowna(NazwyCech.inteligencja,0,0);
        silaWoli = new CechaGlowna(NazwyCech.silaWoli,0,0);
        oglada = new CechaGlowna(NazwyCech.oglada,0,0);

        ataki = new CechaDrugorzedna(NazwyCech.ataki,0,0);
        zywotnosc = new CechaDrugorzedna(NazwyCech.zywotnosc,0,0);
        sila = new CechaDrugorzedna(NazwyCech.sila,0,0);
        wytrzymalosc= new CechaDrugorzedna(NazwyCech.wytrzymalosc,0,0);
        szybkosc= new CechaDrugorzedna(NazwyCech.szybkosc,0,0);
        magia = new CechaDrugorzedna(NazwyCech.magia,0,0);
        punktyObledu = new CechaDrugorzedna(NazwyCech.punktyObledu,0,0);
        punktyPrzeznaczenia= new CechaDrugorzedna(NazwyCech.punktyPrzeznaczenia,0,0);


        //TODO - losowane rzeczy?
    }
    public static Postac getInstance(){
        if(instance==null){
            instance = new Postac();
        }
        return instance;
    }

    //podstawowe info
    @Element
    public String imie_naziwsko="";
    @Element
    public String rasa="";
    @Element
    public String profesja="";
    @Element
    public String poprzedniaprofesja="";
    @Element
    public int expAll =0;
    @Element
    public int expCurrent=0;

    //dodatekowe info
    @Element
    public int wiek=0;
    @Element
    public String kolor_wlosow="";
    @Element
    public String kolor_oczu="";
    @Element
    public Boolean czyMężczyzna=false;
    @Element
    public int waga=0;
    @Element
    public  int wzrost=0;
    @Element
    public  String rodzeństwo="";
    @Element
    public  String miejsce_urodzenia="";
    @Element
    public  String znaki_szczegolne="";
    @Element
    public  String znak_gwiezdny="";

    //Cechy główne
    /**walka wręcz*/
    @Element
    public  CechaGlowna walkaWrecz;
    /** umiejętności strzeleckie*/
    @Element
    public  CechaGlowna umiejetnosciStrzeleckie;
    /** krzepa */
    @Element
    public  CechaGlowna krzepa;
    /** odporność */
    @Element
    public   CechaGlowna odpornosc;
    /** zręcznosć */
    @Element
    public    CechaGlowna zrecznosc;
    /** inteligencja */
    @Element
    public   CechaGlowna inteligencja;
    /** siła woli */
    @Element
    public   CechaGlowna silaWoli;
    /** ogłada */
    @Element
    public   CechaGlowna oglada;


    //cechy drugorzędne
    /** ataki */
    @Element
    public CechaDrugorzedna ataki;
    /** żywotność */
    @Element
    public CechaDrugorzedna zywotnosc;
    /** siła */
    @Element
    public CechaDrugorzedna sila;
    /** wytrzymalosc */
    @Element
    public CechaDrugorzedna wytrzymalosc;
    /**szybkosc */
    @Element
    public CechaDrugorzedna szybkosc;
    /**magia */
    @Element
    public CechaDrugorzedna magia;
    /** punkty obledu */
    @Element
    public CechaDrugorzedna punktyObledu;
    /** punkty przeznaczenia */
    @Element
    public CechaDrugorzedna punktyPrzeznaczenia;


    //umiejętności
    public List<Umiejetnosc> umiejetnosci;

    //zdolności
    public List<Zdnolnosc> zdolnosci;

    //broń
    //TODO - klasa broń

    //pancerz
    //TODO - klasa pancerz

    //ekwpunek
    //TODO - klasa ekwipunek



}
