package edu.badpals.ricksy;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class UfosPark implements GuestDispatcher {
    private static final String LIBRE = "libre";
    private double fee = 500;
    private final Map<String,String> flota = new HashMap<>();

    UfosPark(){}
    void add(String ufo){
        flota.putIfAbsent(ufo,LIBRE);
    }

    @Override
    public void dispatch(CreditCard tarjeta){
        if (!this.getUfoOf(tarjeta.number()).equals("null")){
            return;
        }
        String ufoLibre = "";
        for (Map.Entry<String ,String> ufo : flota.entrySet()){
            if (ufo.getValue().equals(LIBRE)){
                ufoLibre = ufo.getKey();
                break;
            }
        }
        if (!ufoLibre.isEmpty() && tarjeta.pay(this.fee)){
            flota.replace(ufoLibre, tarjeta.number());
        }
    }

    String getUfoOf(String number) {
        for (Map.Entry<String ,String> ufo : flota.entrySet()){
            if (ufo.getValue().equalsIgnoreCase(number)){
                return ufo.getKey();
            }
        }
        return "null";
    }

    @Override
    public String toString() {
        return flota.keySet().stream().sorted().toList().toString();
    }

    Collection<String> cardNumbers() {
        return this.flota.values();
    }

    boolean containsCard(String cardNumber) {
        return this.flota.containsValue(cardNumber);
    }
}
