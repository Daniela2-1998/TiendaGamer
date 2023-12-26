package com.Tienda.gamer.dto.response;

import com.Tienda.gamer.entity.Cliente;
import com.Tienda.gamer.entity.Juego;
import com.Tienda.gamer.entity.MedioDePago;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraResponseDto {

    private Long idCompra;

    private LocalDate fechaCompra;

    private List<JuegoResponseDto> juegos;

    private ClienteSinCompraResponseDto cliente;

    private MedioDePago medioDePago;


}
