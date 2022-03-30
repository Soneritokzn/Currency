package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.SQLOutput;

public class Main {


    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, TransformerException {
        URL url = new URL("https://cbr.ru/scripts/XML_daily.asp");
        URLConnection conn = url.openConnection();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(conn.getInputStream());
        doc.getDocumentElement().normalize();
        NodeList valuteList = doc.getElementsByTagName("Valute");

        for (int i = 0; i < valuteList.getLength(); i++){
            Node valute = valuteList.item(i);
            if (valute.getNodeType() == Node.ELEMENT_NODE){

                Element valuteElement = (Element) valute;
                System.out.println(valuteElement.getAttribute("Valute"));

               NodeList valuteDetails = valuteElement.getChildNodes();
               for(int j = 0; j < valuteDetails.getLength(); j++){
                   Node detail = valuteDetails.item(j);
                   if (detail.getNodeType() == Node.ELEMENT_NODE){
                       Element detailElement = (Element) detail;
                       System.out.println("   " + detailElement.getTagName() +"; ");
                   }

               }
            }

        }


    }
}
