package com.harisw.movierecommender.dto;

import com.harisw.movierecommender.model.Language;
import com.harisw.movierecommender.model.ProductionCompany;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponse {
    private Integer id;
    private String title;
    private String overview;
    private Language language;
    private Float popularity;
    private Date release_date;
    private Float vote_avg;
    private Integer vote_count;
    private ProductionCompany production_company;
}
