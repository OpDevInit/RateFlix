package com.opdevinit.rateflix.connectAPI;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opdevinit.rateflix.entity.MovieData;
import com.opdevinit.rateflix.entity.MovieListData;

@Service
public class APIController {

    public HttpResponse<String> getMovieData(String paramURL) {

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://www.omdbapi.com/?" + paramURL))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public MovieData setMovie(String name) throws JsonMappingException, JsonProcessingException {
        String response = getMovieData("t=" + name + "&plot=full&apikey=7f74f740").body();
        ObjectMapper mapper = new ObjectMapper();
        MovieData movie = mapper.readValue(response, MovieData.class);
        System.out.println("\n\n\n\n" + movie);
        return movie;
    }

    public MovieListData setListMovies(String name, int pages) throws JsonMappingException, JsonProcessingException {
        String response = getMovieData("s=" + name + "&page=" + pages + "&apikey=7f74f740").body();
        ObjectMapper mapper = new ObjectMapper();
        MovieListData listMovie = mapper.readValue(response, MovieListData.class);
        return listMovie;
    }

}
