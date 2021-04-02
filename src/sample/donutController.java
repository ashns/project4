package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.lang.reflect.InvocationTargetException;

public class donutController {
    @FXML
    public ComboBox donutTypeCB;
    @FXML
    public ComboBox donutFlavorCB;
    @FXML
    public Button orderBTN;
    @FXML
    public Slider quantitySlider;
    @FXML
    public ListView currentListView;
    @FXML
    public Button returnBTN;

    Controller main;
    final int YEAST_DONUT = 1;
    final int CAKE_DONUT = 2;
    final int DONUT_HOLE = 3;
    private Order newOrder = new Order();


    public int getType(){
        String type = donutTypeCB.getSelectionModel().getSelectedItem().toString();
        if(type.equals("yeast donut")){
            return YEAST_DONUT;
        }
        else if(type.equals("cake donut")){
            return CAKE_DONUT;
        }
        else{
            return DONUT_HOLE;
        }
    }

    public void pressOrderBTN(ActionEvent actionEvent) {
        try {
            String flavor = (String) donutFlavorCB.getSelectionModel().getSelectedItem();

            int type = getType();
            int quantity = (int) quantitySlider.getValue();
            Donut newDonut = new Donut(quantity, flavor, type);
            main.currentOrder.add(newDonut);
            currentListView.getItems().add(newDonut.toString());
        }catch(Exception e) {
            Alert nullValues = new Alert(Alert.AlertType.ERROR, "Please enter valid donut type or flavor.");
            nullValues.setTitle("Error");
            nullValues.show();
        }
    }
    
    public void getInformation(Order orders){
        this.newOrder = orders;

    }

    public void pressDonutType(ActionEvent actionEvent) {
        if(donutTypeCB.getSelectionModel().getSelectedItem().equals("yeast donut")){
            donutFlavorCB.getItems().add("strawberry");
            donutFlavorCB.getItems().add("vanilla");
            donutFlavorCB.getItems().add("chocolate");
            donutFlavorCB.getItems().remove("carrot");
            donutFlavorCB.getItems().remove("smores");
            donutFlavorCB.getItems().remove("mint");
            donutFlavorCB.getItems().remove("blueberry");
            donutFlavorCB.getItems().remove("pecan");
            donutFlavorCB.getItems().remove("cherry");

        }
        else if(donutTypeCB.getSelectionModel().getSelectedItem().equals("cake donut")){
            donutFlavorCB.getItems().add("carrot");
            donutFlavorCB.getItems().add("smores");
            donutFlavorCB.getItems().add("mint");
            donutFlavorCB.getItems().remove("vanilla");
            donutFlavorCB.getItems().remove("chocolate");
            donutFlavorCB.getItems().remove("strawberry");
            donutFlavorCB.getItems().remove("blueberry");
            donutFlavorCB.getItems().remove("pecan");
            donutFlavorCB.getItems().remove("cherry");

        }
        else{
            donutFlavorCB.getItems().add("blueberry");
            donutFlavorCB.getItems().add("pecan");
            donutFlavorCB.getItems().add("cherry");
            donutFlavorCB.getItems().remove("vanilla");
            donutFlavorCB.getItems().remove("chocolate");
            donutFlavorCB.getItems().remove("strawberry");
            donutFlavorCB.getItems().remove("carrot");
            donutFlavorCB.getItems().remove("smores");
            donutFlavorCB.getItems().remove("mint");
        }
        donutFlavorCB.setValue(null);

    }

    public void setMainController(Controller controller) {
        main = controller;
    }

    public void closeWindow(ActionEvent event){
        Stage closing = (Stage)returnBTN.getScene().getWindow();
        closing.close();
    }

}
