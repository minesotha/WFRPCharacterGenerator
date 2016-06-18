package com.example.mtrzepacz.wfrpcharactergenerator;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

/**
 * Created by mtrzepacz on 18.06.2016.
 */
@Root
public class Profesja {
    @Element
    private String nazwa;
    @Attribute
    private int index;
    public Profesja(){
        super();
    }

    public Profesja(String nazwa, int index) {
        this.nazwa = nazwa;
        this.index = index;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getId() {
        return index;
    }

}
