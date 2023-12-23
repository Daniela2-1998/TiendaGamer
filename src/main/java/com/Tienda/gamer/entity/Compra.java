package com.Tienda.gamer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "compras")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompra;

    private LocalDate fechaCompra;

    @OneToMany
    //@JoinColumn(name = "juego_id", nullable = false)
    private List<Juego> juegos;

    @OneToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @OneToOne
    @JoinColumn(name = "medio_de_pago_id", nullable = false)
    private MedioDePago medioDePago;


}
