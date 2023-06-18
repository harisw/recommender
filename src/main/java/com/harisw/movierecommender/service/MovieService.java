package com.harisw.movierecommender.service;

import com.harisw.movierecommender.dto.MovieResponse;
import com.harisw.movierecommender.model.Movie;
import com.harisw.movierecommender.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
        return mapToMovieResponse(movie);
    }

    public List<MovieResponse> get(Integer offset, Integer pageSize) {
        List<Movie> movies = new ArrayList<Movie>();
        Pageable paging = PageRequest.of(offset, pageSize);

        Page<Movie> pageMovies = movieRepository.findAll(paging);
        movies = pageMovies.getContent();

        return movies.stream().map(this::mapToMovieResponse).toList();
    }

    private MovieResponse mapToMovieResponse(Movie movie) {
        return MovieResponse.builder()
                .id(movie.getId())
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
