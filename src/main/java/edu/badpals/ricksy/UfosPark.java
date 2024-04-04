package edu.badpals.ricksy;

import java.util.*;
import java.util.stream.Collectors;

public class UfosPark implements GuestDispatcher {
    private static final String LIBRE = "libre";
    private final Map<String, String> flota = new HashMap<>();
    private final double fee = 500;

    UfosPark() {
    }

    void add(String ufo) {
        flota.putIfAbsent(ufo, LIBRE);
    }

    @Override
    public void dispatch(CreditCard tarjeta) {
        if (this.getUfoOf(tarjeta.number()) != null) {
            return;
        }
        Map<String, String> ufosLibres = this.flota.entrySet()
                                                    .stream()
                                                    .filter((Map.Entry<String, String> entry) -> entry.getValue().equals(LIBRE))
                                                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        if (!ufosLibres.isEmpty() && tarjeta.pay(this.fee)) {
            String ufoLibre = (String)ufosLibres.keySet()
                    .toArray()[new Random().nextInt(0, ufosLibres.size())];
            flota.replace(ufoLibre, tarjeta.number());
        }
    }

    String getUfoOf(String number) {
        // Coge el hashmap y coge los entrys,
        // lo combierte a stream,
        // filtra por los que tienen de valor el numero que busco,
        // coge solo la key, coge el primero,
        // y si existe pasa esta key sino devuelve null
        return this.flota.entrySet()
                .stream()
                .filter(entry -> entry.getValue().equals(number))
                .map(Map.Entry::getKey)
                .findFirst().orElse(null);

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
