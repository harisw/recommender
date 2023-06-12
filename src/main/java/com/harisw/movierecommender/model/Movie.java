package com.harisw.movierecommender.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "movies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String overview;
    @ManyToOne
    @JoinColumn(name = "language_id", referencedColumnName = "id")
    private Language language;
    private Float popularity;
    private Date release_date;
    private Float vote_avg;
    private Integer vote_count;
    @ManyToOne
    @JoinColumn(name = "production_company_id", referencedColumnName = "id")
    private ProductionCompany production_company;
}
