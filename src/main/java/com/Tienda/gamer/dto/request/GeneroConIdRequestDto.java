package com.Tienda.gamer.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GeneroConIdRequestDto {

    @NotNull(message = "El campo Id no debe ser nulo.")
    private Long id;

    @NotNull(message = "Es necesario que el género tenga nombre.")
    private String nombre;

}
