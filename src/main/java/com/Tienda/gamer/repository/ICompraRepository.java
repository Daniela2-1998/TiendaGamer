package com.Tienda.gamer.repository;

import com.Tienda.gamer.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ICompraRepository extends JpaRepository<Compra,Long> {

    Compra findById (long id);

    List<Compra> findByFechaVenta(LocalDate date);

    List<Compra> findByCliente(Cliente cliente);

    List<Compra> findByJuego(Juego juego);

    List<Compra> findByMedioDePago(MedioDePago medioDePago);

    List<Compra> findByPrecio(Precio precio);

}
