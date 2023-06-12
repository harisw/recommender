package com.harisw.movierecommender.controller;

import com.harisw.movierecommender.dto.MovieResponse;
import com.harisw.movierecommender.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @GetMapping("/{movie_id}")
    @ResponseStatus(HttpStatus.OK)
    public MovieResponse getMovie(@PathVariable("movie_id") Integer movie_id) {
        return movieService.get(movie_id);
    }
}
