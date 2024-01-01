package com.Tienda.gamer.dto.response;

import com.Tienda.gamer.entity.Genero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JuegoSinPlataformaResponseDto {

    private Long idJuego;

    private String titulo;

    private GeneroResponseDto genero;

    private LocalDate lanzamiento;

    private Double stock;

    private Double precio;

}
