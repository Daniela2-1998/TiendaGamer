package com.Tienda.gamer.service;

import com.Tienda.gamer.dto.request.ClienteConIdRequestDto;
import com.Tienda.gamer.dto.request.ClienteRequestDto;
import com.Tienda.gamer.dto.response.ClienteResponseDto;
import com.Tienda.gamer.dto.response.MensajeResponseDto;
import com.Tienda.gamer.entity.Cliente;
import com.Tienda.gamer.exception.EntityAlreadyExistException;
import com.Tienda.gamer.exception.EntityNotFoundException;
import com.Tienda.gamer.exception.InsertionDBException;
import com.Tienda.gamer.repository.IClienteRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImp implements IClienteService{

    IClienteRepository clienteRepository;

    ModelMapper mapper;

    // ------------------------------------------    CONSTRUCTOR    ---------------------------------------------------
    public ClienteServiceImp(IClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
        mapper = new ModelMapper();
    }

    // --------------------------------------------    MÉTODOS    -----------------------------------------------------

    // OBTENER CLIENTES
    @Override
    public List<ClienteResponseDto> obtenerClientes() {
        List<Cliente> responseEntity = clienteRepository.findAll();
        if(responseEntity.isEmpty()){
            throw new EntityNotFoundException("No hay clientes registrados en el sistema.");
        }
            List<ClienteResponseDto> response = new ArrayList<>();
            responseEntity.stream().forEach(resp -> response.add(mapper.map(resp, ClienteResponseDto.class)));
        return response;
    }

    // OBTENER CLIENTE POR ID
    @Override
    public ClienteResponseDto obtenerClienteById(long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if(cliente.isEmpty()){
            throw new EntityNotFoundException("No hay clientes registrados");
        }
        return mapper.map(cliente, ClienteResponseDto.class);
    }

    // AGREGAR CLIENTE
    @Override
    public ClienteResponseDto agregarCliente(ClienteRequestDto clienteRequestDto) {
        // Verificaciones de que no se repitan DNI ni Mail en clientes.
        if(clienteRepository.findByDni(clienteRequestDto.getDni()) != null){
            throw new EntityAlreadyExistException("Ya hay un cliente con ese DNI.");
        }
        if(clienteRepository.findByMail(clienteRequestDto.getMail()) != null){
            throw new EntityAlreadyExistException("Ya hay un cliente con ese mail.");
        }

        Cliente cliente = mapper.map(clienteRequestDto, Cliente.class);
        Cliente persistCliente = clienteRepository.save(cliente);
        if(cliente == null){
            throw new InsertionDBException("Error al guardar el cliente en la base de datos.");
        }

        return mapper.map(persistCliente, ClienteResponseDto.class);
    }

    @Override
    public ClienteResponseDto editarCliente(ClienteConIdRequestDto clienteConIdRequestDto) {
        Cliente cliente = clienteRepository.findByDni(clienteConIdRequestDto.getDni());
        if(cliente != null && cliente.getIdCliente() != clienteConIdRequestDto.getIdCliente()){
            throw new EntityAlreadyExistException("Ya hay otro cliente registrado con ese DNI.");
        }
        cliente = clienteRepository.findByMail(clienteConIdRequestDto.getMail());
        if(cliente != null && cliente.getMail() != clienteConIdRequestDto.getMail()){
            throw new EntityAlreadyExistException("Ya hay otro cliente registrado con ese mail.");
        }

        obtenerClienteById(clienteConIdRequestDto.getIdCliente());
        cliente = mapper.map(clienteConIdRequestDto, Cliente.class);
        Cliente persistCliente = clienteRepository.save(cliente);

        return mapper.map(persistCliente, ClienteResponseDto.class);
    }

    @Override
    public MensajeResponseDto eliminarCliente(long id) {
        obtenerClienteById(id);
        clienteRepository.deleteById(id);

        return new MensajeResponseDto("Se eliminó exitosamente al usuario solicitado.");
    }
}
