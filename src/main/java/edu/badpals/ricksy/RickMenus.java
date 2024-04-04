package edu.badpals.ricksy;

import java.util.ArrayList;
import java.util.List;

public class RickMenus implements GuestDispatcher{
    private double cost;
    private int stock;
    private List<CreditCard> cartas = new ArrayList<>();

    public RickMenus(int stock, double cost) {
        this.cost = cost;
        this.stock = stock;
    }

    @Override
    public void dispatch(CreditCard carta) {
        if (stock > 0 && !cartas.contains(carta.number()) && carta.pay(this.cost)){
            this.add(carta);
            --stock;
        }

    }

    void add(CreditCard cliente){
        this.cartas.add(cliente);
    }

    String obtenerNombresClientes(){
        return this.cartas.stream().map(CreditCard::getOwner).toList().toString();
    }

    @Override
    public String toString() {
        return this.cartas.stream().map(Object::toString).reduce("", (output, carta) -> output + carta + "\n");
    }
}
