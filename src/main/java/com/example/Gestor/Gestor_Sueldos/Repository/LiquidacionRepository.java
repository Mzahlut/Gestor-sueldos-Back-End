package com.example.Gestor.Gestor_Sueldos.Repository;

import com.example.Gestor.Gestor_Sueldos.Models.Liquidacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LiquidacionRepository extends JpaRepository<Liquidacion, Long> {

    List<Liquidacion> findByEmpleadoId(Long empleadoId);

}
