package com.example.Gestor.Gestor_Sueldos.Services.ServiceImp;


import com.example.Gestor.Gestor_Sueldos.Models.Empleado;
import com.example.Gestor.Gestor_Sueldos.Repository.EmpleadoRepository;
import com.example.Gestor.Gestor_Sueldos.Services.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Service
public class EmpleadoServiceImp implements EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Override
    public Empleado crearEmpleado(Empleado empleado) {
        if (empleado.getSueldoBase() == null || empleado.getSueldoBase().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("El salario base debe ser mayor a cero");
        }
        if(empleado.getFechaIngreso() == null){
            empleado.setFechaIngreso(LocalDate.now());
        }

        return empleadoRepository.save(empleado);
    }

    @Override
    public Empleado obtenerEmpleadoPorId(Long id) {
        return empleadoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));
    }

    @Override
    public List<Empleado> listarEmpleados() {
        return empleadoRepository.findAll();
    }

    @Override
    public Empleado actualizarEmpleado(Long id, Empleado empleado) {
        Empleado existente = obtenerEmpleadoPorId(id);
        existente.setNombre(empleado.getNombre());
        existente.setCuil(empleado.getCuil());
        existente.setSueldoBase(empleado.getSueldoBase());
        existente.setFechaIngreso(empleado.getFechaIngreso());
        return empleadoRepository.save(existente);
    }

    @Override
    public void eliminarEmpleado(Long id) {
        empleadoRepository.deleteById(id);
    }
}

