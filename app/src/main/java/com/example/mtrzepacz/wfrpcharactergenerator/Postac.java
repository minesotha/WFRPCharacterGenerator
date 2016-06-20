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

    }
    public static Postac getInstance(){
        if(instance==null){
            instance = new Postac();
        }
        return instance;
    }
    public static void setInstance(Postac postac){
        instance = postac;
    }

    public static void Wyczysc(){

        Postac.getInstance().imie_naziwsko=" ";
        Postac.getInstance().rasa=" ";
        Postac.getInstance().profesja=" ";
        Postac.getInstance().poprzedniaprofesja=" ";
        Postac.getInstance().expAll =0;
        Postac.getInstance().expCurrent=0;
        Postac.getInstance().wiek=0;
        Postac.getInstance().kolor_wlosow=" ";
        Postac.getInstance().kolor_oczu=" ";
        Postac.getInstance().czyMężczyzna=false;
        Postac.getInstance().waga=0;
        Postac.getInstance().wzrost=0;
        Postac.getInstance().rodzeństwo=" ";
        Postac.getInstance().miejsce_urodzenia=" ";
        Postac.getInstance().znaki_szczegolne=" ";
        Postac.getInstance().znak_gwiezdny=" ";

        Postac.getInstance().walkaWrecz = 0;
        Postac.getInstance().umiejetnosciStrzeleckie = 0;
        Postac.getInstance().krzepa = 0;
        Postac.getInstance().odpornosc = 0;
        Postac.getInstance().zrecznosc = 0;
        Postac.getInstance().inteligencja = 0;
        Postac.getInstance().silaWoli = 0;
        Postac.getInstance().oglada = 0;

        Postac.getInstance().walkaWreczPlus = 0;
        Postac.getInstance().umiejetnosciStrzeleckiePlus= 0;
        Postac.getInstance().krzepaPlus = 0;
        Postac.getInstance().odpornoscPlus = 0;
        Postac.getInstance().zrecznoscPlus = 0;
        Postac.getInstance().inteligencjaPlus = 0;
        Postac.getInstance().silaWoliPlus = 0;
        Postac.getInstance().ogladaPlus = 0;

        Postac.getInstance().ataki = 0;
        Postac.getInstance().zywotnosc = 0;
        Postac.getInstance().sila = 0;
        Postac.getInstance().wytrzymalosc= 0;
        Postac.getInstance().szybkosc= 0;
        Postac.getInstance().magia = 0;
        Postac.getInstance().punktyObledu = 0;
        Postac.getInstance().punktyPrzeznaczenia= 0;

        Postac.getInstance().atakiPlus = 0;
        Postac.getInstance().zywotnoscPlus = 0;
        Postac.getInstance().silaPlus = 0;
        Postac.getInstance().wytrzymaloscPlus= 0;
        Postac.getInstance().szybkoscPlus= 0;
        Postac.getInstance().magiaPlus = 0;
        Postac.getInstance().punktyObleduPlus = 0;
        Postac.getInstance().punktyPrzeznaczeniaPlus= 0;
    }

    //podstawowe info
    @Element
    public String imie_naziwsko;//=" ";
    @Element
    public String rasa;//=" ";
    @Element
    public String profesja;//=" ";
    @Element
    public String poprzedniaprofesja;//=" ";
    @Element
    public int expAll;// =0;
    @Element
    public int expCurrent;//=0;

    //dodatekowe info
    @Element
    public int wiek;//=0;
    @Element
    public String kolor_wlosow;//=" ";
    @Element
    public String kolor_oczu;//= " ";
    @Element
    public Boolean czyMężczyzna;//=false;
    @Element
    public int waga;//=0;
    @Element
    public  int wzrost;//=0;
    @Element
    public  String rodzeństwo;//=" ";
    @Element
    public  String miejsce_urodzenia;//=" ";
    @Element
    public  String znaki_szczegolne;//=" ";
    @Element
    public  String znak_gwiezdny;//=" ";

    //Cechy główne
    /**walka wręcz*/
    @Element
    public  int walkaWrecz;
    /** umiejętności strzeleckie*/
  @Element
    public  int umiejetnosciStrzeleckie;
    /** krzepa */
    @Element
    public  int krzepa;
    /** odporność */
    @Element
    public   int odpornosc;
    /** zręcznosć */
    @Element
    public    int zrecznosc;
    /** inteligencja */
    @Element
    public   int inteligencja;
    /** siła woli */
    @Element
    public   int silaWoli;
    /** ogłada */
    @Element
    public   int oglada;



    //Cechy główne --- rozwiniecia
    /**walka wręcz*/
    @Element
    public  int walkaWreczPlus;
    /** umiejętności strzeleckie*/
    @Element
    public  int umiejetnosciStrzeleckiePlus;
    /** krzepa */
    @Element
    public  int krzepaPlus;
    /** odporność */
    @Element
    public   int odpornoscPlus;
    /** zręcznosć */
    @Element
    public    int zrecznoscPlus;
    /** inteligencja */
    @Element
    public   int inteligencjaPlus;
    /** siła woli */
    @Element
    public   int silaWoliPlus;
    /** ogłada */
    @Element
    public   int ogladaPlus;


    //cechy drugorzędne
    /** ataki */
   @Element
    public int ataki;
    /** żywotność */
    @Element
    public int zywotnosc;
    /** siła */
    @Element
    public int sila;
    /** wytrzymalosc */
    @Element
    public int wytrzymalosc;
    /**szybkosc */
   @Element
    public int szybkosc;
    /**magia */
   @Element
    public int magia;
    /** punkty obledu */
      @Element
    public int punktyObledu;
    /** punkty przeznaczenia */
  //  @Element
    public int punktyPrzeznaczenia;

    //cechy drugorzędne ---  rozwiniecia
    /** ataki */
    @Element
    public int atakiPlus;
    /** żywotność */
    @Element
    public int zywotnoscPlus;
    /** siła */
    @Element
    public int silaPlus;
    /** wytrzymalosc */
    @Element
    public int wytrzymaloscPlus;
    /**szybkosc */
    @Element
    public int szybkoscPlus;
    /**magia */
    @Element
    public int magiaPlus;
    /** punkty obledu */
    @Element
    public int punktyObleduPlus;
    /** punkty przeznaczenia */
    //  @Element
    public int punktyPrzeznaczeniaPlus;



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
