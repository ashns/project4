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

    int size;
    ArrayList[] addOns = new ArrayList[0];

    public Coffee(double price, int size, int quantity, ArrayList addOns[]) {
        super(price, quantity);
        this.size = size;
        this.addOns=addOns;
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
        return "";
    }
}
