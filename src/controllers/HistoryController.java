package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

import models.AppData;
import models.BillingSystem;

public class HistoryController {

    @FXML
    private TextArea historyArea;

    @FXML
    public void initialize() {

        ArrayList<BillingSystem> bills =
                AppData.fileManager
                        .loadBills();

        StringBuilder builder =
                new StringBuilder();

        boolean found = false;

        for(BillingSystem bill : bills) {

            if(
                    bill.getConsumer()
                            .getConsumerId()

                            ==

                            AppData.currentConsumer
                                    .getConsumerId()
            ) {

                builder.append(
                        "Consumer ID : "
                ).append(
                        bill.getConsumer()
                                .getConsumerId()
                ).append("\n");

                builder.append(
                        "Total Bill : "
                ).append(
                        bill.getTotalAmount()
                ).append("\n");

                builder.append(
                        "-----------------------\n"
                );

                found = true;
            }
        }

        if(!found) {

            builder.append(
                    "No Bills Found"
            );
        }

        historyArea.setText(
                builder.toString()
        );
    }
}
