package sample;

public class MenuItem {
    double itemPrice;
    int quantity;

    public MenuItem(double price, int number){
        itemPrice = price;
        quantity = number;
    }

    void setPrice(double newPrice){
        itemPrice = newPrice;
    }

    double getPrice(){
        return itemPrice;
    }
}
