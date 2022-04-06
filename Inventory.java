/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c482;

import java.util.List;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Raxa
 */
public class Inventory {

    private ObservableList<Part> allParts = FXCollections.observableArrayList();
    private ObservableList<Product> allProducts = FXCollections.observableArrayList();

    /**
     *
     * @param newPart the part to be added
     */
    public void addPart(Part newPart) {
        allParts.add(newPart);
    }

    /**
     *
     * @param newProduct the product to be added
     */
    public void addProduct(Product newProduct) {
        allProducts.add(newProduct);
    }

    /**
     *
     * @param partId the id we are looking for
     * @return the part we are looking for by Id
     */
    public Part lookupPart(int partId) {
        List<Part> result = allParts.stream().filter(part -> part.getId() == partId).collect(Collectors.toList());
        if (result.size() > 0) {
            return result.get(0);
        } else {
            return null;
        }
    }

    /**
     *
     * @param productId the id we are looking for
     * @return the product we are looking for by Id
     */
    public Product lookupProduct(int productId) {
        List<Product> result = allProducts.stream().filter(product -> product.getId() == productId).collect(Collectors.toList());
        if (result.size() > 0) {
            return result.get(0);
        } else {
            return null;
        }
    }

    /**
     *
     * @param partName the name we are looking for
     * @return list of parts found by name
     */
    public ObservableList<Part> lookupPart(String partName) {
        List<Part> result = allParts.stream().filter(part -> {
            boolean isMatch = part.getName().toLowerCase().startsWith(partName.toLowerCase());
            return isMatch;
        }).collect(Collectors.toList());
        if (result.size() > 0) {
            ObservableList<Part> output = FXCollections.observableArrayList();
            //add all results to output
            result.forEach((item)->{
                output.add(item);
            });
            return output;
        } else {
            return null;
        }
    }

    /**
     *
     * @param productName the name we are looking for
     * @return list of products found by name
     */
    public ObservableList<Product> lookupProduct(String productName) {
        List<Product> result = allProducts.stream().filter(product -> {
            boolean isMatch = product.getName().toLowerCase().startsWith(productName.toLowerCase());
            return isMatch;
        }).collect(Collectors.toList());
        if (result.size() > 0) {
            ObservableList<Product> output = FXCollections.observableArrayList();
            //add all results to output
            result.forEach((item)->{
                output.add(item);
            });
            return output;
        } else {
            return null;
        }
    }

    /**
     *
     * @param index the index of the part we want to update
     * @param selectedPart the replacement part
     */
    public void updatePart(int index, Part selectedPart) {

    }

    /**
     *
     * @param index the index of the product we want to update
     * @param selectedProduct the replacement product
     */
    public void updateProduct(int index, Product selectedProduct) {

    }

    /**
     *
     * @param selectedPart the part we want to delete
     * @return if successfully deleted
     */
    public boolean deletePart(Part selectedPart) {
        System.out.println("Trying to delete part: " + selectedPart.getName());
        allParts.remove(selectedPart);
        return true;
    }

    /**
     *
     * @param selectedProduct the product we want to delete
     * @return if successfully deleted
     */
    public boolean deleteProduct(Product selectedProduct) {

        return true;
    }

    /**
     *
     * @return list of all parts found
     */
    public ObservableList<Part> getAllParts() {
        return allParts;
    }

    /**
     *
     * @return list of all products found
     */
    public ObservableList<Product> getAllProducts() {
        return allProducts;
    }

}
