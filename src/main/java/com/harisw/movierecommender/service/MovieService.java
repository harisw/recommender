package com.harisw.movierecommender.service;

import com.harisw.movierecommender.dto.MovieResponse;
import com.harisw.movierecommender.model.Movie;
import com.harisw.movierecommender.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MovieService {
    private final MovieRepository movieRepository;
    public MovieResponse get(Integer id) {
        Optional<Movie> queryMovie = movieRepository.findById(id);
        if (!queryMovie.isPresent())
            return null;
        Movie movie = queryMovie.get();
        return MovieResponse.builder()
                .title(movie.getTitle())
                .overview(movie.getOverview())
                .language(movie.getLanguage())
                .popularity(movie.getPopularity())
                .release_date(movie.getRelease_date())
                .vote_avg(movie.getVote_avg())
                .vote_count(movie.getVote_count())
                .production_company(movie.getProduction_company()).build();
    }
}
