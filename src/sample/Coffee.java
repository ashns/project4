package sample;

import java.util.ArrayList;

public class Coffee extends MenuItem implements Customizable{

    final int SIZE_SHORT = 1;
    final int SIZE_TALL = 2;
    final int SIZE_GRANDE = 3;
    final int SIZE_VENTI = 4;
    final double SHORT_PRICE = 1.99;
    final double TALL_PRICE = 2.49;
    final double GRANDE_PRICE = 2.99;
    final double VENTI_PRICE = 3.49;
    final double ADDON_COST = .20;
    boolean hasAddOns = false;

    int size;
    coffeeAddOns[] addOns = new coffeeAddOns[4];

    public Coffee(double price, int size, int quantity, coffeeAddOns addOns[]) {
        super(price, quantity);
        this.size = size;
        this.addOns = addOns;
    }

    @Override
    public boolean add(Object obj) {
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        return false;
    }

    @Override
    public String toString(){
        String message = "(" + quantity + ") " + " " ;
        switch (size){
            case SIZE_SHORT:
                message += "short coffee";
                break;
            case SIZE_TALL:
                message += "tall coffee";
                break;
            case SIZE_GRANDE:
                message += "grande coffee";
                break;
                case SIZE_VENTI:
                message += "venti coffee";
                break;
            default:
                message += "bagel";
        }
        if(quantity > 1 || quantity <= 0) message += "s";
        for(int i = 0; i < 5; i++) {
            String tempMessage = "";
            if (addOns[i].getQuantity() == 0) {
                continue;
            } else {
                if (hasAddOns == false) {
                    tempMessage += " with " + addOns[i].getQuantity() + " " + addOns[i].getType();
                } else {
                    tempMessage += ", " + addOns[i].getQuantity() + " " + addOns[i].getType();
                }
            }
           message += tempMessage;
        }
        return message + "\n";
    }

}

