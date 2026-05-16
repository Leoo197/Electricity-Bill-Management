package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class WelcomeController {

    public void handleNewUser(ActionEvent e) throws Exception {

        Parent root =
                FXMLLoader.load(
                        getClass().getResource(
                                "/views/register.fxml"
                        )
                );

        Stage stage =
                (Stage)((Node)e.getSource())
                        .getScene()
                        .getWindow();

        stage.setScene(
                new Scene(root, 900, 600)
        );
    }

    public void handleExistingUser(
            ActionEvent e)
            throws Exception {

        Parent root =
                FXMLLoader.load(
                        getClass().getResource(
                                "/views/login.fxml"
                        )
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