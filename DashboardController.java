/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c482;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 *
 * @author Raxa
 */
public class DashboardController implements Initializable {

    private Inventory invetory = new Inventory();

    @FXML
    private TableView<Part> partTable; //table to hold parts 
    @FXML
    private TableColumn<Part, Integer> partIdColumn;
    @FXML
    private TableColumn<Part, String> partNameColumn;
    @FXML
    private TableColumn<Part, Double> partPriceColumn;
    @FXML
    private TableColumn<Part, Integer> partStockColumn;

    @FXML
    private TableView<Product> productTable; //table to hold products
    @FXML
    private TableColumn<Product, Integer> productIdColumn;
    @FXML
    private TableColumn<Product, String> productNameColumn;
    @FXML
    private TableColumn<Product, Double> productPriceColumn;
    @FXML
    private TableColumn<Product, Integer> productStockColumn;

    @FXML
    private TextField partSearch; //search bar for parts

    @FXML
    private TextField productSearch; //search bar for products

    //functions to handle parts section
    @FXML
    private void addNewPart(ActionEvent event) {
        try {
            //open new scene for add part window
            Stage primary = (Stage) partTable.getScene().getWindow();
            //set dimensions for this screen
            primary.setWidth(653);
            primary.setHeight(580);
            Parent addScreen = FXMLLoader.load(getClass().getResource("AddPart.fxml"));
            primary.getScene().setRoot(addScreen);
        } catch (IOException ie) {
            ie.printStackTrace();
            System.out.println("Error trying to open add new part menu");
        }
    }

    @FXML
    private void modifyPart(ActionEvent event) {
        Part selectedPart;
        String partName;
        try {
            selectedPart = partTable.getSelectionModel().getSelectedItem();
            String classType = partTable.getSelectionModel().getSelectedItem().getClass().getSimpleName();
            if (classType.equals("InHousePart")) {
                try {
                    InHousePart inHouse = (InHousePart) selectedPart;
                    //open new scene for modify part window
                    Stage primary = (Stage) partTable.getScene().getWindow();
                    //set dimensions for this screen
                    primary.setWidth(600);
                    primary.setHeight(550);
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifyPart.fxml"));

                    Parent modifyScreen = loader.load();
                    primary.getScene().setRoot(modifyScreen);
                    ModifyPartController controller = loader.getController();
                    controller.acceptIncoming(inHouse);

                } catch (IOException ie) {
                    ie.printStackTrace();
                    System.out.println("Error trying to open modify part menu");
                }
            } else {
                try {
                    OutsourcedPart outSource = (OutsourcedPart) selectedPart;
                    //open new scene for modify part window
                    Stage primary = (Stage) partTable.getScene().getWindow();
                    //set dimensions for this screen
                    primary.setWidth(600);
                    primary.setHeight(550);
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifyPart.fxml"));

                    Parent modifyScreen = loader.load();
                    primary.getScene().setRoot(modifyScreen);
                    ModifyPartController controller = loader.getController();
                    controller.acceptIncoming(outSource);

                } catch (IOException ie) {
                    ie.printStackTrace();
                    System.out.println("Error trying to open modify part menu");
                }
            }
            partName = selectedPart.getName();
        } catch (NullPointerException ne) {
            partName = "";
            selectedPart = null;
        }
        if (partName.equals("")) {
            System.out.println("No part selected to delete");
        } else {
            
        }
    }

    @FXML
    private void deletePart(ActionEvent event) {
        Part selectedPart;
        String partName;
        try {
            selectedPart = partTable.getSelectionModel().getSelectedItem();
            partName = selectedPart.getName();
        } catch (NullPointerException ne) {
            partName = "";
            selectedPart = null;
        }
        if (partName.equals("")) {
            System.out.println("No part selected to delete");
        } else {
            Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
            confirmation.setContentText("Are you sure you wish to delete the part: " + partName);
            Optional<ButtonType> choice = confirmation.showAndWait();
            if (choice.get() == ButtonType.OK) {
                //delete
                Main.inventory.deletePart(selectedPart);
            } else {
                //cancel
            }
        }

    }

    //function to handle products section
    @FXML
    private void addNewProduct(ActionEvent event) {
        try {
            //open new scene for add product window
            Stage primary = (Stage) productTable.getScene().getWindow();
            //set dimensions for this screen
            primary.setWidth(861);
            primary.setHeight(645);
            Parent addScreen = FXMLLoader.load(getClass().getResource("AddProduct.fxml"));
            primary.getScene().setRoot(addScreen);
        } catch (IOException ie) {
            ie.printStackTrace();
            System.out.println("Error trying to open add new product menu");
        }
    }

    @FXML
    private void modifyProduct(ActionEvent event) {
        try {
            Product selectedProduct;
            String productName;
            try {
                selectedProduct = productTable.getSelectionModel().getSelectedItem();
                productName = selectedProduct.getName();
            } catch (NullPointerException ne) {
                productName = "";
                selectedProduct = null;
            }
            if (productName.equals("")) {
                //no selection found
            } else {
                //open new scene for modify product window
                Stage primary = (Stage) productTable.getScene().getWindow();
                //set dimensions for this screen
                primary.setWidth(869);
                primary.setHeight(635);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ModifyProduct.fxml"));

                Parent modifyScreen = loader.load();
                primary.getScene().setRoot(modifyScreen);
                ModifyProductController controller = loader.getController();
                controller.acceptIncoming(selectedProduct);
            }
        } catch (IOException ie) {
            ie.printStackTrace();
            System.out.println("Error trying to open modify product menu");
        }
    }

    @FXML
    private void deleteProduct(ActionEvent event) {

        //open confirmation window for deleting a product
        Product selectedProduct;
        String productName;
        try {
            selectedProduct = productTable.getSelectionModel().getSelectedItem();
            productName = selectedProduct.getName();
        } catch (NullPointerException ne) {
            productName = "";
            selectedProduct = null;
        }
        if (productName.equals("")) {
            System.out.println("No part selected to delete");
        } else {
            Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
            confirmation.setContentText("Are you sure you wish to delete the part: " + productName);
            Optional<ButtonType> choice = confirmation.showAndWait();
            if (choice.get() == ButtonType.OK) {
                //verify product does not have attached parts
                if (selectedProduct.getAllAssociatedParts().size() > 0) {
                    //deny
                    System.out.println("Associated part found");
                } else {
                    //delete
                    Main.inventory.deleteProduct(selectedProduct);
                }
            } else {
                //cancel
            }
        }

    }

    /**
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // setup tables to accept data
        setupPartsTable();
        setupProductsTable();

        //load data
        partTable.setItems(Main.inventory.getAllParts());
        productTable.setItems(Main.inventory.getAllProducts());

        //listen to the search text boxes
        partSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            //if search bar is empty, restore all items
            if (newValue.length() < 1) {
                reloadPartsTable();
            } else {
                //check for number input
                boolean isNumber = isNumber(newValue);
                if (isNumber) {
                    try {
                        Part result = Main.inventory.lookupPart(Integer.parseInt(newValue));
                        ObservableList<Part> resultingPart = FXCollections.observableArrayList();
                        resultingPart.add(result);
                        partTable.setItems(resultingPart);
                    } catch (NullPointerException ne) {
                        //ignore as this means no results found
                        ObservableList<Part> resultingPart = FXCollections.observableArrayList();
                        partTable.setItems(resultingPart);
                    }
                } else {
                    partTable.setItems(Main.inventory.lookupPart(newValue));
                }
            }
        });
        productSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            //search products for matching value

            //if search bar is empty, restore all items
            if (newValue.length() < 1) {
                reloadProductsTable();
            } else {
                //check for number input
                boolean isNumber = isNumber(newValue);
                if (isNumber) {
                    try {
                        Product result = Main.inventory.lookupProduct(Integer.parseInt(newValue));
                        ObservableList<Product> resultingProduct = FXCollections.observableArrayList();
                        resultingProduct.add(result);
                        productTable.setItems(resultingProduct);
                    } catch (NullPointerException ne) {
                        //ignore as this means no results found
                        ObservableList<Product> resultingPart = FXCollections.observableArrayList();
                        productTable.setItems(resultingPart);
                    }
                } else {
                    productTable.setItems(Main.inventory.lookupProduct(newValue));
                }
            }
        });
    }

    @FXML
    private void exit(ActionEvent event) {
        //exit the application
        Platform.exit();
    }

    private void setupPartsTable() {
        partIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        partNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        partPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        partStockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
    }

    private void setupProductsTable() {
        productIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        productNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        productPriceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        productStockColumn.setCellValueFactory(new PropertyValueFactory<>("stock"));
    }

    private void reloadPartsTable() {
        partTable.setItems(Main.inventory.getAllParts());
    }

    private void reloadProductsTable() {
        productTable.setItems(Main.inventory.getAllProducts());
    }

    private boolean isNumber(String input) {
        try {
            int id = Integer.parseInt(input);
        } catch (NumberFormatException ne) {
            return false;
        }
        return true;
    }

}
