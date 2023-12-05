package com.kursinis.prif4kursinis.fxControllers;

import com.kursinis.prif4kursinis.hibernateControllers.GenericHib;
import com.kursinis.prif4kursinis.model.Comment;
import com.kursinis.prif4kursinis.model.Product;
import com.kursinis.prif4kursinis.model.Review;
import jakarta.persistence.EntityManagerFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CommentForm {

    @FXML
    public TextField commentTitleField;
    @FXML
    public TextArea commentBodyField;
    @FXML
    public Slider ratingField;

    private int productId = 0;
    private int commentId = 0;
    private GenericHib genericHib;

    public void setData(GenericHib genericHib, int productId, int commentId) {
        this.genericHib = genericHib;
        this.productId = productId;
        this.commentId = commentId;
    }

    public void saveData() {

        if (productId != 0) {
            Product product = genericHib.getEntityById(Product.class, productId);
            Review review = new Review(commentTitleField.getText(), commentBodyField.getText(), ratingField.getValue(), product);
            product.getReviews().add(review);
            genericHib.update(product);
        } else if (commentId != 0) {
            Comment parentComment = genericHib.getEntityById(Comment.class, commentId);
            Comment reply = new Comment(commentTitleField.getText(), commentBodyField.getText(), parentComment);
            parentComment.getReplies().add(reply);
            genericHib.update(parentComment);
        }

    }
}
