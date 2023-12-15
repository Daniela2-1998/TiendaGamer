package com.Tienda.gamer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @OneToMany(mappedBy = "compra", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private List<Juego> juego;

    @OneToOne(mappedBy = "compra", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Cliente cliente;

    @OneToOne(mappedBy = "compra", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private MedioDePago medioDePago;

}
