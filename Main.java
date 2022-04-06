/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c482;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Raxa
 */
public class Main extends Application {

    public static Inventory inventory;

    @Override
    public void start(Stage stage) throws Exception {
        //setup our inventory class
        inventory = new Inventory();

        //create fake parts for example
        InHousePart part1 = new InHousePart(1, "part1", 19.99, 2, 0, 10, 1);
        OutsourcedPart part2 = new OutsourcedPart(2, "outPart1", 20.50, 3, 0, 100, "Company12");
        //add to inventory
        inventory.addPart(part1);
        inventory.addPart(part2);

        //create fake products for example
        Product product1 = new Product(1, "Product1", 199.99, 3, 0, 10);
        Product product2 = new Product(2, "Product2", 499.99, 1, 0, 10);
        //add to inventory
        inventory.addProduct(product1);
        inventory.addProduct(product2);

        Parent root = FXMLLoader.load(getClass().getResource("Dashboard.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
