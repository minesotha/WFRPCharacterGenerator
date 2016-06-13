package com.example.mtrzepacz.wfrpcharactergenerator;

/**
 * Created by mtrzepacz on 13.06.2016.
 */
public class Umiejetnosc {
    String nazwaUmiejetnosci;
    int poziomUmiejetnosci;
    public Umiejetnosc(String nazwaUmiejetnosci, int poziomUmiejetnosci){
        this.nazwaUmiejetnosci = nazwaUmiejetnosci;
        this.poziomUmiejetnosci = poziomUmiejetnosci;
    }
    public Umiejetnosc(String nazwaUmiejetnosci){
        this.nazwaUmiejetnosci = nazwaUmiejetnosci;
        this.poziomUmiejetnosci = RozwinieciaUmiejetnosci.podstawowa;
    }
}
