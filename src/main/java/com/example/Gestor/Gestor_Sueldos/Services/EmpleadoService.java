package com.example.Gestor.Gestor_Sueldos.Services;

import com.example.Gestor.Gestor_Sueldos.Models.Empleado;

import java.util.List;

public interface EmpleadoService {
    Empleado crearEmpleado(Empleado empleado);
    Empleado obtenerEmpleadoPorId(Long id);
    List<Empleado> listarEmpleados();
    Empleado actualizarEmpleado(Long id, Empleado empleado);
    void eliminarEmpleado(Long id);
}

