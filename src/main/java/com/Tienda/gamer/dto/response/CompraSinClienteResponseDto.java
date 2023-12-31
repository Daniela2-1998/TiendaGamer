package com.Tienda.gamer.dto.response;

import com.Tienda.gamer.entity.MedioDePago;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraSinClienteResponseDto {

    private Long idCompra;

    private LocalDate fechaCompra;

    private List<JuegoResponseDto> juegos;

    private MedioDePago medioDePago;


}
