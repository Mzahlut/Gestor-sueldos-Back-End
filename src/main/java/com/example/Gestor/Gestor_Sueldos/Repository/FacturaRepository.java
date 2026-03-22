package com.example.Gestor.Gestor_Sueldos.Repository;

import com.example.Gestor.Gestor_Sueldos.Models.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
