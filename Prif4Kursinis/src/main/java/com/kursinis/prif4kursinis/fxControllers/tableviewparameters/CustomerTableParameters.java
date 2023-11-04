package com.kursinis.prif4kursinis.fxControllers.tableviewparameters;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class CustomerTableParameters extends UserTableParameters{

    private SimpleStringProperty address = new SimpleStringProperty();
    //Cia reiktu susirinkti likusius Customer klases laukus/atributus

    public CustomerTableParameters(SimpleIntegerProperty id, SimpleStringProperty login, SimpleStringProperty password, SimpleStringProperty address) {
        super(id, login, password);
        this.address = address;
    }

    public CustomerTableParameters() {
    }

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }
}
