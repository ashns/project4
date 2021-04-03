package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import java.text.DecimalFormat;

public class orderController {
    @FXML
    public Button returnBTN;
    @FXML
    public Button removeBTN;
    @FXML
    public Button placeBTN;
    @FXML
    public ListView orderListView;
    @FXML
    public Label priceLabel;


    Controller main;
    private MenuItem current[];
    DecimalFormat usd = new DecimalFormat("#.##");

    public void removeItem(ActionEvent event){
        try {
            int index = orderListView.getSelectionModel().getSelectedIndex();
            main.currentOrder.remove(index);
            orderListView.getItems().remove(index);
            updatePrice();
        }
        catch (Exception e){
            Alert nullValues = new Alert(Alert.AlertType.ERROR, "Please select the item to be removed.");
            nullValues.setTitle("Error");
            nullValues.show();
        }
    }

    public void placeOrder(ActionEvent event){
        if(main.currentOrder.getItemCount() > 0){
        main.currentStoreOrders.add(main.currentOrder);
        main.currentOrder.updateNumber();
        main.currentOrder = new Order();
        closeWindow(event);}
        else{
            Alert nullValues = new Alert(Alert.AlertType.ERROR, "Cannot place an empty order");
            nullValues.setTitle("Error");
            nullValues.show();
        }
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
        current = main.currentOrder.getItems();
        for(int i = 0; i < current.length; i++){
            if(current[i] != null)
                orderListView.getItems().add(current[i]);
        }
        updatePrice();
    }

    public void updatePrice(){
        priceLabel.setText("Total: $" + usd.format(main.currentOrder.orderPrice()));
    }

}
