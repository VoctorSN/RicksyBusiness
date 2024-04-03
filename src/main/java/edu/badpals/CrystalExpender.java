package edu.badpals;

public class CrystalExpender implements GuestDispatcher{
    private int stock;
    private double itemCost;
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
        if (stock > 0 && carta.pay(itemCost)){
            stock -=1;
        }
    }

    public int stock() {
        return stock;
    }
}
