package com.example.mtrzepacz.wfrpcharactergenerator;

import java.util.List;

/**
 * Created by mtrzepacz on 13.06.2016.
 */
public class Postac {
    //podstawowe info
    public String imie;
    public String nazwisko;
    public String rasa;
    public String profesja;
    public int expAll;
    public int expCurrent;

    //dodatekowe info
    public int wiek;
    public String kolor_wlosow;
    public String kolor_oczu;
    public Boolean czyMężczyzna;
    public int waga;
    public  String wzrost;
    public  int rodzeństwo;
    public  String miejsce_urodzenia;
    public  String znaki_szczegolne;

    //Cechy główne
    /**walka wręcz*/
    public  CechaGlowna walkaWrecz;
    /** umiejętności strzeleckie*/
    public  CechaGlowna umiejetnosciStrzeleckie;
    /** krzepa */
    public  CechaGlowna krzepa;
    /** odporność */
    public   CechaGlowna odpornosc;
    /** zręcznosć */
    public    CechaGlowna zrecznosc;
    /** inteligencja */
    public   CechaGlowna inteligencja;
    /** siła woli */
    public   CechaGlowna silaWoli;
    /** ogłada */
    public   CechaGlowna oglada;


    //cechy drugorzędne
    /** ataki */
    public CechaDrugorzedna ataki;
    /** żywotność */
    public CechaDrugorzedna zywotnosc;
    /** siła */
    public CechaDrugorzedna sila;
    /** wytrzymalosc */
    public CechaDrugorzedna wytrzymalosc;
    /**szybkosc */
    public CechaDrugorzedna szybkosc;
    /**magia */
    public CechaDrugorzedna magia;
    /** punkty obledu */
    public CechaDrugorzedna punktyObledu;
    /** punkty przeznaczenia */
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

    //konstruktor
    public Postac(){
        //TODO - losowane rzeczy?

    }

}
