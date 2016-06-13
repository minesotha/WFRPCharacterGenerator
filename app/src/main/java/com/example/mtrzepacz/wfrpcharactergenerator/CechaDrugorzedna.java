package com.example.mtrzepacz.wfrpcharactergenerator;

/**
 * Created by mtrzepacz on 13.06.2016.
 */
public class CechaDrugorzedna {
    String nazwaCechy;
    int wartoscPoczatkowa;
    int zakupioneRozwiniecia;
    public CechaDrugorzedna(String nazwaCechy, int wartoscPoczatkowa, int zakupioneRozwiniecia){

        this.nazwaCechy = nazwaCechy;
        this.wartoscPoczatkowa = wartoscPoczatkowa;
        this.zakupioneRozwiniecia = zakupioneRozwiniecia;
    }
    public CechaDrugorzedna(String nazwaCechy, int wartoscPoczatkowa){

        this.nazwaCechy = nazwaCechy;
        this.wartoscPoczatkowa = wartoscPoczatkowa;
        this.zakupioneRozwiniecia = 0;
    }

}
