package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import models.AppData;

public class ConsumerController {
    @FXML
    private Label consumerIdLabel;
    @FXML
    public void initialize() {

        consumerIdLabel.setText("Consumer ID : " +

                        AppData.currentConsumer
                                .getConsumerId()
        );
    }
    public void generateBill()
            throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/generateBill.fxml"));

        Parent root = loader.load();

        Stage stage = new Stage();

        stage.setScene(
                new Scene(root, 600, 400)
        );

        stage.show();
    }
    public void openGenerateBill()
            throws Exception {

        FXMLLoader loader =
                new FXMLLoader(
                        getClass().getResource(
                                "/views/generateBill.fxml"
                        )
                );

        Parent root = loader.load();

        Stage stage = new Stage();

        stage.setTitle(
                "Generate Bill"
        );

        stage.setScene(
                new Scene(root, 500, 400)
        );

        stage.show();
    }

    public void loadBills()
            throws Exception {

        FXMLLoader loader =
                new FXMLLoader(
                        getClass().getResource(
                                "/views/history.fxml"
                        )
                );

        Parent root = loader.load();

        Stage stage = new Stage();

        stage.setTitle(
                "Bill History"
        );

        stage.setScene(
                new Scene(root, 800, 600)
        );

        stage.show();
    }

    public void logout(
            ActionEvent e)
            throws Exception {

        Parent root =
                FXMLLoader.load(
                        getClass().getResource("/views/welcome.fxml")
                );

        Stage stage =
                (Stage)((Node)e.getSource())
                        .getScene()
                        .getWindow();

        stage.setScene(
                new Scene(root, 900, 600)
        );

    }
}