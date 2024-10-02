package com.opdevinit.rateflix.controller;

import org.springframework.web.bind.annotation.RestController;
import com.opdevinit.rateflix.connectAPI.APIController;
import com.opdevinit.rateflix.entity.MovieData;
import com.opdevinit.rateflix.entity.MovieListData;
import java.io.IOException;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class MovieController {

    private APIController controller = new APIController();

    @GetMapping(value = "/{name}")
    public ResponseEntity<MovieData> getMovie(@PathVariable String name) throws IOException, InterruptedException {

        MovieData searchMovie = controller.setMovie(name);
        return ResponseEntity.ok(searchMovie);
    }

    @GetMapping(value = "/list/{name}/{pages}")
    public ResponseEntity<List<MovieListData>> getListMovie(@PathVariable String name, @PathVariable int pages) throws IOException, InterruptedException {

        MovieListData listData = controller.setListMovies(name, pages);
        return ResponseEntity.ok(List.of(listData));
    }

}
