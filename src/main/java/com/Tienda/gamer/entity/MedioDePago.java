package com.Tienda.gamer.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "mediosDePago")
public class MedioDePago {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedioDePago;

    private String medio;

}
