package com.kursinis.prif4kursinis.fxControllers;

import com.kursinis.prif4kursinis.StartGui;
import com.kursinis.prif4kursinis.hibernateControllers.CustomHib;
import com.kursinis.prif4kursinis.model.Comment;
import com.kursinis.prif4kursinis.model.Product;
import com.kursinis.prif4kursinis.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CommentTree implements Initializable {
    @FXML
    public TreeView<Comment> commentsTree;
    @FXML
    public ListView<Product> productList;

    private CustomHib customHib;
    private User currentUser;

    public void setData(CustomHib customHib, User currentUser) {
        this.customHib = customHib;
        this.currentUser = currentUser;
        loadProducts();
    }

    private void loadProducts() {
        productList.getItems().clear();
        productList.getItems().addAll(customHib.getAllRecords(Product.class));
    }

    public void deleteComment() {
        TreeItem<Comment> commentTreeItem = commentsTree.getSelectionModel().getSelectedItem();
        customHib.deleteComment(commentTreeItem.getValue().getId());
    }

    public void reply() throws IOException {
        TreeItem<Comment> commentTreeItem = commentsTree.getSelectionModel().getSelectedItem();
        FXMLLoader fxmlLoader = new FXMLLoader(StartGui.class.getResource("commentForm.fxml"));
        Parent parent = fxmlLoader.load();
        CommentForm commentForm = fxmlLoader.getController();
        commentForm.setData(customHib, 0, commentTreeItem.getValue().getId());
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setTitle("Shop");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();

    }

    public void loadComments() {
        Product selectedProduct = customHib.getEntityById(Product.class, productList.getSelectionModel().getSelectedItem().getId());
        commentsTree.setRoot(new TreeItem<>());
        commentsTree.setShowRoot(false);
        commentsTree.getRoot().setExpanded(true);
        selectedProduct.getReviews().forEach(comment -> addTreeItem(comment, commentsTree.getRoot()));
    }

    private void addTreeItem(Comment comment, TreeItem<Comment> parentComment) {
        TreeItem<Comment> treeItem = new TreeItem<>(comment);
        parentComment.getChildren().add(treeItem);
        comment.getReplies().forEach(sub -> addTreeItem(sub, treeItem));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void loadResponseForm() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(StartGui.class.getResource("commentForm.fxml"));
        Parent parent = fxmlLoader.load();
        CommentForm commentForm = fxmlLoader.getController();
        commentForm.setData(customHib, productList.getSelectionModel().getSelectedItem().getId(), 0);
        Stage stage = new Stage();
        Scene scene = new Scene(parent);
        stage.setTitle("Shop");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.showAndWait();
    }
}
