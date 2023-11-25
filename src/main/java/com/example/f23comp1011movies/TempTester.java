package com.example.f23comp1011movies;

import java.io.IOException;

public class TempTester {

    public static void main(String[] args) throws IOException, InterruptedException {

        try{

            ApiResponse apiResponse = APIUtility.getMoviesFromFiles("movies.json");

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
