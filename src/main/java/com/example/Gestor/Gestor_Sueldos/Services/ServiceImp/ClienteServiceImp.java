package com.example.Gestor.Gestor_Sueldos.Services.ServiceImp;

import com.example.Gestor.Gestor_Sueldos.Models.Cliente;
import com.example.Gestor.Gestor_Sueldos.Repository.ClienteRepository;
import com.example.Gestor.Gestor_Sueldos.Services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImp implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente obtenerClientePorId(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }


    @Override
    public List<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }


    @Override
    public Cliente actualizarCliente(Long id, Cliente cliente) {
        Cliente existente = obtenerClientePorId(id);
        existente.setNombre(cliente.getNombre());
        existente.setEmail(cliente.getEmail());
        // agrega aquí otros campos que quieras actualizar
        return clienteRepository.save(existente);
    }


    @Override
    public void eliminarCliente(Long id) {
        clienteRepository.deleteById(id);
    }

}
