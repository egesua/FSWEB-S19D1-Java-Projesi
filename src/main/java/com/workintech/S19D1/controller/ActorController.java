package com.workintech.S19D1.controller;

import com.workintech.S19D1.dto.ActorResponse;
import com.workintech.S19D1.dto.ActorRequest;
import com.workintech.S19D1.entity.Actor;
import com.workintech.S19D1.entity.Movie;
import com.workintech.S19D1.service.ActorService;
import com.workintech.S19D1.util.Converter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/actor")
@Slf4j

public class ActorController {

    private final ActorService actorService;
    @GetMapping
    public List<ActorResponse> findAll(){
        List<Actor> allActors = actorService.findAll();
        List<ActorResponse> actors = new ArrayList<>();

        for (Actor actor : allActors){
            actors.add(new ActorResponse(actor.getId(), actor.getFirstName(), actor.getLastName(), actor.getBirthDate()));
        }
        return actors;
    }

    @GetMapping("/{id}")
    private ActorResponse findById(@PathVariable Long id){
         return Converter.actorResponseConvert(actorService.findById(id));
    }

    @PostMapping
    public void save(@RequestBody ActorRequest actorRequest) {
        List<Movie> movies = actorRequest.getMovies();
        Actor actor = actorRequest.getActor();
        for (Movie movie : movies) {
            actor.addMovie(movie);
        }
        actorService.save(actor);
    }
}
