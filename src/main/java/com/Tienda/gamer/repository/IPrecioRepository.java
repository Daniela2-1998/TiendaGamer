package com.Tienda.gamer.repository;

import com.Tienda.gamer.entity.Precio;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IPrecioRepository extends JpaRepository<Precio,Long> {

    Precio findById(long id);

    List<Precio> findByPrecio(double precio);


}
