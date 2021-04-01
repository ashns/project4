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

    public void closeWindow(ActionEvent event){
        Stage closing = (Stage)returnBTN.getScene().getWindow();
        closing.close();
    }

    public void pressOrder(ActionEvent actionEvent) {
    }
}
