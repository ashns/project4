package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;

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
    int size;
    int quantity;
    String[] addOns = new String[4];

    public void closeWindow(ActionEvent event){
        Stage closing = (Stage)returnBTN.getScene().getWindow();
        closing.close();
    }

    public void pressOrder(ActionEvent actionEvent) {
        if(sizeCB.getSelectionModel().getSelectedItem().equals("Short")){
            size = 1;
        }
        else if(sizeCB.getSelectionModel().getSelectedItem().equals("Tall")){
            size = 2;
        }
        else if(sizeCB.getSelectionModel().getSelectedItem().equals("Grande")){
            size = 3;
        }
        else{
            size = 4;
        }

        quantity = (int) quantityCB.getSelectionModel().getSelectedItem();
        Coffee newCoffee = new Coffee(size, quantity);
        if(creamCB.isSelected()){
            newCoffee.add("cream");
        }
        else if(syrupCB.isSelected()){
            newCoffee.add("syrup");
        }
        else if(milkCB.isSelected()){
            newCoffee.add("milk");
        }
        else if(caramelCB.isSelected()){
            newCoffee.add("caramel");
        }
        else{
            newCoffee.add("whipped creme");
        }
    }
}
