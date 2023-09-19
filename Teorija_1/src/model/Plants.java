package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Plants extends Product {

    private LocalDate plantDate;

    public Plants(int id, String title, String description, LocalDate plantDate) {
        super(id, title, description);
        this.plantDate = plantDate;
    }
}
