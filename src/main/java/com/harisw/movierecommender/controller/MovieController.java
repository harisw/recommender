package com.harisw.movierecommender.controller;

import com.harisw.movierecommender.dto.MovieResponse;
import com.harisw.movierecommender.model.Movie;
import com.harisw.movierecommender.service.MovieService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Tag(name="Movie", description = "Movie Endpoints")
@RestController
@RequestMapping("/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;

    @Operation(
            summary = "Retrieve a Movie by Id",
            description = "Get a Movie object by specifying its id. The response is Tutorial object with id, title, description and published status.",
            tags = { "Movie" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = Movie.class), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
            @ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
    @GetMapping("/{movie_id}")
    @ResponseStatus(HttpStatus.OK)
    public MovieResponse getMovie(@PathVariable("movie_id") Integer movie_id) {
        return movieService.get(movie_id);
    }
}
