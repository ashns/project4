package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

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

    Controller main = new Controller();
    final int YEAST_DONUT = 1;
    final int CAKE_DONUT = 2;
    final int DONUT_HOLE = 3;
    Order[] newOrder = new Order[4];

    public int getType(){
        String type = (String)donutTypeCB.getSelectionModel().getSelectedItem();
        if(type=="yeast"){
            return YEAST_DONUT;
        }
        else if(type=="cake"){
            return CAKE_DONUT;
        }
        else{
            return DONUT_HOLE;
        }
    }

    public void pressOrderBTN(ActionEvent actionEvent) {
        String flavor = (String)donutFlavorCB.getSelectionModel().getSelectedItem();
        int type = getType();
        int quantity = (int)quantitySlider.getValue();
        Donut newDonut = new Donut(quantity, flavor, type);

    }
    
    public void getInformation(Order[] orders, String test){
        this.newOrder = orders;
        System.out.println(test);
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
    }

    public void setMainController(Controller controller) {
    }

    public void closeWindow(ActionEvent event){
        Stage closing = (Stage)returnBTN.getScene().getWindow();
        closing.close();
    }

}
