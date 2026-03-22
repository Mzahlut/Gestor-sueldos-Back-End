package com.example.Gestor.Gestor_Sueldos.Services;


import com.example.Gestor.Gestor_Sueldos.Models.Cliente;

import java.util.List;

public interface ClienteService {
    Cliente crearCliente(Cliente cliente);
    Cliente obtenerClientePorId(Long id);
    List<Cliente> listarClientes();
    Cliente actualizarCliente(Long id, Cliente cliente);
    void eliminarCliente(Long id);
}

