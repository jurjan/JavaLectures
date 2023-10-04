package model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Other extends Product {
    private int id;
    private double weight;

    public Other(String title, String description, String manufacturer, double price, Warehouse warehouse, double weight) {
        super(title, description, manufacturer, price, warehouse);
        this.weight = weight;
    }
}
