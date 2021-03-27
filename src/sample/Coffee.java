package sample;

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
    int quantity;
    String addOns[] = new String[5];

    public Coffee(double price, int size, int quantity, String addOns[]) {
        super(price);
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
