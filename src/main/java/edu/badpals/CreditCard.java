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
        if (this.getCredit() < pago){
            this.credit = this.getCredit() - pago;
            return true;
        }
        return false;
    }

    String getNumber() {
        return number;
    }

    double getCredit() {
        return credit;
    }

    String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "owner: " + this.getOwner() + "\n" +
                "number: " + this.getNumber() + "\n" +
                "credit: " + this.getCredit() + "EZI";
    }
}
