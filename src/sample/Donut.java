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


    public Donut(double price, int type, int count, String kind){
        super(price, count);
        flavor = kind;
        donutType = type;
    }

    @Override
    public String toString(){
        String message = "(" + quantity + ") " + flavor + " " ;
        switch (donutType){
            case YEAST_DONUT:
                message += "yeast donut";
                break;
            case CAKE_DONUT:
                message += "cake donut";
                break;
            case DONUT_HOLE:
                message += "donut hole";
                break;
            default:
                message += "bagel";
        }
        if(quantity > 1 || quantity <= 0) message += "s";
        return message + "\n";
    }
}
