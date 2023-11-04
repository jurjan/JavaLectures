package com.kursinis.prif4kursinis.fxControllers.tableviewparameters;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class UserTableParameters {
    SimpleIntegerProperty id = new SimpleIntegerProperty();
    SimpleStringProperty login = new SimpleStringProperty();
    SimpleStringProperty password = new SimpleStringProperty();
    //Pabaigti likusius atributus, kurie bendri Customer ir Manager lentose/klasese


    public UserTableParameters(SimpleIntegerProperty id, SimpleStringProperty login, SimpleStringProperty password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public UserTableParameters() {
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getLogin() {
        return login.get();
    }

    public SimpleStringProperty loginProperty() {
        return login;
    }

    public void setLogin(String login) {
        this.login.set(login);
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }
}
