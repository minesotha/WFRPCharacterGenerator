package com.example.mtrzepacz.wfrpcharactergenerator;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by mtrzepacz on 13.06.2016.
 */
@Root
public class CechaGlowna {
    @Element
    String nazwaCechy;
    @Element
    int wartoscPoczatkowa;
    @Element
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
