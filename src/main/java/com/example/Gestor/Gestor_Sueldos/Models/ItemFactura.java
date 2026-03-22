package com.example.Gestor.Gestor_Sueldos.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;
    private Integer cantidad;
    private BigDecimal precioUnitario;

    @ManyToOne
    @JoinColumn(name = "factura_id") // clave foránea en la tabla ItemFactura
    private Factura factura;




}
