/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c482;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Raxa
 */
public class ModifyPartController implements Initializable {

    @FXML
    TextField idText;

    @FXML
    TextField name;

    @FXML
    TextField inventory;

    @FXML
    TextField cost;

    @FXML
    TextField maxInv;

    @FXML
    TextField minInv;

    @FXML
    Label sourceLabel;
    
    @FXML
    TextField sourceText;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    
    
    
    public void acceptIncoming(InHousePart selectedPart) {
        //set our values from dashboard
        idText.setText(String.valueOf(selectedPart.getId()));
        name.setText(selectedPart.getName());
        inventory.setText(String.valueOf(selectedPart.getStock()));
        cost.setText(String.valueOf(selectedPart.getPrice()));
        maxInv.setText(String.valueOf(selectedPart.getMax()));
        minInv.setText(String.valueOf(selectedPart.getMin()));
        sourceLabel.setText("Machine ID");
        sourceText.setText(String.valueOf(selectedPart.getMachineId()));
    }
    
    public void acceptIncoming(OutsourcedPart selectedPart) {
        //set our values from dashboard
        idText.setText(String.valueOf(selectedPart.getId()));
        name.setText(selectedPart.getName());
        inventory.setText(String.valueOf(selectedPart.getStock()));
        cost.setText(String.valueOf(selectedPart.getPrice()));
        maxInv.setText(String.valueOf(selectedPart.getMax()));
        minInv.setText(String.valueOf(selectedPart.getMin()));
        sourceLabel.setText("Company Name");
        sourceText.setText(selectedPart.getCompanyName());
    }
    
    
    @FXML
    void cancelSavePart(ActionEvent event) {
        try {
            //send back to dashboard
            Stage primary = (Stage) idText.getScene().getWindow();
            primary.setWidth(1176);
            primary.setHeight(538);
            Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
            Scene scene = new Scene(root);
            primary.setScene(scene);
            primary.show();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }

    @FXML
    void savePart(ActionEvent event) {
        try {
            //send back to dashboard
            Stage primary = (Stage) idText.getScene().getWindow();
            primary.setWidth(1176);
            primary.setHeight(538);
            Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));
            Scene scene = new Scene(root);
            primary.setScene(scene);
            primary.show();
        } catch (IOException io) {
            io.printStackTrace();
        }
    }
    
    @FXML
    void addSelectedPart(ActionEvent event){
        
    }

    @FXML
    void remSelectedPart(ActionEvent event){
        
    }
    
}
