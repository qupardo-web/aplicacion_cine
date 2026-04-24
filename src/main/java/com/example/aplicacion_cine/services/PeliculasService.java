package com.example.aplicacion_cine.services;

import com.example.aplicacion_cine.entities.Pelicula;

import java.util.List;
import java.util.Optional;

public interface PeliculasService {
    Pelicula createPelicula(Pelicula pelicula);
    List<Pelicula> getAll();
    List<Pelicula> getPeliculasPorLimite(String limite);
    List<Pelicula> filtrarPeliculas(String genero, String nombre);
}
