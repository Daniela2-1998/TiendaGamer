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
@Table(name = "medios_de_pago")
public class MedioDePago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedioDePago;

    private String medio;

    private Integer cuotasDisponibles;

    //@OneToOne(mappedBy = "medioDePago")
    //private Compra compra;

}
