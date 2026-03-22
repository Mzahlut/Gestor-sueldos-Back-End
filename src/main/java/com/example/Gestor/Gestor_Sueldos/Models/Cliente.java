package com.example.Gestor.Gestor_Sueldos.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String cuit;
    private String direccion;
    private String email;
    private String telefono;

    @OneToMany(mappedBy = "cliente")
    private List<Factura> facturas;



}
