package sample;

import java.text.DecimalFormat;

public class Order implements Customizable{
    final int NOT_FOUND = -1;

    private MenuItem items[] = new MenuItem[4];
    private int itemCount = 0;
    DecimalFormat usd = new DecimalFormat("#.##");


    private void grow(){
        MenuItem newItem[] = new MenuItem[items.length+4];
        for(int i = 0; i < itemCount; i++){
            newItem[i] = items[i];
        }
        items = newItem;
    }

    private int search(Object obj){
        for(int i = 0; i < itemCount; i++){
            if(items[i].equals(obj)){
                return i;
            }
        }
        return NOT_FOUND;
    }

    @Override
    public boolean add(Object obj){
        if(itemCount <= items.length){
            grow();
        }
        if(obj instanceof Donut || obj instanceof Coffee){
            if(obj instanceof Donut) {
                items[itemCount] = (Donut) obj;
            }
            else if(obj instanceof Coffee) {
                items[itemCount] = (Coffee) obj;
            }
            itemCount++;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object obj){
        int index = search(obj);
        if(index != NOT_FOUND){
            for(int i = index; i < itemCount; i++){
                items[i] = items[i+1];
            }
            items[itemCount] = null;
            itemCount--;
            return true;
        }
        else
        return false;
    }

    public String print(){
        String order = "";
        for(int i = 0; i <= itemCount; i++){
            order += items[i].toString();
        }
        order += "\n---------------\nTotal Price: $" + usd.format(orderPrice()) + "\n";
        return order;
    }

    public MenuItem[] getItems(){
        return items;
    }

    public double orderPrice(){
        double price = 0;
        for(int i = 0; i < itemCount; i++){
            price += items[i].itemPrice();
        }
        return price;
    }
}
