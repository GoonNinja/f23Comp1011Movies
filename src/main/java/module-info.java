module com.example.f23comp1011movies {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires com.google.gson;


    opens com.example.f23comp1011movies to javafx.fxml, com.google.gson;
    exports com.example.f23comp1011movies;
}