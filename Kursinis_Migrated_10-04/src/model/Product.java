package model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String title;
    String description;
    String manufacturer;
    double price;
    @ManyToOne
    Warehouse warehouse;

    @ManyToOne
    Cart cart;

    public Product(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Product(String title, String description, String manufacturer, double price) {
        this.title = title;
        this.description = description;
        this.manufacturer = manufacturer;
        this.price = price;
    }

    public Product(String title, String description, String manufacturer, double price, Warehouse warehouse) {
        this.title = title;
        this.description = description;
        this.manufacturer = manufacturer;
        this.price = price;
        this.warehouse = warehouse;
    }

    @Override
    public String toString() {
        return id + " " + title + " " + price;
    }
}
