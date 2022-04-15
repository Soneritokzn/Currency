package com.company;

import java.util.Objects;

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


    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}



/*
<NumCode>036</NumCode>
<CharCode>AUD</CharCode>
<Nominal>1</Nominal>
<Name>Австралийский доллар</Name>
<Value>63,2488</Value>*/



