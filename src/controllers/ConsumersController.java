package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

import models.AppData;
import models.Consumer;

public class ConsumersController {

    @FXML
    private TextArea consumerArea;

    @FXML
    public void initialize() {

        ArrayList<Consumer> consumers =
                AppData.fileManager
                        .loadConsumers();

        StringBuilder builder =
                new StringBuilder();

        if(consumers.isEmpty()) {

            builder.append(
                    "No Consumers Found"
            );
        }
        else {

            for(Consumer c : consumers) {

                builder.append("Consumer ID : ").append(c.getConsumerId()).append("\n");

                builder.append("Category : ").append(c.getCategory()).append("\n");

                builder.append("----------------------\n");
            }
        }

        consumerArea.setText(
                builder.toString()
        );
    }
}