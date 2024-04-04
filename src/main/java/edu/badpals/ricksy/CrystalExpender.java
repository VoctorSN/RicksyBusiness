package edu.badpals.ricksy;

import java.util.ArrayList;
import java.util.List;

public class CrystalExpender implements GuestDispatcher {
    private int stock;
    private double itemCost;
    private List<String> clientes = new ArrayList<>();
    CrystalExpender(int stock, double itemCost){
        this.itemCost = itemCost;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "stock: " + stock + "\n" +
                "cost: " + itemCost;
    }

    @Override
    public void dispatch(CreditCard carta) {
        String numeroCarta = carta.number();
        if (stock > 0 && !clientes.contains(numeroCarta) && carta.pay(itemCost)){
            --stock;
            this.add(numeroCarta);
        }
    }

    private void add(String numero){
        clientes.add(numero);
    }

    int stock() {
        return stock;
    }
}
