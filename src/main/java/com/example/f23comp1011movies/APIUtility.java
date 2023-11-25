package com.example.f23comp1011movies;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class APIUtility {

    //This method calls the OMBD API with a movie title passed in as an arguement
    public static ApiResponse callAPI(String movieName) throws IOException, InterruptedException {

        //If we received "Star Wars", we need to translate that to be "Star%20Wars"
        movieName = movieName.replaceAll(" ", "%20");


        String uri = "http://www.omdbapi.com/?apikey=37968102&s=" + movieName;
        //Configure the environment to make a HTTP request
        //This includes an update to the module-info.java file
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(uri)).build();


        //This will save a file called movies.json with the API's response
//        HttpResponse<Path> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers
//                                         .ofFile(Paths.get("movies.json")));

         HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers
                                         .ofString());


        Gson gson = new Gson();
        return gson.fromJson(httpResponse.body(), ApiResponse.class);

    }

    public static ApiResponse getMoviesFromFiles(String fileName){

        Gson gson = new Gson();
        //This is called a try...with resources when we use the ().
        //Anything created inside the ( ) will auto have the .close() called once
        //the resource is not required.
        try(
                FileReader fileReader = new FileReader(fileName);
                JsonReader jsonReader = new JsonReader(fileReader);
                )
        {
            return gson.fromJson(jsonReader, ApiResponse.class);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;

    }

}
