package com.Tienda.gamer.dto.response;

import com.Tienda.gamer.entity.Genero;
import com.Tienda.gamer.entity.Plataforma;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JuegoResponseDto {

    private Long idJuego;

    private String titulo;

    private PlataformaResponseDto plataforma;

    private GeneroResponseDto genero;

    private LocalDate lanzamiento;

    private Double stock;

    private Double precio;

}
