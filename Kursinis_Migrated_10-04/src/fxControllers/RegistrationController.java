package fxControllers;

import hibernateControllers.UserHib;
import jakarta.persistence.EntityManagerFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import model.Customer;
import model.Manager;
import model.User;

import java.io.IOException;

public class RegistrationController {

    @FXML
    public TextField loginField;
    @FXML
    public PasswordField passwordField;
    @FXML
    public PasswordField repeatPasswordField;
    @FXML
    public TextField nameField;
    @FXML
    public TextField surnameField;
    @FXML
    public RadioButton customerCheckbox;
    @FXML
    public ToggleGroup userType;
    @FXML
    public RadioButton managerCheckbox;
    @FXML
    public TextField addressField;
    @FXML
    public TextField cardNoField;
    @FXML
    public DatePicker birthDateField;
    @FXML
    public TextField employeeIdField;
    @FXML
    public TextField medCertificateField;
    @FXML
    public DatePicker employmentDateField;
    @FXML
    public CheckBox isAdminCheck;

    private EntityManagerFactory entityManagerFactory;
    private UserHib userHib;

    public void setData(EntityManagerFactory entityManagerFactory, boolean showManagerFields) {
        this.entityManagerFactory = entityManagerFactory;
        disableFields(showManagerFields);
    }

    public void setData(EntityManagerFactory entityManagerFactory, Manager manager) {
        this.entityManagerFactory = entityManagerFactory;
        toggleFields(customerCheckbox.isSelected(), manager);
    }

    private void disableFields(boolean showManagerFields) {
        if (!showManagerFields) {
            employeeIdField.setVisible(false);
            medCertificateField.setVisible(false);
            employmentDateField.setVisible(false);
            isAdminCheck.setVisible(false);
            managerCheckbox.setVisible(false);
        }
    }

    private void toggleFields(boolean isManager, Manager manager) {
        if (isManager) {
            addressField.setDisable(true);
            cardNoField.setDisable(true);
            employeeIdField.setDisable(false);
            medCertificateField.setDisable(false);
            employmentDateField.setDisable(false);
            if (manager.isAdmin()) isAdminCheck.setDisable(false);
        } else {
            addressField.setDisable(false);
            cardNoField.setDisable(false);
            employeeIdField.setDisable(true);
            medCertificateField.setDisable(true);
            employmentDateField.setDisable(true);
            isAdminCheck.setDisable(true);
        }
    }


    public void createUser() {
        userHib = new UserHib(entityManagerFactory);
        if (customerCheckbox.isSelected()) {
            User user = new Customer(loginField.getText(), passwordField.getText(), birthDateField.getValue(), nameField.getText(), surnameField.getText(), addressField.getText(), cardNoField.getText());
            userHib.createUser(user);
        } else {

        }
    }

    public void returnToLogin() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoginController.class.getResource("../view/login.fxml"));
        Parent parent = fxmlLoader.load();
        LoginController loginController = fxmlLoader.getController();
        loginController.setData(entityManagerFactory);
        Scene scene = new Scene(parent);
        Stage stage = (Stage) loginField.getScene().getWindow();
        stage.setTitle("Shop");
        stage.setScene(scene);
        stage.show();
    }
}
