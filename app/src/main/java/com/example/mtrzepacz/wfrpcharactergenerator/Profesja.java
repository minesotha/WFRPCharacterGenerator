package com.example.mtrzepacz.wfrpcharactergenerator;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by mtrzepacz on 18.06.2016.
 */

public class Profesja {

    public String id="id";
    public String nazwaProfesji="nazwa";
    public String czyPodstawowa="czyPodstawowa";
    //Cechy główne
    /**walka wręcz*/
    public String walkaWrecz="WW";
    /** umiejętności strzeleckie*/
    public  String umiejetnosciStrzeleckie ="US";
    /** krzepa */
    public String krzepa="K";
    /** odporność */
    public  String odpornosc ="ODP";
    /** zręcznosć */
    public String zrecznosc="ZR";
    /** inteligencja */
    public  String inteligencja="INT";
    /** siła woli */
    public  String silaWoli="SW";
    /** ogłada */
    public  String oglada="OGD";

    //cechy drugorzędne
    /** ataki */
    public String ataki="A";
    /** żywotność */
    public  String zywotnosc="ZYW";
    public  String szybkosc="SZ";
    /**magia */
    public  String magia="MAG";
    /** punkty obledu */
    public  String punktyObledu="PO";
    /** punkty przeznaczenia */
    public  String punktyPrzeznaczenia="PP";


    public Profesja() {

    }


}
