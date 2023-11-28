package com.kursinis.prif4kursinis.fxControllers;

import com.kursinis.prif4kursinis.hibernateControllers.CustomHib;
import com.kursinis.prif4kursinis.model.Product;
import com.kursinis.prif4kursinis.model.User;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class CustomerTabController {

    @FXML
    public ListView<Product> productList;
    @FXML
    public ListView<Product> currentOrder;

    private User currentUser;
    private CustomHib customHib;

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void setCustomHib(CustomHib customHib) {
        this.customHib = customHib;
        productList.getItems().clear();
        productList.getItems().addAll(customHib.getAllRecords(Product.class));
    }

    public void addToCart() {
        Product selectedProduct = productList.getSelectionModel().getSelectedItem();
        currentOrder.getItems().add(selectedProduct);
        productList.getItems().remove(selectedProduct);
    }

    public void removeFromCart() {
        Product productToRemove = currentOrder.getSelectionModel().getSelectedItem();
        productList.getItems().add(productToRemove);
        currentOrder.getItems().remove(productToRemove);
    }

    public void createCart() {
        customHib.addToCart(currentUser.getId(), currentOrder.getItems());
        currentOrder.getItems().clear();
        productList.getItems().addAll(customHib.getAvailableProducts());
    }

    public void leaveComment() {
    }
}
