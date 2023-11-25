package com.example.f23comp1011movies;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class InfoViewController implements MovieLoader{

    @FXML
    private Label genreLabel;

    @FXML
    private ImageView imageView;

    @FXML
    private Label languageLabel;

    @FXML
    private Label plotLabel;

    @FXML
    private Label ratedLabel;

    @FXML
    private ListView<?> ratingsListView;

    @FXML
    private Label titleLabel;

    @FXML
    private Label yearLabel;

    @FXML
    void backToPrevious(ActionEvent event) throws IOException {
        SceneChanger.changeScenes(event,"search-view.fxml");
    }

    public void loadMovie(String imbdId){
        System.out.println(imbdId);
    }

}
