package com.example.baris.filmseru.utilities;

import android.net.Uri;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;


public class NetworkUtils {
    private static NetworkUtils ourInstance = new NetworkUtils();

    public static NetworkUtils getInstance() {
        return ourInstance;
    }

    private static final String API_KEY = "4d0f6abd995a05c99c3d2aa624451af7";
    private static final String POPULAR = "movie/popular" ;
    private static final String TOPRATED = "movie/top_rated" ;
    private static final String API_PARAM = "api_key";
    private static final String BASE_LINK = "http://api.themoviedb.org/3";
    private static final  String BASE_LINK_IMAGE = "http://image.tmdb.org/t/p/";
    private static final String IMAGE_SIZE = "w185";

    public static URL buildURL(boolean popular){
        Uri uri = Uri.parse(BASE_LINK + "/" + (popular ? POPULAR : TOPRATED) + "?" + API_PARAM + "=" + API_KEY);
        URL url = null ;
        try {
            url = new URL(uri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url ;
    }

    public static String getResponseFromHTTP(URL url) throws IOException{
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        try{
            InputStream inputStream = conn.getInputStream();

            Scanner scanner = new Scanner(inputStream);
            scanner.useDelimiter("\\A");

                if(scanner.hasNext()){
                    return  scanner.next();
                }else{
                    return null ;
                }
        }finally {
            conn.disconnect();
        }
    }

    public static String getFullLink(String relativePath){
        return  BASE_LINK_IMAGE + IMAGE_SIZE + relativePath ;
    }
}
