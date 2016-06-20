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



        //TODO - losowane rzeczy?
    }
    public static Postac getInstance(){
        if(instance==null){
            instance = new Postac();
        }
        return instance;
    }

    public static void Wyczysc(){

        Postac.getInstance().imie_naziwsko="";
        Postac.getInstance().rasa="";
        Postac.getInstance().profesja="";
        Postac.getInstance().poprzedniaprofesja="";
        Postac.getInstance().expAll =0;
        Postac.getInstance().expCurrent=0;
        Postac.getInstance().wiek=0;
        Postac.getInstance().kolor_wlosow="";
        Postac.getInstance().kolor_oczu="";
        Postac.getInstance().czyMężczyzna=false;
        Postac.getInstance().waga=0;
        Postac.getInstance().wzrost=0;
        Postac.getInstance().rodzeństwo="";
        Postac.getInstance().miejsce_urodzenia="";
        Postac.getInstance().znaki_szczegolne="";
        Postac.getInstance().znak_gwiezdny="";
        Postac.getInstance().walkaWrecz = new CechaGlowna(NazwyCech.walkaWrecz,0,0);
        Postac.getInstance().umiejetnosciStrzeleckie = new CechaGlowna(NazwyCech.umiejetnosciStrzeleckie,0,0);
        Postac.getInstance().krzepa = new CechaGlowna(NazwyCech.krzepa,0,0);
        Postac.getInstance().odpornosc = new CechaGlowna(NazwyCech.odpornosc,0,0);
        Postac.getInstance().zrecznosc = new CechaGlowna(NazwyCech.zrecznosc,0,0);
        Postac.getInstance().inteligencja = new CechaGlowna(NazwyCech.inteligencja,0,0);
        Postac.getInstance().silaWoli = new CechaGlowna(NazwyCech.silaWoli,0,0);
        Postac.getInstance().oglada = new CechaGlowna(NazwyCech.oglada,0,0);

        Postac.getInstance().ataki = new CechaDrugorzedna(NazwyCech.ataki,0,0);
        Postac.getInstance().zywotnosc = new CechaDrugorzedna(NazwyCech.zywotnosc,0,0);
        Postac.getInstance().sila = new CechaDrugorzedna(NazwyCech.sila,0,0);
        Postac.getInstance().wytrzymalosc= new CechaDrugorzedna(NazwyCech.wytrzymalosc,0,0);
        Postac.getInstance().szybkosc= new CechaDrugorzedna(NazwyCech.szybkosc,0,0);
        Postac.getInstance().magia = new CechaDrugorzedna(NazwyCech.magia,0,0);
        Postac.getInstance().punktyObledu = new CechaDrugorzedna(NazwyCech.punktyObledu,0,0);
        Postac.getInstance().punktyPrzeznaczenia= new CechaDrugorzedna(NazwyCech.punktyPrzeznaczenia,0,0);


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
   // @Element
    public  CechaGlowna walkaWrecz;
    /** umiejętności strzeleckie*/
   // @Element
    public  CechaGlowna umiejetnosciStrzeleckie;
    /** krzepa */
    //@Element
    public  CechaGlowna krzepa;
    /** odporność */
  //  @Element
    public   CechaGlowna odpornosc;
    /** zręcznosć */
   // @Element
    public    CechaGlowna zrecznosc;
    /** inteligencja */
  //  @Element
    public   CechaGlowna inteligencja;
    /** siła woli */
  //  @Element
    public   CechaGlowna silaWoli;
    /** ogłada */
  //  @Element
    public   CechaGlowna oglada;


    //cechy drugorzędne
    /** ataki */
   // @Element
    public CechaDrugorzedna ataki;
    /** żywotność */
  //  @Element
    public CechaDrugorzedna zywotnosc;
    /** siła */
   // @Element
    public CechaDrugorzedna sila;
    /** wytrzymalosc */
   // @Element
    public CechaDrugorzedna wytrzymalosc;
    /**szybkosc */
   // @Element
    public CechaDrugorzedna szybkosc;
    /**magia */
  //  @Element
    public CechaDrugorzedna magia;
    /** punkty obledu */
   // @Element
    public CechaDrugorzedna punktyObledu;
    /** punkty przeznaczenia */
   // @Element
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
