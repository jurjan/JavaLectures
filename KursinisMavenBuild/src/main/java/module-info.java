module com.coursework.kursinismavenbuild {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;


    opens com.coursework.kursinismavenbuild to javafx.fxml;
    exports com.coursework.kursinismavenbuild;
    opens com.coursework.kursinismavenbuild.fxControllers to javafx.fxml;
    exports com.coursework.kursinismavenbuild.fxControllers to javafx.fxml;
    opens com.coursework.kursinismavenbuild.model to org.hibernate.orm.core;
}