package com.example.Gestor.Gestor_Sueldos.Repository;

import com.example.Gestor.Gestor_Sueldos.Models.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}
