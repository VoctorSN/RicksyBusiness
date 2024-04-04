package edu.badpals.ricksy;

import edu.badpals.ricksy.CreditCard;
import edu.badpals.ricksy.GuestDispatcher;

import java.util.ArrayList;
import java.util.List;

public class Receptivo {
    Receptivo(){}
    private List<GuestDispatcher> dispatchers = new ArrayList<>();
    void registra(GuestDispatcher dispatcher){
        dispatchers.add(dispatcher);
    }

    void dispatch(CreditCard card) {
        for (GuestDispatcher dispatcher: dispatchers){
            dispatcher.dispatch(card);
        }
    }
}
