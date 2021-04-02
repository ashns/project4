package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class storeOrderController {
    @FXML
    public Button returnBTN;
    @FXML
    public ListView ordersListView;
    @FXML
    public Button removeBTN;
    Controller main;

    public void closeWindow(ActionEvent event){
        Stage closing = (Stage)returnBTN.getScene().getWindow();
        closing.close();
    }
    public void setMainController(Controller controller){
        main = controller;
        displayOrder();
    }

    public void displayOrder(){
        ordersListView.getItems().removeAll();
        Order currentOrders[] = main.currentStoreOrders.getOrders();
        for(int i = 0; i < currentOrders.length; i++){
            if(currentOrders[i] != null && currentOrders[i].getNumber() != null)
                ordersListView.getItems().add("Order #" + currentOrders[i].getNumber());
        }
    }

    public void pressRemove(ActionEvent actionEvent) {
       // main.currentStoreOrders.searchByNum()
    }


}
