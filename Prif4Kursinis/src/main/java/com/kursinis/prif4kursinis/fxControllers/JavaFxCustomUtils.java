package com.kursinis.prif4kursinis.fxControllers;

import javafx.scene.control.Alert;

public class JavaFxCustomUtils {

    public static void generateAlert(Alert.AlertType alertType, String title, String header, String content){
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }
}
