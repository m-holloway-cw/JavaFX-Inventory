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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Raxa
 */
public class AddPartController implements Initializable {

    @FXML
    private RadioButton inhouse;

    @FXML
    private ToggleGroup partSourceToggle;

    @FXML
    private RadioButton outsourced;

    @FXML
    private TextField name;

    @FXML
    private TextField inventory;

    @FXML
    private TextField cost;

    @FXML
    private TextField maxInv;

    @FXML
    private TextField sourceText;

    @FXML
    private TextField minInv;

    @FXML
    private Label sourceLabel;

    @FXML
    void cancelSavePart(ActionEvent event) {
        try {
            //send back to dashboard
            Stage primary = (Stage) name.getScene().getWindow();
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
            Stage primary = (Stage) name.getScene().getWindow();
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
