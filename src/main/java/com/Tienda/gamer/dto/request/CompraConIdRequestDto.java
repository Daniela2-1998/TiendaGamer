package com.Tienda.gamer.dto.request;

import com.Tienda.gamer.entity.Cliente;
import com.Tienda.gamer.entity.Juego;
import com.Tienda.gamer.entity.MedioDePago;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraConIdRequestDto {

    @NotNull(message = "El campo Id no debe ser nulo.")
    private Long idCompra;

    @PastOrPresent
    private LocalDate fechaCompra;

    private List<Juego> juegos;

    @NotNull(message = "Debe haber un cliente.")
    private Cliente cliente;

    @NotNull(message = "Debe haber un medio de pago.")
    private MedioDePago medioDePago;



}
