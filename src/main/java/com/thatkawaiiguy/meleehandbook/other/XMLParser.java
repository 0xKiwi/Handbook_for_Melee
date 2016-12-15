package com.thatkawaiiguy.meleehandbook.other;

import android.content.res.Resources;

import com.thatkawaiiguy.meleehandbook.R;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Ivan Martinez on 12/12/2016.
 */

public class XMLParser {

    public static String getInnerXml(XmlPullParser parser)
            throws XmlPullParserException, IOException {
        StringBuilder sb = new StringBuilder();
        int depth = 1;
        while (depth != 0) {
            switch (parser.next()) {
                case XmlPullParser.END_TAG:
                    depth--;
                    if (depth > 0) {
                        sb.append("</" + parser.getName() + ">");
                    }
                    break;
                case XmlPullParser.START_TAG:
                    depth++;
                    StringBuilder attrs = new StringBuilder();
                    for (int i = 0; i < parser.getAttributeCount(); i++) {
                        attrs.append(parser.getAttributeName(i) + "=\""
                                + parser.getAttributeValue(i) + "\" ");
                    }
                    sb.append("<" + parser.getName() + " " + attrs.toString() + ">");
                    break;
                default:
                    sb.append(parser.getText());
                    break;
            }
        }
        String content = sb.toString();
        return content;
    }

    public static String getInnerXMLfromTitle(int xmlid, String title, Resources resources) {
        try {
            XmlPullParser xpp = resources.getXml(xmlid);

            while (xpp.getEventType() != XmlPullParser.END_DOCUMENT) {
                if (xpp.getEventType() == XmlPullParser.START_TAG) {
                    if (xpp.getName().equals("string")) {
                        if (xpp.getAttributeValue(1).equals(title))
                            return getInnerXml(xpp);
                    }
                }

                xpp.next();
            }
        } catch (Throwable t) {
        }
        return resources.getString(R.string.debug_text);
    }

    public static String[] addAllTitlesToArray(Resources resources, int id){

        ArrayList<String> list = new ArrayList<>();

        try {
            XmlPullParser xpp = resources.getXml(id);

            while (xpp.getEventType()!=XmlPullParser.END_DOCUMENT) {
                if (xpp.getEventType()== XmlPullParser.START_TAG) {
                    if (xpp.getName().equals("string")) {
                        list.add(xpp.getAttributeValue(1));
                    }
                    if (xpp.getName().equals("string-array")) {
                        list.add(xpp.getAttributeValue(1));
                    }
                }

                xpp.next();
            }
        }
        catch (Throwable t) {
        }

        return list.toArray(new String[list.size()]);
    }



    public static String[] getTabs(Resources resources, String title, int id){

        ArrayList<String> list = new ArrayList<>();

        try {
            XmlPullParser xpp = resources.getXml(id);
            int eventType = xpp.getEventType();

            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagName = xpp.getName();

                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagName.equalsIgnoreCase("string-array")) {
                            if (xpp.getAttributeValue(1).equalsIgnoreCase(title)) {
                                int depth = Integer.valueOf(xpp.getAttributeValue(2));
                                int eventType2 = xpp.next();
                                int i = 0;
                                while(i < depth) {
                                    String tagName2 = xpp.getName();
                                    switch (eventType2) {
                                        case XmlPullParser.START_TAG:
                                            if (tagName2.equalsIgnoreCase("item")) {
                                                list.add(xpp.getAttributeValue(1));
                                                i++;
                                            }
                                            break;
                                    }
                                    eventType2 = xpp.next();
                                }
                                return list.toArray(new String[list.size()]);
                            }
                        }
                        break;
                    case XmlPullParser.TEXT:
                        break;
                    case XmlPullParser.END_TAG:
                        break;
                }
                eventType = xpp.next();
            }
        } catch (Throwable t){

        }
/*
            while (xpp.getEventType()!=XmlPullParser.END_DOCUMENT) {
                if (xpp.getEventType()== XmlPullParser.START_TAG) {
                    if (xpp.getName().equals("string-array")) {
                        xpp.getAttributeValue(1).equals(title);
                    }
                    if (xpp.getName().equals("string-array")) {
                        list.add(xpp.getAttributeValue(1));
                    }
                }

                xpp.next();
            }
        }
        catch (Throwable t) {
        }
*/
        return list.toArray(new String[list.size()]);
    }
}
