package com.Tienda.gamer.repository;

import com.Tienda.gamer.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IClienteRepository  extends JpaRepository<Cliente,Long> {

    // MÉTODOS / Cada nombre representa y lleva el nombre de una variable declarada en Entity

    Cliente findByNombreAndApellido(String nombre, String apellido);

    Cliente findByDni(String dni);

    Cliente findByMail(String mail);

    List<Cliente> findByFechaRegistro(LocalDate date);

}
