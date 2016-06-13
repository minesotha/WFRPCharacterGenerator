package com.example.mtrzepacz.wfrpcharactergenerator;

/**
 * Created by mtrzepacz on 13.06.2016.
 */
public class CechaGlowna {
    String nazwaCechy;
    int wartoscPoczatkowa;
    int zakupioneRozwiniecia;
    public CechaGlowna(String nazwaCechy, int wartoscPoczatkowa, int zakupioneRozwiniecia){

        this.nazwaCechy = nazwaCechy;
        this.wartoscPoczatkowa = wartoscPoczatkowa;
        this.zakupioneRozwiniecia = zakupioneRozwiniecia;
    }
    public CechaGlowna(String nazwaCechy, int wartoscPoczatkowa){

       this.nazwaCechy = nazwaCechy;
        this.wartoscPoczatkowa = wartoscPoczatkowa;
        this.zakupioneRozwiniecia = 0;
    }

}
