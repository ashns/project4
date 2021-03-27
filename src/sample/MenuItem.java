package sample;

public class MenuItem {
    double itemPrice;

    public MenuItem(double price){
        itemPrice = price;
    }

    void setPrice(double newPrice){
        itemPrice = newPrice;
    }

    double getPrice(){
        return itemPrice;
    }
}
