package com.example.aplicacion_cine.controllers;

import com.example.aplicacion_cine.entities.Pelicula;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.aplicacion_cine.services.PeliculasService;

import java.util.List;

@RestController
public class PeliculasController {

    @Autowired
    private PeliculasService peliculasService;

    @GetMapping("/verPeliculas")
    public ResponseEntity<List<Pelicula>> getAll(){
        try{
            List<Pelicula> peliculas = this.peliculasService.getAll();
            return ResponseEntity.ok(peliculas);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/crearPelicula")
    public ResponseEntity<?> createPelicula(@RequestBody @Valid Pelicula pelicula){

        Pelicula peli = this.peliculasService.createPelicula(pelicula);

        if (peli != null){
            return ResponseEntity.ok(peli);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/peliculas/{limite}")
    public ResponseEntity<List<Pelicula>> getPeliculasPorLimite(@PathVariable String limite){
        try{
            List<Pelicula> peliculas = this.peliculasService.getPeliculasPorLimite(limite);
            return ResponseEntity.ok(peliculas);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Pelicula>> getPeliculas(
            @RequestParam(required = false) String genero,
            @RequestParam(required = false) String nombre){
        try{
            List<Pelicula> peliculas = this.peliculasService.filtrarPeliculas(genero, nombre);
            return ResponseEntity.ok(peliculas);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

}
