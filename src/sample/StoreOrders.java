package sample;

public class StoreOrders implements Customizable{

    private Order orders[] = new Order[4];
    private int orderCount = 0;
    final int NOT_FOUND = -1;

    private void grow(){
        Order newOrders[] = new Order[orders.length+4];
        for(int i = 0; i < orderCount; i++){
            newOrders[i] = orders[i];
        }
        orders = newOrders;
    }

    private int search(Object obj){
        for(int i = 0; i < orderCount; i++){
            if(orders[i].equals(obj)){
                return i;
            }
        }
        return NOT_FOUND;
    }

    private int searchByNum(int orderNumber){
        for(int i = 0; i < orderCount; i++){
            if(orders[i].getNumber().equals(orderNumber)){
                return i;
            }
        }
        return NOT_FOUND;
    }

    @Override
    public boolean add(Object obj) {
        if(orders.length == orderCount+1){
            grow();
        }
        if(obj instanceof Order) {
            orders[orderCount] = (Order) obj;
            orderCount++;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object obj) {
        int index = search(obj);
        if(index != NOT_FOUND){
            for(int i = index; i < orderCount; i++){
                orders[i] = orders[i+1];
            }
            orders[orderCount] = null;
            orderCount--;
            return true;
        }
        else
            return false;
    }

    public boolean remove(int index){
        if(index < orderCount){
            for(int i = index; i < orderCount; i++){
                orders[i] = orders[i+1];
            }
            orders[orderCount] = null;
            orderCount--;
            return true;
        }
        else
            return false;
    }

    public String print(){
        String order = "";
        for(int i = 0; i < orderCount; i++){
            order += orders[i].toString();
        }
        return order;
    }

    public Order[] getOrders(){
        return orders;
    }

    public int getNumOrders(){
        return orderCount;
    }
}
