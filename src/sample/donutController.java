package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.stage.Stage;


import java.text.DecimalFormat;

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
    @FXML
    public Button removeBTN;
    @FXML
    public Label priceLabel;

    Controller main;
    final int YEAST_DONUT = 1;
    final int CAKE_DONUT = 2;
    final int DONUT_HOLE = 3;
    private Order newOrder = new Order();
    private MenuItem current[];
    DecimalFormat usd = new DecimalFormat("#.##");

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
            String flavor = donutFlavorCB.getSelectionModel().getSelectedItem().toString();
            int type = getType();
            int quantity = (int) quantitySlider.getValue();
            Donut newDonut = new Donut(quantity, flavor, type);
            main.currentOrder.add(newDonut);
            currentListView.getItems().add(newDonut);
            updatePrice();

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
            donutFlavorCB.getItems().add("Strawberry");
            donutFlavorCB.getItems().add("Vanilla");
            donutFlavorCB.getItems().add("Chocolate");
            donutFlavorCB.getItems().remove("Carrot");
            donutFlavorCB.getItems().remove("Smores");
            donutFlavorCB.getItems().remove("Mint");
            donutFlavorCB.getItems().remove("Blueberry");
            donutFlavorCB.getItems().remove("Pecan");
            donutFlavorCB.getItems().remove("Cherry");

        }
        else if(donutTypeCB.getSelectionModel().getSelectedItem().equals("cake donut")){
            donutFlavorCB.getItems().add("Carrot");
            donutFlavorCB.getItems().add("Smores");
            donutFlavorCB.getItems().add("Mint");
            donutFlavorCB.getItems().remove("Vanilla");
            donutFlavorCB.getItems().remove("Chocolate");
            donutFlavorCB.getItems().remove("Strawberry");
            donutFlavorCB.getItems().remove("Blueberry");
            donutFlavorCB.getItems().remove("Pecan");
            donutFlavorCB.getItems().remove("Cherry");

        }
        else{
            donutFlavorCB.getItems().add("Blueberry");
            donutFlavorCB.getItems().add("Pecan");
            donutFlavorCB.getItems().add("Cherry");
            donutFlavorCB.getItems().remove("Vanilla");
            donutFlavorCB.getItems().remove("Chocolate");
            donutFlavorCB.getItems().remove("Strawberry");
            donutFlavorCB.getItems().remove("Carrot");
            donutFlavorCB.getItems().remove("Smores");
            donutFlavorCB.getItems().remove("Mint");
        }
        donutFlavorCB.setValue(null);

    }

    public void setMainController(Controller controller) {
        main = controller;
        newOrder = main.currentOrder;
        displayOrder();
    }

    public void closeWindow(ActionEvent event){
        Stage closing = (Stage)returnBTN.getScene().getWindow();
        closing.close();
    }

    public void removeItem(ActionEvent event){
        int index = currentListView.getSelectionModel().getSelectedIndex();
        main.currentOrder.remove(index);
        currentListView.getItems().remove(index);
        updatePrice();
    }

    public void displayOrder(){
        current = main.currentOrder.getItems();
        for(int i = 0; i < current.length; i++){
            if(current[i] != null)
                currentListView.getItems().add(current[i]);
        }
        updatePrice();
    }

    public void updatePrice(){
        priceLabel.setText("Total: $" + usd.format(main.currentOrder.orderPrice()));
    }
}
