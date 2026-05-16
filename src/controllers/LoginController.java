package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javafx.fxml.FXML;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import models.AppData;
import models.Consumer;

public class LoginController {

    @FXML
    private TextField consumerIdField;

    @FXML
    private TextField adminUserField;

    @FXML
    private PasswordField adminPasswordField;

    public void login(
            ActionEvent e)
            throws Exception {

        Parent root = null;

        // ADMIN LOGIN

        String username =
                adminUserField.getText();

        String password =
                adminPasswordField.getText();

        if(username.equals("admin")
                &&
                password.equals("admin123")) {

            root = FXMLLoader.load(
                    getClass().getResource(
                            "/views/admin.fxml"
                    )
            );
        }

        // CONSUMER LOGIN

        else {

            if(consumerIdField
                    .getText()
                    .isEmpty()) {

                System.out.println(
                        "Enter Consumer ID"
                );

                return;
            }

            int enteredId =
                    Integer.parseInt(
                            consumerIdField
                                    .getText()
                    );

            boolean found = false;

            for(Consumer c :
                    AppData.fileManager
                            .loadConsumers()) {

                if(c.getConsumerId()
                        == enteredId) {

                    AppData.currentConsumer = c;

                    found = true;

                    break;
                }
            }

            if(!found) {

                System.out.println(
                        "Consumer Not Found"
                );

                return;
            }

            root = FXMLLoader.load(
                    getClass().getResource(
                            "/views/consumer.fxml"
                    )
            );
        }

        Stage stage =
                (Stage)((Node)e.getSource())
                        .getScene()
                        .getWindow();

        stage.setScene(
                new Scene(root, 900, 600)
        );
    }
}