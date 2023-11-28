package com.kursinis.prif4kursinis.fxControllers;

import com.kursinis.prif4kursinis.hibernateControllers.CustomHib;
import com.kursinis.prif4kursinis.model.Comment;
import com.kursinis.prif4kursinis.model.Product;
import com.kursinis.prif4kursinis.model.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

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
    }

    public void deleteComment() {
        TreeItem<Comment> taskTreeItem = commentsTree.getSelectionModel().getSelectedItem();
        customHib.deleteComment(taskTreeItem.getValue().getId());
    }

    public void reply() {
        TreeItem<Comment> taskTreeItem = commentsTree.getSelectionModel().getSelectedItem();


    }

    public void loadComments() {
        Product selectedProduct = customHib.getEntityById(Product.class, productList.getSelectionModel().getSelectedItem().getId());
        commentsTree.setRoot(new TreeItem<>());
        commentsTree.setShowRoot(false);
        commentsTree.getRoot().setExpanded(true);
        selectedProduct.getReviews().forEach(task -> addTreeItem(task, commentsTree.getRoot()));
    }

    private void addTreeItem(Comment comment, TreeItem<Comment> parentComment) {
        TreeItem<Comment> treeItem = new TreeItem<>(comment);
        parentComment.getChildren().add(treeItem);
        comment.getReplies().forEach(sub -> addTreeItem(sub, treeItem));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
