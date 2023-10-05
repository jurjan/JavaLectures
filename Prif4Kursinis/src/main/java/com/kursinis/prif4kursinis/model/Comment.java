package com.kursinis.prif4kursinis.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String commentTitle;
    private String commentBody;
    private LocalDate dateCreated;

    public Comment(String commentTitle, String commentBody) {
        this.commentTitle = commentTitle;
        this.commentBody = commentBody;
        this.dateCreated = LocalDate.now();
    }

    @Override
    public String toString() {
        return commentTitle + ":" + dateCreated;
    }
}
