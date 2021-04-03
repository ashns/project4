package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;

public class Controller {

    @FXML
    Button donutBTN = new Button();
    @FXML
    Button coffeeBTN = new Button();
    @FXML
    ImageView donutImageV = new ImageView();
    @FXML
    ImageView coffeeImageV = new ImageView();
    @FXML
    Button orderBTN = new Button();
    @FXML
    Button storeOrderBTN = new Button();
    @FXML
    Label testl = new Label();

    public StoreOrders currentStoreOrders = new StoreOrders();
    public Order currentOrder = new Order();
    public int orderNum = 0;

    String test = "hello!";

    public void pressDonut(ActionEvent event) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("donut.fxml"));
            Parent root1 = fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Order Donut");
            stage.setScene(new Scene(root1));
            donutController sub = fxmlLoader.getController();
            sub.setMainController(this);
            sub.getInformation(currentOrder);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pressCoffee(ActionEvent event) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("coffee.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Order Coffee");
            stage.setScene(new Scene(root1));
            coffeeController sub = fxmlLoader.getController();
            sub.setMainController(this);
            sub.getInformation(currentOrder);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void pressOrder(ActionEvent event) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("order.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            orderController sub = fxmlLoader.getController();
            sub.setMainController(this);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pressStoreOrder(ActionEvent event) throws Exception {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("storeOrder.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            storeOrderController sub = fxmlLoader.getController();
            sub.setMainController(this);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
            //
        }


    }
}
