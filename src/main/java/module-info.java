module com.example.f23comp1011movies {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.f23comp1011movies to javafx.fxml;
    exports com.example.f23comp1011movies;
}