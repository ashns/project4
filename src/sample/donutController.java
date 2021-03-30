package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;

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
    Controller main = new Controller();
    final int YEAST_DONUT = 1;
    final int CAKE_DONUT = 2;
    final int DONUT_HOLE = 3;


    public void setMainController(Controller parent){
        main = parent;
    }

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


}
