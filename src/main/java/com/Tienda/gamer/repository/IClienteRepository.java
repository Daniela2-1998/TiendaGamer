package com.Tienda.gamer.repository;

import com.Tienda.gamer.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface IClienteRepository  extends JpaRepository<Cliente,Long> {

    Cliente findByNombreCompleto(String nombre, String apellido);

    Cliente findByDni(String dni);

    Cliente findByMAail(String mail);

    List<Cliente> findByFechaRegistro(LocalDate date);

}
