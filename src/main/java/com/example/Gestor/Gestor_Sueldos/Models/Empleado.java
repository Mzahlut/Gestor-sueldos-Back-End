package com.example.Gestor.Gestor_Sueldos.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String cuil;
    private String categoria;
    private BigDecimal sueldoBase;
    @Column(name = "fecha_ingreso")
    private LocalDate fechaIngreso;


    @OneToMany(mappedBy = "empleado")
    private List<Liquidacion> liquidaciones;


}
