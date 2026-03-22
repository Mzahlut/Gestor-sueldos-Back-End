package com.example.Gestor.Gestor_Sueldos.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Liquidacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate periodo;
    private Double sueldoBruto;
    private Double descuentos;
    private Double sueldoNeto;

    @ManyToOne
    private Empleado empleado;


}
