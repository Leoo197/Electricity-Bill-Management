package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Consumer;
import models.AppData;
import java.util.Random;
import javafx.scene.control.ComboBox;

import java.io.IOException;

public class RegisterController {

    @FXML
    private TextField nameField;

    @FXML
    private TextField idField;

    @FXML
    private TextField addressField;

    @FXML
    private ComboBox<String> categoryBox;

    @FXML
    private TextField phaseField;

    @FXML
    private TextField loadField;

    public void createConsumer( ActionEvent e) throws Exception {

        String name =
                nameField.getText();

        int consumerId =
                generateConsumerId();

        String address =
                addressField.getText();

        String category =
                categoryBox.getValue();

        double phase =
                Double.parseDouble(
                        phaseField.getText()
                );

        double load =
                Double.parseDouble(
                        loadField.getText()
                );

        Consumer consumer =
                new Consumer(
                        name,
                        consumerId,
                        address,
                        category,
                        phase,
                        load
                );

        AppData.currentConsumer = consumer;

        AppData.fileManager
                .saveConsumer(consumer);

        FXMLLoader loader =
                new FXMLLoader(
                        getClass().getResource(
                                "/views/consumer.fxml"
                        )
                );

        Parent root = loader.load();

        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();

        stage.setScene(
                new Scene(root, 900, 600)
        );

    }
    public int generateConsumerId() {

        Random random =
                new Random();

        int id;

        boolean exists;

        do {

            id =
                    100000
                            + random.nextInt(900000);

            exists = false;

            // Prevent admin ID

            if(id == 9999) {

                exists = true;
            }

            // Check existing consumers

            for(Consumer c :
                    AppData.fileManager
                            .loadConsumers()) {

                if(c.getConsumerId()
                        == id) {

                    exists = true;

                    break;
                }
            }

        } while(exists);

        return id;
    }
    @FXML
    public void initialize() {

        categoryBox.getItems().addAll(

                "domestic",
                "commercial",
                "agricultural"
        );
    }
}