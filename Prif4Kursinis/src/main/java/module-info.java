module com.kursinis.prif4kursinis {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;


    opens com.kursinis.prif4kursinis to javafx.fxml;
    exports com.kursinis.prif4kursinis;
    opens com.kursinis.prif4kursinis.model to javafx.fxml, org.hibernate.orm.core;
    exports com.kursinis.prif4kursinis.model;
    opens com.kursinis.prif4kursinis.fxControllers to javafx.fxml;
    exports com.kursinis.prif4kursinis.fxControllers to javafx.fxml;
    opens com.kursinis.prif4kursinis.fxControllers.tableviewparameters to javafx.base;
}