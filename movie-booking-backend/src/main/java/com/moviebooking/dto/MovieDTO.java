package com.moviebooking.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDTO {

    private Long id;
    private String title;
    private String genre;
    private Integer duration;
    private Double rating;
    private String posterUrl;
    private String description;
}
