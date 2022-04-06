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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Raxa
 */
public class ModifyProductController implements Initializable {

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
    private TableView<Part> availablePartsTable; //table to hold parts 
    @FXML
    private TableColumn<Part, Integer> availablePartIdColumn;
    @FXML
    private TableColumn<Part, String> availablePartNameColumn;
    @FXML
    private TableColumn<Part, Double> availablePartPriceColumn;
    @FXML
    private TableColumn<Part, Integer> availablePartStockColumn;

    @FXML
    private TableView<Part> associatedPartsTable; //table to hold parts 
    @FXML
    private TableColumn<Part, Integer> associatedPartIdColumn;
    @FXML
    private TableColumn<Part, String> associatedPartNameColumn;
    @FXML
    private TableColumn<Part, Double> associatedPartPriceColumn;
    @FXML
    private TableColumn<Part, Integer> associatedPartStockColumn;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }

    
    public void acceptIncoming(Product selectedProduct) {
        //set our values from dashboard
        idText.setText(String.valueOf(selectedProduct.getId()));
        name.setText(selectedProduct.getName());
        inventory.setText(String.valueOf(selectedProduct.getStock()));
        cost.setText(String.valueOf(selectedProduct.getPrice()));
        maxInv.setText(String.valueOf(selectedProduct.getMax()));
        minInv.setText(String.valueOf(selectedProduct.getMin()));
        // setup tables
        availablePartsTable.setItems(Main.inventory.getAllParts());
        associatedPartsTable.setItems(selectedProduct.getAllAssociatedParts());
    }

    @FXML
    void cancelSaveProduct(ActionEvent event) {
        try {
            //send back to dashboard
            Stage primary = (Stage) availablePartsTable.getScene().getWindow();
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
    void saveProduct(ActionEvent event) {

        try {
            //send back to dashboard
            Stage primary = (Stage) availablePartsTable.getScene().getWindow();
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
