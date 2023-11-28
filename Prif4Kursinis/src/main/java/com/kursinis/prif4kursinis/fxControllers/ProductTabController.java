package com.kursinis.prif4kursinis.fxControllers;

import com.kursinis.prif4kursinis.hibernateControllers.CustomHib;
import com.kursinis.prif4kursinis.model.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductTabController implements Initializable {
    @FXML
    public ListView<Product> productListManager;
    @FXML
    public TextField productTitleField;
    @FXML
    public TextArea productDescriptionField;
    @FXML
    public ComboBox<ProductType> productType;
    @FXML
    public ComboBox<Warehouse> warehouseComboBox;
    @FXML
    public DatePicker plantDateField;
    @FXML
    public TextField weightField;
    @FXML
    public TextArea chemicalDescriptionField;
    @FXML
    public TextField productManufacturerField;

    private CustomHib customHib;

    public void setData(CustomHib customHib, User currentUser) {
        this.customHib = customHib;
        warehouseComboBox.getItems().addAll(customHib.getAllRecords(Warehouse.class));
        loadProductListManager();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        productType.getItems().addAll(ProductType.values());
    }

    public void enableProductFields() {
        if (productType.getSelectionModel().getSelectedItem() == ProductType.PLANT) {

            plantDateField.setDisable(false);
            weightField.setDisable(true);
            chemicalDescriptionField.setDisable(true);
        } else if (productType.getSelectionModel().getSelectedItem() == ProductType.OTHER) {
            plantDateField.setDisable(true);
            weightField.setDisable(false);
            chemicalDescriptionField.setDisable(true);
        } else {
            plantDateField.setDisable(true);
            weightField.setDisable(false);
            chemicalDescriptionField.setDisable(false);
        }
    }

    private void loadProductListManager() {
        productListManager.getItems().clear();
        productListManager.getItems().addAll(customHib.getAvailableProducts());
    }

    public void addNewProduct() {
        if (productType.getSelectionModel().getSelectedItem() == ProductType.PLANT) {
            Warehouse selectedWarehouse = warehouseComboBox.getSelectionModel().getSelectedItem();
            Warehouse warehouse = customHib.getEntityById(Warehouse.class, selectedWarehouse.getId());
            customHib.create(new Plant(productTitleField.getText(), productDescriptionField.getText(), productManufacturerField.getText(), warehouse, plantDateField.getValue()));
        }
        loadProductListManager();
    }

    public void updateProduct() {
        loadProductListManager();
    }

    public void deleteProduct() {

        Product selectedProduct = productListManager.getSelectionModel().getSelectedItem();
        customHib.deleteProduct(selectedProduct.getId());

        loadProductListManager();
    }
}
