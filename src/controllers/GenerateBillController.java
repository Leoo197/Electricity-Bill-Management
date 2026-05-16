package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import models.AppData;
import models.BillingSystem;

public class GenerateBillController {

    @FXML
    private TextField unitsField;

    @FXML
    private TextArea resultArea;

    public void generate() {

        double units =
                Double.parseDouble(
                        unitsField.getText()
                );

        BillingSystem billingSystem =
                new BillingSystem(
                        AppData.currentConsumer,
                        AppData.tariff
                );

        billingSystem.calculateBill(
                units
        );

        AppData.fileManager
                .saveBill(
                        billingSystem
                );

        ByteArrayOutputStream baos =
                new ByteArrayOutputStream();

        PrintStream ps =
                new PrintStream(baos);

        PrintStream old =
                System.out;

        System.setOut(ps);

        billingSystem.generateBill();

        System.out.flush();

        System.setOut(old);

        resultArea.setText(
                baos.toString()
        );
    }
}
