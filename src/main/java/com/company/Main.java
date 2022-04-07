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
import java.util.*;
import java.util.concurrent.Callable;

public class Main {


    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException, TransformerException {
        URL url = new URL("https://cbr.ru/scripts/XML_daily.asp");
        URLConnection conn = url.openConnection();

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(conn.getInputStream());
        doc.getDocumentElement().normalize();

        List<CurrencyData> currencyDataList = new ArrayList<>();
        String numCode = null;
        String charCode = null;
        String nominal = null;
        String name = null;
        String value = null;



        NodeList valute = (NodeList) doc.getElementsByTagName("Valute");
        for(int i = 0; i < valute.getLength(); i++) {
            NodeList valuteElement = (NodeList) valute.item(i);
            for (int j = 0; j < valuteElement.getLength(); j++){
                Node detail = valuteElement.item(j);
                /*System.out.println("    " + detail.getTextContent() +";");*/

                switch (detail.getNodeName()) {
                    case "NumCode":{
                        numCode = detail.getTextContent();

                    }
                    case "CharCode":{
                        charCode = detail.getTextContent();

                    }
                    case"Nominal":{
                        nominal = detail.getTextContent();

                    }
                    case "Name":{
                       name = detail.getTextContent();
                    }
                    case "Value":{
                        value = detail.getTextContent();
                    }
                }

            }
            CurrencyData currencyData = new CurrencyData(numCode,charCode, nominal, name, value);
            currencyDataList.add(currencyData);


        }

        Scanner sc = new Scanner(System.in);
        /*System.out.println("Введите валюту 1 ");
        String userEntryFirst = sc.next();
        System.out.println("Введите валюту 2");
        String userEntrySecond = sc.next();*/
        System.out.println("Введите количество");
        Integer amount = sc.nextInt();


        for (int y = 0; y < currencyDataList.size(); y++){

            /*System.out.println(currencyDataList.get(y).getName() +"  "+ currencyDataList.get(y).getValue());*/

        }
        String str1 = currencyDataList.get(7).getValue();
        String str2 = currencyDataList.get(18).getValue();
        str1 = str1.replace(",",".");
        str2 = str2.replace(",",".");
        float num1 = Float.parseFloat(str1);
        float num2 = Float.parseFloat(str2);
        float result = num1 / num2 * amount;


        System.out.println(currencyDataList.get(7).getName());
        System.out.println(num1);
        System.out.println(currencyDataList.get(18).getName());
        System.out.println(num2);
        System.out.println(result);



    }
}











