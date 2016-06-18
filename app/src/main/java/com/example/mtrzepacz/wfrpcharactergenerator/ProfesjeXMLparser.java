package com.example.mtrzepacz.wfrpcharactergenerator;

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mtrzepacz on 18.06.2016.
 */
public class ProfesjeXMLparser {

    private static final String ns = null;

    public List parse(InputStream in) throws XmlPullParserException, IOException {
        try {
            XmlPullParser parser = Xml.newPullParser();
            parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
            parser.setInput(in, null);
            parser.nextTag();
            return czytajProfesje(parser);
        } finally {
            in.close();
        }
    }

    private List czytajProfesje(XmlPullParser parser) throws XmlPullParserException, IOException {
        List profesje = new ArrayList();

        parser.require(XmlPullParser.START_TAG, ns, "listaProfesji");
        while (parser.next() != XmlPullParser.END_TAG) {
            if (parser.getEventType() != XmlPullParser.START_TAG) {
                continue;
            }
            String name = parser.getName();
            // Starts by looking for the entry tag
            if (name.equals("profesja")) {
                profesje.add(czytajProfesje(parser));
            } else {
                Skip(parser);
            }
        }
        return profesje;
    }

    private void Skip(XmlPullParser parser) throws XmlPullParserException, IOException {
        if (parser.getEventType() != XmlPullParser.START_TAG) {
            throw new IllegalStateException();
        }
        int depth = 1;
        while (depth != 0) {
            switch (parser.next()) {
                case XmlPullParser.END_TAG:
                    depth--;
                    break;
                case XmlPullParser.START_TAG:
                    depth++;
                    break;
            }
        }
    }
}
