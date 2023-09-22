package fxControllers;

import javafx.scene.control.*;
import utils.DatabaseUtils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

public class Registration {

    public TextField loginField;
    public PasswordField passwordField;
    public PasswordField repeatPasswordField;
    public TextField nameField;
    public TextField surnameField;
    public RadioButton customerCheckbox;
    public ToggleGroup userType;
    public RadioButton managerCheckbox;
    public TextField addressField;
    public TextField cardNoField;
    public DatePicker birthDateField;
    public TextField employeeIdField;
    public TextField medCertificateField;
    public DatePicker employmentDateField;
    public CheckBox isAdminCheck;


    public void createUser() {
        try {
            Connection connection = DatabaseUtils.connectToDb();
            PreparedStatement insertUser = null;
            var sql = "";
            if (managerCheckbox.isSelected()) {
                sql = "INSERT INTO user(`login`, `password`, `name`, `surname`, `birthDate`, `employeeId`, `medCertificate`, `employmentDate`, `isAdmin`, `userType`) VALUES (?,?,?,?,?,?,?,?,?,?)";
                insertUser = connection.prepareStatement(sql);
                insertUser.setString(1, loginField.getText());
                insertUser.setString(2, passwordField.getText());
                insertUser.setString(3, nameField.getText());
                insertUser.setString(4, surnameField.getText());
                insertUser.setDate(5, Date.valueOf(birthDateField.getValue()));
                insertUser.setString(6, employeeIdField.getText());
                insertUser.setString(7, medCertificateField.getText());
                insertUser.setDate(8, Date.valueOf(employmentDateField.getValue()));
                insertUser.setBoolean(9, isAdminCheck.isSelected());
                insertUser.setString(10, "M");
                insertUser.execute();
            } else {
                sql = "INSERT INTO user(`login`, `password`, `name`, `surname`, `birthDate`, `address`, `cardNo`) VALUES (?,?,?,?,?,?,?)";
                insertUser = connection.prepareStatement(sql);
                insertUser.setString(1, loginField.getText());
                insertUser.setString(2, passwordField.getText());
                insertUser.setString(3, nameField.getText());
                insertUser.setString(4, surnameField.getText());
                insertUser.setDate(5, Date.valueOf(birthDateField.getValue()));
                insertUser.setString(6, addressField.getText());
                insertUser.setString(7, cardNoField.getText());
                insertUser.execute();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
