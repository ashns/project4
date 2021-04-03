package sample;

public class MenuItem {

    int quantity;

    public MenuItem(int number){
        quantity = number;
    }

    public double itemPrice(){
        return 0;
    }

    public int getQuantity(){
        return quantity;
    }

    @Override
    public boolean equals(Object obj) {
        MenuItem compare = (MenuItem)obj;
        if(compare.getQuantity() == quantity)
            return true;
        else
            return false;
    }

    @Override
    public String toString() {
        return "(" + quantity + ") ";
    }
}
