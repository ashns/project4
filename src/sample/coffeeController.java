package sample;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class coffeeController {
    @FXML
    public Button returnBTN;
    @FXML
    public CheckBox creamCB;
    @FXML
    public ComboBox sizeCB;
    @FXML
    public CheckBox syrupCB;
    @FXML
    public CheckBox milkCB;
    @FXML
    public CheckBox caramelCB;
    @FXML
    public CheckBox whippedCB;
    @FXML
    public ComboBox quantityCB;
    @FXML
    public Button orderBTN;
    @FXML
    public ListView coffeeLW;
    @FXML
    public Button removeBTN;
    int size;
    int quantity;
    String[] addOns = new String[4];
    Controller main;
    public Order currentOrder = new Order();
    private MenuItem current[];

    public void closeWindow(ActionEvent event){
        Stage closing = (Stage)returnBTN.getScene().getWindow();
        closing.close();
    }

    public void pressOrder(ActionEvent actionEvent) {
        try {
            if (sizeCB.getSelectionModel().getSelectedItem().equals("Short")) {
                size = 1;
            } else if (sizeCB.getSelectionModel().getSelectedItem().equals("Tall")) {
                size = 2;
            } else if (sizeCB.getSelectionModel().getSelectedItem().equals("Grande")) {
                size = 3;
            } else {
                size = 4;
            }

            quantity = Integer.parseInt((String) quantityCB.getSelectionModel().getSelectedItem());
            Coffee newCoffee = new Coffee(size, quantity);
            if (creamCB.isSelected()) {
                newCoffee.add("cream");
            }
            if (syrupCB.isSelected()) {
                newCoffee.add("syrup");
            }
            if (milkCB.isSelected()) {
                newCoffee.add("milk");
            }
            if (caramelCB.isSelected()) {
                newCoffee.add("caramel");
            }
            if (whippedCB.isSelected()) {
                newCoffee.add("whipped creme");
            }

            main.currentOrder.add(newCoffee);
            displayOrder();

        }catch(Exception e){
            Alert nullValues = new Alert(Alert.AlertType.ERROR, "Please enter valid coffee quantity and size");
            nullValues.setTitle("Error");
            nullValues.show();
        }
    }
    public void getInformation(Order orders){
        this.currentOrder = orders;
    }
    public void setMainController(Controller controller) {
        main = controller;
    }

    public void removeItem(ActionEvent event){
        int index = coffeeLW.getSelectionModel().getSelectedIndex();
        main.currentOrder.remove(index);
        coffeeLW.getItems().remove(index);
    }

    public void displayOrder(){
        current = main.currentOrder.getItems();
        for(int i = 0; i < current.length; i++){
            if(current[i] != null)
                coffeeLW.getItems().add(current[i]);
        }
    }
}
