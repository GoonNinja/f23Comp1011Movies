package com.example.f23comp1011movies;

import java.io.IOException;

public class TempTester {

    public static void main(String[] args) throws IOException, InterruptedException {

        try{
            APIUtility.callAPI("Titanic");
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
