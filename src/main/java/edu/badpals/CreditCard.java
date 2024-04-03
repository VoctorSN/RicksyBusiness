package edu.badpals;

public class CreditCard {
    private final String number;
    private double credit;
    private final String owner;
    private final String SYMBOL = "1";

    CreditCard(String owner, String number) {
        this.number = number;
        this.owner = owner;
        this.credit = 3000;
    }

    boolean pay(double pago){
        if (this.credit() >= pago){
            this.credit = this.credit() - pago;
            return true;
        }
        return false;
    }

    String number() {
        return number;
    }

    double credit() {
        return credit;
    }

    String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "owner: " + this.getOwner() + "\n" +
                "number: " + this.number() + "\n" +
                "credit: " + this.credit() + "EZI";
    }
}
