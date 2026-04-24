package com.example.aplicacion_cine.entities;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "peliculas")
public class Pelicula {

    @Id
    @NotBlank(message = "Debe insertar un código de pelicula (Abreviación + Año de Lanzamiento.)")
    private String codPelicula; //Corresponde a un codigo de la abreviación + año de lanzamiento

    @NotBlank(message = "Debe insertar un nombre para la pelicula.")
    private String nombre;

    @NotBlank(message = "Debe insertar una abreviación valida.")
    private String nombreAbreviado;

    //@Min(value = 0, message = "La edad mínima no puede ser negativa.")
    @NotNull(message = "Debe ingresar una edad minima.")
    private Integer edadMinima;

    @NotBlank(message = "Debe ingresar el genero de la pelicula.")
    private String genero;

}
