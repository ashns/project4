package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class storeOrderController {
    @FXML
    public Button returnBTN;
    @FXML
    public ListView ordersListView;
    @FXML
    public Button removeBTN;
    Controller main;
    @FXML
    FileChooser databaseFile = new FileChooser();

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
            if(currentOrders[i] != null)
                ordersListView.getItems().add("Order #" + currentOrders[i].getNumber() + "\n" + currentOrders[i].print());
        }
    }

    public void pressRemove(ActionEvent actionEvent) {
        try {
            int index = ordersListView.getSelectionModel().getSelectedIndex();
            main.currentStoreOrders.remove(index);
            ordersListView.getItems().remove(index);
        }
        catch (Exception e){
            Alert nullValues = new Alert(Alert.AlertType.ERROR, "Please select the order to be removed.");
            nullValues.setTitle("Error");
            nullValues.show();
        }
    }


    public void pressExport(ActionEvent actionEvent) {
        Alert cancel = new Alert(Alert.AlertType.ERROR, "Export cancelled.");
        if(main.currentStoreOrders.getNumOrders() == 0){
            Alert emptyDatabase = new Alert(Alert.AlertType.ERROR, "There are no store orders.");
            emptyDatabase.show();
            return;
        }
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        databaseFile.getExtensionFilters().add(extFilter);
        File file = databaseFile.showSaveDialog(null);
        if(file != null) {
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                try {
                    PrintWriter writer;
                    writer = new PrintWriter(file);
                    writer.println(main.currentStoreOrders.print());
                    writer.close();
                } catch (IOException ex) {

                }
                Alert success = new Alert(Alert.AlertType.CONFIRMATION, "Orders exported to selected file successfully");
                success.show();
            } catch (IOException ex) {
                Alert noExport = new Alert(Alert.AlertType.ERROR, "Unable to export orders.");
                noExport.show();
            }
        }
        else
            cancel.show();
    }
}
