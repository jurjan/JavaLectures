package model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Plant extends Product {

    private LocalDate plantDate;

    public Plant(String title, String description, LocalDate plantDate) {
        super(title, description);
        this.plantDate = plantDate;
    }

    public Plant(String title, String description, String manufacturer, Warehouse warehouse, LocalDate plantDate) {
        super(title, description, manufacturer, warehouse);
        this.plantDate = plantDate;
    }
}
