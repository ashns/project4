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

    public Donut(){
        super( 1);
        flavor = "";
        donutType = 1;
    }

    public Donut(int number, String taste, int type){
        super(number);
        flavor = taste;
        donutType = type;
    }

    public void setDonutType(int newType){
        donutType = newType;
        itemPrice();
    }

    @Override
    public double itemPrice() {
        double price = 0;
        switch(donutType){
            case YEAST_DONUT:
                price = YEAST_PRICE;
                break;
            case CAKE_DONUT:
                price = CAKE_PRICE;
                break;
            case DONUT_HOLE:
                price =  HOLE_PRICE;
                break;
            default: price = 0;
        }
        return price * quantity;
    }

    public void setFlavor(String newFlavor){
        flavor = newFlavor;
    }

    public int getDonutType(){
        return donutType;
    }

    public String getFlavor(){
        return flavor;
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

    @Override
    public boolean equals(Object obj){
        if(super.equals(obj)) {
            Donut compare = (Donut) obj;
            if (compare.getDonutType() == donutType && compare.getFlavor().equals(flavor))
                return true;
            else return false;
        }
        else
            return false;
    }


}
