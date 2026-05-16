package controllers;
import models.AppData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdminController {
    @FXML
    private TextField billField;
    @FXML
    private TextField taxField;
    @FXML
    private TextField billPerUnitField;
    @FXML
    private TextField domesticField;
    @FXML
    private TextField commercialField;
    @FXML
    private TextField agriculturalField;
    public void saveTariff() {
        double billPerUnit = Double.parseDouble(billPerUnitField.getText());
        double domestic = Double.parseDouble(domesticField.getText());
        double commercial = Double.parseDouble(commercialField.getText());
        double agricultural = Double.parseDouble(agriculturalField.getText());
        double tax = Double.parseDouble(taxField.getText());
        AppData.tariff.setDomesticTariff(domestic);
        AppData.tariff.setCommercialTariff(commercial);
        AppData.tariff.setAgriculturalTariff(agricultural);
        AppData.tariff.setBillPerUnit(billPerUnit);
        AppData.tariff.setTaxPercentage(tax);
        System.out.println("Tariff Updated Successfully");
    }

    public void viewConsumers() throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/consumers.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("All Consumers");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
    }

    public void viewBills() throws Exception {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/views/bills.fxml"));
        Parent root = loader.load();
        Stage stage = new Stage();
        stage.setTitle("All Bills");
        stage.setScene(new Scene(root, 800, 600));
        stage.show();
    }

    public void logout(ActionEvent e) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/views/welcome.fxml"));
        Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root, 900, 600));
    }
}