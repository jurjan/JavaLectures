package model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Fertilizer extends Product {
    private double weight;
    private String chemicalDescription;

    public Fertilizer(String title, String description, String manufacturer, double price, Warehouse warehouse, double weight, String chemicalDescription) {
        super(title, description, manufacturer, price, warehouse);
        this.weight = weight;
        this.chemicalDescription = chemicalDescription;
    }
}
