package sample;

public class MenuItem {
    double itemPrice;

    public MenuItem(){
        itemPrice = 0;
    }

    void setPrice(double newPrice){
        itemPrice = newPrice;
    }

    double getPrice(){
        return itemPrice;
    }
}
