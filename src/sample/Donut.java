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


    public Donut( int type, String kind){
        super(0, 1);
        flavor = kind;
        donutType = type;
    }

    void setDonutType(int newType){
        donutType = newType;
        switch (donutType){
            case YEAST_DONUT:
                setPrice(YEAST_PRICE);
                break;
            case CAKE_DONUT:
                setPrice(CAKE_PRICE);
                break;
            case DONUT_HOLE:
                setPrice(HOLE_PRICE);
                break;
            default:
                setPrice(0);
        }
    }

    void setFlavor(String newFlavor){
        flavor = newFlavor;
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
