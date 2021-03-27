package sample;

public class Donut extends MenuItem{

    final int YEAST_DONUT = 1;
    final int CAKE_DONUT = 2;
    final int DONUT_HOLE = 3;
    final double YEAST_PRICE = 1.39;
    final double CAKE_PRICE = 1.59;
    final double HOLE_PRICE = 0.33;

    String flavor;
    int donutType;
    int quantity;

    public Donut(double price, int type, int count, String kind){
        super(price);
        flavor = kind;
        donutType = type;
        quantity = count;
    }

    @Override
    public String toString(){
        return "";
    }
}
