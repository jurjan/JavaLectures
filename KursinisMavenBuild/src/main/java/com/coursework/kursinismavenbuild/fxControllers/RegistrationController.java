package com.coursework.kursinismavenbuild.fxControllers;

import com.coursework.kursinismavenbuild.hibernateControllers.UserHib;
import com.coursework.kursinismavenbuild.model.Customer;
import jakarta.persistence.EntityManagerFactory;
import javafx.fxml.FXML;
import javafx.scene.control.*;
//import utils.DatabaseUtils;
//
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.PreparedStatement;

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

    public void setData(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
        userHib = new UserHib(entityManagerFactory);
    }

    public void createUser() {
        //
        userHib.createUser(new Customer());


    }
}
