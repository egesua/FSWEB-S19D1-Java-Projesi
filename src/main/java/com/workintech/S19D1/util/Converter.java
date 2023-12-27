package com.workintech.S19D1.util;

import com.workintech.S19D1.dto.ActorResponse;
import com.workintech.S19D1.entity.Actor;

import java.util.ArrayList;
import java.util.List;

public class Converter {
    public static List<ActorResponse> actorResponsesConvert(List<Actor> allActors){
        List<ActorResponse> actors = new ArrayList<>();
        for (Actor actor : allActors){
            actors.add(new ActorResponse(actor.getId(), actor.getFirstName(), actor.getLastName(), actor.getBirthDate()));
        }
        return actors;
    }

    public static ActorResponse actorResponseConvert(Actor actor){
        return new ActorResponse(actor.getId(), actor.getFirstName(), actor.getLastName(), actor.getBirthDate());
    }
}
