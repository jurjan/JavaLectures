package com.coursework.kursinismavenbuild.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Manager extends User {

    private String employeeId;
    private String medCertificate;
    private LocalDate employmentDate;
    private boolean isAdmin;
    @ManyToOne
    private Warehouse worksInWarehouse;

    public Manager(String login, String password, LocalDate birthDate) {
        super(login, password, birthDate);
    }

    @Override
    public String toString() {
        return "Free text, ka noriu";
    }
}
