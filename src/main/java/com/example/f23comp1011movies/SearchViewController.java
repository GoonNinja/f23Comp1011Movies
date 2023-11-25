package com.example.f23comp1011movies;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class SearchViewController {

    @FXML
    private ListView<Movie> listView;

    @FXML
    private Label msgLabel;

    @FXML
    private ImageView posterImageView;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private HBox resultsBox;

    @FXML
    private TextField searchTextField;

    @FXML
    private VBox selectedVBox;

    @FXML
    private VBox titlesVBox;


    @FXML
    private Label resultsMsgLabel;

    @FXML
    private Button fetchAllButton;

    private int page, totalNumberOfmovies;

    @FXML
    void fetchAllMovies(ActionEvent event) {

    }

    @FXML void initialize(){
        progressBar.setVisible(false);
        selectedVBox.setVisible(false);
        titlesVBox.setVisible(false);
        msgLabel.setVisible(false);

        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, movieSelected) -> {
            if(movieSelected != null){
                selectedVBox.setVisible(true);
               try{
                   posterImageView.setImage(new Image(movieSelected.getPoster()));
               }
               catch(IllegalArgumentException e){
                   posterImageView.setImage(new Image(Main.class.getResourceAsStream("/images/default_poster.png")));
               }
            }
            else{
                selectedVBox.setVisible(false);
            }
        });
    }

    @FXML
    private void searchMovie(ActionEvent event) throws IOException, InterruptedException {

        page = 1;
        //Read from textfield
        String movieName = searchTextField.getText().trim();
        ApiResponse apiResponse =  APIUtility.callAPI(movieName);
        totalNumberOfmovies = Integer.parseInt(apiResponse.getTotalResults());

        if(apiResponse.getMovies() != null){
            posterImageView.setVisible(true);
            titlesVBox.setVisible(true);
            listView.getItems().clear();
            listView.getItems().addAll(apiResponse.getMovies());
            updateLabels();
        }
        else {
            posterImageView.setVisible(false);
            titlesVBox.setVisible(false);
            msgLabel.setVisible(true);
            msgLabel.setText("Enter a movie title.");
        }
    }

    @FXML
    void getMovieDetails(ActionEvent event) throws IOException, InterruptedException {
        Movie movieSelected = listView.getSelectionModel().getSelectedItem();
        SceneChanger.changeScenes(event,"info-view.fxml", movieSelected.getImdbID());
    }

    private void updateLabels(){
        resultsMsgLabel.setText("Showing " + listView.getItems().size() + " Of " + totalNumberOfmovies);

        if(listView.getItems().size() < totalNumberOfmovies){
            fetchAllButton.setVisible(true);
        }
        else{
            fetchAllButton.setVisible(false);
        }
    }
}
