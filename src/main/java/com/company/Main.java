package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.text.CollationKey;
import java.text.Collator;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {


    private static float num1;
    private static float num2;

    public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException {
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

        NodeList valute = doc.getElementsByTagName("Valute");
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
        System.out.println("Введите валюту 1 ");
        String userEntryFirst = sc.next();
        System.out.println("Введите валюту 2");
        String userEntrySecond = sc.next();
        System.out.println("Введите количество");
        int amount = sc.nextInt();

        Collator coll = Collator.getInstance();



        for (int y = 0; y < currencyDataList.size(); y++){



            boolean i = coll.equals(userEntryFirst, currencyDataList.get(y).getCharCode());
            boolean j = coll.equals(userEntrySecond, currencyDataList.get(y).getCharCode());
             if (i) {

                 System.out.println(currencyDataList.get(y).getName());
                 String val1 = currencyDataList.get(y).getValue();
                 val1 = val1.replace(",", ".");
                 System.out.println(val1);
                  num1 = Float.parseFloat(val1);
             }
             if (j) {
                 System.out.println(currencyDataList.get(y).getName());
                 String val2 = currencyDataList.get(y).getValue();
                 val2 = val2.replace(",", ".");
                 System.out.println(val2);
                 num2 = Float.parseFloat(val2);

             }


            /*System.out.println(currencyDataList.get(y).getName() +"  "+ currencyDataList.get(y).getValue());*/

        }
        float result = (num1 / num2) * amount;
        System.out.println(result);









        /*System.out.println(currencyDataList.get(7).getName());
        System.out.println(num1);
        System.out.println(currencyDataList.get(18).getName());
        System.out.println(num2);
        System.out.println(result);*/



    }


}











