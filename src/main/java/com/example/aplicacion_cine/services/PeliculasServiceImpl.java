package com.example.aplicacion_cine.services;

import com.example.aplicacion_cine.entities.Pelicula;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.aplicacion_cine.repositories.PeliculasRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PeliculasServiceImpl implements PeliculasService{

    @Autowired
    PeliculasRepository peliculasRepository;

    @Override
    public Pelicula createPelicula(Pelicula pelicula){
        try {
            return this.peliculasRepository.insert(pelicula);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Pelicula> getAll(){
        return this.peliculasRepository.findAll();
    }

    @Override
    public List<Pelicula> getPeliculasPorLimite(String limite){

        return switch(limite.toLowerCase()){
            case("menor_edad")->
                peliculasRepository.findByEdadMinimaLessThanEqual(15);
            case("adolescentes")->
                peliculasRepository.findByEdadMinimaBetween(15,18);
            case("mayor") ->
                peliculasRepository.findByEdadMinimaGreaterThanEqual(18);
            default ->
                Collections.emptyList();
        };
    }

    @Override
    public List<Pelicula> filtrarPeliculas(String genero, String nombre){
        if(genero != null && nombre !=null){
            return peliculasRepository.findByGeneroAndNombreContainingIgnoreCase(genero, nombre);
        }else if (genero != null) {
            return peliculasRepository.findByGeneroIgnoreCase(genero);
        }else if (nombre != null){
            return peliculasRepository.findByNombreContainingIgnoreCase(nombre);
        }
        return peliculasRepository.findAll();
    }
}
