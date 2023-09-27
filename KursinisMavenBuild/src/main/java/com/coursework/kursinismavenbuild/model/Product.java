package com.coursework.kursinismavenbuild.model;

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
@MappedSuperclass
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String title;
    String description;
    String manufacturer;
    @ManyToOne
    private Cart cart;
    @ManyToOne
    private Warehouse warehouse;

    public Product(String title, String description) {
        this.title = title;
        this.description = description;
    }
}
