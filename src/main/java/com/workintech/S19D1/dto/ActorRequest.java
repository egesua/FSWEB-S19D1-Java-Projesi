package com.workintech.S19D1.dto;

import com.workintech.S19D1.entity.Actor;
import com.workintech.S19D1.entity.Movie;
import lombok.Data;

import java.util.List;

@Data
public class ActorRequest {

    private List<Movie> movies;
    private Actor actor;

}
