package com.harisw.movierecommender.repository;

import com.harisw.movierecommender.model.Language;
import com.harisw.movierecommender.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    Page<Movie> findAll(Pageable pageable);
    Page<Movie> findByLanguage(Language language, Pageable pageable);
}
