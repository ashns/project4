package sample;

public class MenuItem {
    double itemPrice;
    int quantity;

    public MenuItem(double price, int number){
        itemPrice = price;
        quantity = number;
    }

    public void setPrice(double newPrice){
        itemPrice = newPrice;
    }

    public double getPrice(){
        return itemPrice;
    }

    public void setQuantity(int newQuantity){
        quantity = newQuantity;
    }

    public double getQuantity(){
        return quantity;
    }

    @Override
    public boolean equals(Object obj) {
        MenuItem compare = (MenuItem)obj;
        if(compare.getPrice() == itemPrice)
            return true;
        else
            return false;
    }
}
