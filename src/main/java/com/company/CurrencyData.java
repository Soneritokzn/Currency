package com.company;

public class CurrencyData {


    public CurrencyData(String numCode, String charCode, String nominal, String name, String value) {
        this.numCode = numCode;
        this.charCode = charCode;
        this.nominal = nominal;
        this.name = name;
        this.value = value;
    }

    public String getNumCode() {
        return numCode;
    }

    public String getCharCode() {
        return charCode;
    }

    public String getNominal() {
        return nominal;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    private String numCode;
    private String charCode;
    private String nominal;
    private String name;
    private String value;

}






/*
<NumCode>036</NumCode>
<CharCode>AUD</CharCode>
<Nominal>1</Nominal>
<Name>Австралийский доллар</Name>
<Value>63,2488</Value>*/



 /*NodeList valuteList = doc.getElementsByTagName("Valute");

        for (int i = 0; i < valuteList.getLength(); i++) {
            Node valute = valuteList.item(i);
            if (valute.getNodeType() == Node.ELEMENT_NODE) {
                Element valuteElement = (Element) valute;
                System.out.println(valuteElement.getAttribute("Valute"));
                NodeList valuteDetails = valuteElement.getChildNodes();
                for (int j = 0; j < valuteDetails.getLength(); j++) {
                    Node detail = valuteDetails.item(j);
                    if (detail.getNodeType() == Node.ELEMENT_NODE) {
                        Element detailElement = (Element) detail;
                     System.out.println("   " + detailElement.getTextContent() +"; ");
                        switch (detailElement.getNodeName()) {
                            case "Name": {
                                name = detailElement.getTextContent();
                            }
                            case "Value": {
                                value = (detailElement.getTextContent());
                            }
                        }
                    }
                    CurrencyData currencyData = new CurrencyData(name, value);
                    currencyDataList.add(currencyData);

                }
            }
        }*/
