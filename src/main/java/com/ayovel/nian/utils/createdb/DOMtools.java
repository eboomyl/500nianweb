package com.ayovel.nian.utils.createdb;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by admin on 2014/9/29.
 */
public class DOMtools {
    public static Document parse(String filePath) {
        Document document = null;
        try {
            //DOM parser instance
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            //parse an XML file into a DOM tree
            document = builder.parse(new File(filePath));
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    public static Document create() {
        ;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document= builder.newDocument();
            return document;
        } catch (ParserConfigurationException e) {
            e.printStackTrace();

        }
        return null;
    }
}
