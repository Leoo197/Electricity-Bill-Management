package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

import models.AppData;
import models.BillingSystem;

public class BillsController {

    @FXML
    private TextArea billArea;

    @FXML
    public void initialize() {

        ArrayList<BillingSystem> bills =
                AppData.fileManager
                        .loadBills();

        StringBuilder builder =
                new StringBuilder();

        if(bills.isEmpty()) {

            builder.append(
                    "No Bills Found"
            );
        }
        else {

            for(BillingSystem bill : bills) {

                builder.append("Consumer ID : ").append(bill.getConsumer().getConsumerId()).append("\n");
                builder.append("Category : ").append(bill.getConsumer().getCategory()).append("\n");

                builder.append("Total Amount : ").append(bill.getTotalAmount()).append("\n");
                builder.append("----------------------\n");
            }
        }

        billArea.setText(
                builder.toString()
        );
    }
}