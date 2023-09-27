package com.coursework.kursinismavenbuild.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Fertilizer extends Product {
    private String chemicalProps;
    private double weight;

}
