package com.example.aplicacion_cine.repositories;

import com.example.aplicacion_cine.entities.Pelicula;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PeliculasRepository extends MongoRepository<Pelicula, String> {
    List<Pelicula> findByEdadMinimaLessThanEqual(int edadMinimaIsLessThan);

    List<Pelicula> findByEdadMinimaBetween(int edadMinimaAfter, int edadMinimaBefore);

    List<Pelicula> findByEdadMinimaGreaterThanEqual(int edadMinimaIsGreaterThan);
}
