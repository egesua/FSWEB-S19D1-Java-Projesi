package com.workintech.S19D1.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.ArrayList;
import java.util.List;

@Data
    @NoArgsConstructor
    @Entity
    @Table(name = "actor", schema = "fsweb")
    public class Actor {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private Long id;

        @Column(name = "first_name")
        @NotNull
        private String firstName;

        @Column(name = "last_name")
        @NotNull
        private String lastName;

        @Column(name = "gender")
        @Enumerated(EnumType.STRING)
        private Gender gender;

        @Column(name = "birth_date")
        @NotNull
        private String birthDate;

        @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
        @JoinTable(name = "movie_actor", schema = "fsweb",
                joinColumns = @JoinColumn(name = "actor_id"),
                inverseJoinColumns = @JoinColumn(name = "movie_id"))
        private List<Movie> movies;

        public void addMovie(Movie movie){
            if(movies == null) {
                movies = new ArrayList<>();
            }
            movies.add(movie);
        }
}
