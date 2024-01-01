package com.Tienda.gamer.dto.request;

import com.Tienda.gamer.dto.response.GeneroResponseDto;
import com.Tienda.gamer.dto.response.PlataformaResponseDto;
import com.Tienda.gamer.entity.Genero;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JuegoRequestDto {

    @NotNull(message = "El campo título no puede ser nulo.")
    @NotEmpty(message = "El campo título no puede estar vacío.")
    private String titulo;

    @NotNull(message = "El campo plataforma no puede ser nulo.")
    private PlataformaResponseDto plataforma;

    private GeneroResponseDto genero;

    @NotNull(message = "El campo fecha de lanzamiento no puede ser nulo.")
    private LocalDate lanzamiento;

    @PositiveOrZero
    @NotNull(message = "El campo stock no puede ser nulo.")
    private Integer stock;

    @Positive(message = "El precio del producto no puede ser negativo o de valor 0.")
    private Double precio;

}
