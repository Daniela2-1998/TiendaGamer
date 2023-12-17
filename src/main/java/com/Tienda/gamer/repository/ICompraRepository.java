package com.Tienda.gamer.repository;

import com.Tienda.gamer.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ICompraRepository extends JpaRepository<Compra,Long> {

    Compra findById (long id);

    List<Compra> findByFechaCompra(LocalDate date);

    List<Compra> findByCliente(Cliente cliente);

    List<Compra> findByJuegos(Juego juego);

    List<Compra> findByMedioDePago(MedioDePago medioDePago);

}
