package com.workintech.S19D1.service;

import com.workintech.S19D1.entity.Actor;
import com.workintech.S19D1.exceptions.ApiException;
import com.workintech.S19D1.repository.ActorRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ActorServiceImpl implements ActorService{

    private final ActorRepository actorRepository;

    @Override
    public List<Actor> findAll() {
        return actorRepository.findAll();
    }

    @Override
    public Actor findById(Long id) {
        Optional<Actor> foundActor = actorRepository.findById(id);
        if(foundActor.isPresent()){
            return foundActor.get();
        }
        throw new ApiException("Actor is not found with id: " +id, HttpStatus.NOT_FOUND);
    }

    @Override
    public Actor save(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public void delete(Actor actor) {
        actorRepository.delete(actor);
    }
}
