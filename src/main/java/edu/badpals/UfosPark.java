package edu.badpals;

import java.util.HashMap;
import java.util.Map;

public class UfosPark {
    private static final String LIBRE = "libre";
    private double fee = 500;
    private final Map<String,String> flota = new HashMap<>();

    UfosPark(){}
    void add(String ufo){
        flota.put(ufo,LIBRE);
    }

    public void dispatch(CreditCard tarjeta){
        String ufoLibre = "";
        for (Map.Entry<String ,String> ufo : flota.entrySet()){
            if (ufo.getValue().equals(LIBRE)){
                ufoLibre = ufo.getKey();
                break;
            }
        }
        if (!ufoLibre.equals("") && tarjeta.pay(this.fee)){
            flota.replace(ufoLibre, LIBRE, tarjeta.getOwner());
        }
    }
}
