package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

public class orderController {
    @FXML
    public Button returnBTN;
    @FXML
    public Button removeBTN;
    @FXML
    public Button placeBTN;
    @FXML
    public ListView orderListView;

    Controller main;

    public void removeItem(ActionEvent event){
        int index = orderListView.getSelectionModel().getSelectedIndex();
        System.out.println(index);
    }

    public void placeOrder(ActionEvent event){

        main.currentStoreOrders.add(main.currentOrder);
        main.currentOrder = new Order();
        main.currentOrder.setNumber();
        main.currentStoreOrders.add(main.currentOrder);
        closeWindow(event);
    }

    public void closeWindow(ActionEvent event){
        Stage closing = (Stage)returnBTN.getScene().getWindow();
        closing.close();
    }

    public void setMainController(Controller controller){
        main = controller;
        displayOrder();
    }

    public void displayOrder(){
        orderListView.getItems().removeAll();
        MenuItem current[] = main.currentOrder.getItems();
        for(int i = 0; i < current.length; i++){
            if(current[i] != null)
                orderListView.getItems().add(current[i]);
        }
    }

}
