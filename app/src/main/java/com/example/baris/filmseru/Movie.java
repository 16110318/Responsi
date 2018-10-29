package com.example.baris.filmseru;

import com.example.baris.filmseru.utilities.NetworkUtils;

/**
 * Created by baris on 08.01.2017.
 */

public class Movie {
    String title , posterImageLink , synopsis , rating, releaseDate ;

    public Movie(String _title, String _posterImage , String _synopsis ,String _rating , String _releaseDate){
        title = _title ;
        posterImageLink = NetworkUtils.getFullLink(_posterImage);
        synopsis = _synopsis ;
        rating = _rating ;
        releaseDate = _releaseDate ;
    }


}
