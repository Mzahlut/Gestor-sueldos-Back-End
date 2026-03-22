package com.example.Gestor.Gestor_Sueldos.Services;

import com.example.Gestor.Gestor_Sueldos.Models.Factura;

import java.math.BigDecimal;
import java.util.List;

public interface FacturaService {
    Factura crearFactura(Factura factura);
    Factura obtenerFacturaPorId(Long id);
    List<Factura> listarFacturas();
    Factura actualizarFactura(Long id, Factura factura);
    void eliminarFactura(Long id);
    BigDecimal calcularTotal(Long idFactura);
}