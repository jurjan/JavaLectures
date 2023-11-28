package com.kursinis.prif4kursinis.fxControllers;

import com.kursinis.prif4kursinis.StartGui;
import com.kursinis.prif4kursinis.fxControllers.tableviewparameters.CustomerTableParameters;
import com.kursinis.prif4kursinis.hibernateControllers.CustomHib;
import com.kursinis.prif4kursinis.model.*;
import jakarta.persistence.EntityManagerFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainShopController implements Initializable {

    @FXML
    public Tab usersTab;
    @FXML
    public Tab warehouseTab;
    @FXML
    public ListView<Warehouse> warehouseList;
    @FXML
    public TextField addressWarehouseField;
    @FXML
    public TextField titleWarehouseField;
    @FXML
    public Tab ordersTab;
    @FXML
    public Tab productsTab;
    @FXML
    public TabPane tabPane;
    @FXML
    public Tab primaryTab;
    public TextField commentTitleField;
    public TextArea commentBodyField;
    public ListView<Comment> commentListField;
    public Tab commentTab;
    public ListView<Cart> allOrders;
    public ListView<Product> productListForOrders;
    @FXML
    private CustomerTabController customerTabController;
    @FXML
    private UserTabController userTabController;
    @FXML
    private ProductTabController productTabController;


    private EntityManagerFactory entityManagerFactory;
    private User currentUser;
    private CustomHib customHib;


    public void setData(EntityManagerFactory entityManagerFactory, User currentUser) {
        this.entityManagerFactory = entityManagerFactory;
        this.currentUser = currentUser;
        this.customHib = new CustomHib(entityManagerFactory);
        customerTabController.setCustomHib(customHib);
        customerTabController.setCurrentUser(currentUser);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }



    public void loadTabValues() {
        if (productsTab.isSelected()) {
            List<Warehouse> record = customHib.getAllRecords(Warehouse.class);
            productTabController.setData(customHib, currentUser);
        } else if (warehouseTab.isSelected()) {
            loadWarehouseList();
        } else if (commentTab.isSelected()) {
            loadCommentList();
        } else if (usersTab.isSelected()) {
            userTabController.setData(customHib, currentUser);
        } else if (ordersTab.isSelected()) {
            productListForOrders.getItems().addAll(customHib.getAvailableProducts());
            allOrders.getItems().addAll(customHib.getAllRecords(Cart.class));
        }
    }

    //----------------------Warehouse functionality-----------------------------//

    private void loadWarehouseList() {
        warehouseList.getItems().clear();
        warehouseList.getItems().addAll(customHib.getAllRecords(Warehouse.class));
    }

    public void addNewWarehouse() {
        customHib.create(new Warehouse(titleWarehouseField.getText(), addressWarehouseField.getText()));
        loadWarehouseList();
    }

    public void updateWarehouse() {
        Warehouse selectedWarehouse = warehouseList.getSelectionModel().getSelectedItem();
        Warehouse warehouse = customHib.getEntityById(Warehouse.class, selectedWarehouse.getId());
        warehouse.setTitle(titleWarehouseField.getText());
        warehouse.setAddress(addressWarehouseField.getText());
        customHib.update(warehouse);
        loadWarehouseList();
    }

    public void removeWarehouse() {
        Warehouse selectedWarehouse = warehouseList.getSelectionModel().getSelectedItem();
        Warehouse warehouse = customHib.getEntityById(Warehouse.class, selectedWarehouse.getId());
        customHib.delete(Warehouse.class, selectedWarehouse.getId());
        loadWarehouseList();
    }

    public void loadWarehouseData() {
        Warehouse selectedWarehouse = warehouseList.getSelectionModel().getSelectedItem();
        titleWarehouseField.setText(selectedWarehouse.getTitle());
        addressWarehouseField.setText(selectedWarehouse.getAddress());
    }

    //--------------Comment test section ------------------------//

    private void loadCommentList() {
        commentListField.getItems().clear();
        commentListField.getItems().addAll(customHib.getAllRecords(Comment.class));
    }

    public void createComment() {
        Comment comment = new Comment(commentTitleField.getText(), commentBodyField.getText());
        customHib.create(comment);
        loadCommentList();
    }


    public void updateComment() {
        Comment selectedComment = commentListField.getSelectionModel().getSelectedItem();
        Comment commentFromDb = customHib.getEntityById(Comment.class, selectedComment.getId());
        commentFromDb.setCommentTitle(commentTitleField.getText());
        commentFromDb.setCommentBody(commentBodyField.getText());
        customHib.update(commentFromDb);
        loadCommentList();
    }

    public void deleteComment() {
        Comment selectedComment = commentListField.getSelectionModel().getSelectedItem();
        //Comment commentFromDb = genericHib.getEntityById(Comment.class, selectedComment.getId());
        customHib.delete(Comment.class, selectedComment.getId());
        loadCommentList();
    }

    public void loadCommentInfo() {
        Comment selectedComment = commentListField.getSelectionModel().getSelectedItem();
        commentTitleField.setText(selectedComment.getCommentTitle());
        commentBodyField.setText(selectedComment.getCommentBody());
    }

    public void addToExistingOrder() {
        Cart cart = customHib.getEntityById(Cart.class, allOrders.getSelectionModel().getSelectedItem().getId());
        Product product = customHib.getEntityById(Product.class, productListForOrders.getSelectionModel().getSelectedItem().getId());
        cart.getItemsInCart().add(product);
        product.setCart(cart);
        customHib.update(cart);
    }

    public void removeFromExisting() {
    }
}
