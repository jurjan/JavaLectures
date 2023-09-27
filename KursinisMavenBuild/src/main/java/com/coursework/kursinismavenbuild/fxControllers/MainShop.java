package com.coursework.kursinismavenbuild.fxControllers;

import com.coursework.kursinismavenbuild.model.Product;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainShop implements Initializable {


    public ListView<Product> productList;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        Connection connection = DatabaseUtils.connectToDb();
//        try {
//
//            ArrayList<Product> productsFromDb = new ArrayList<>();
//            Statement stmt = connection.createStatement();
//            String query = "Select * from product";
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                int id = rs.getInt(1);
//                String title = rs.getString(2);
//                String description = rs.getString(3);
//                LocalDate plantDate = rs.getDate(4).toLocalDate();
//
//                Plants plants = new Plants(id, title, description, plantDate);
//                productsFromDb.add(plants);
//            }
//
//            productList.getItems().addAll(productsFromDb);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
