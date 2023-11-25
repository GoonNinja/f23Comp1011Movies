package com.example.f23comp1011movies;

import java.io.IOException;

public interface MovieLoader {

    public void loadMovie(String imdbID) throws IOException, InterruptedException;
}
