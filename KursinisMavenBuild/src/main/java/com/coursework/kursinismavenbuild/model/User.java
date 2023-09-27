package com.coursework.kursinismavenbuild.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public abstract class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(unique = true)
    String login;
    String password;
    LocalDate birthDate;
    String name;
    String surname;
    @OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @LazyCollection(LazyCollectionOption.FALSE)
    List<Comment> myComments;


    public User(String login, String password, LocalDate birthDate) {
        this.login = login;
        this.password = password;
        this.birthDate = birthDate;
    }

    public User(int id, String login, String password, LocalDate birthDate) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
