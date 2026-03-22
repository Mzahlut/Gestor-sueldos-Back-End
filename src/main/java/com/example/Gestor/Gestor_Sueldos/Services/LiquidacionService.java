package com.example.Gestor.Gestor_Sueldos.Services;

import com.example.Gestor.Gestor_Sueldos.Models.Liquidacion;

import java.util.List;

public interface LiquidacionService {
    Liquidacion crearLiquidacion(Liquidacion liquidacion);
    Liquidacion obtenerLiquidacionPorId(Long id);
    List<Liquidacion> listarLiquidaciones();
    List<Liquidacion> listarPorEmpleado(Long empleadoId);
    Liquidacion actualizarLiquidacion(Long id, Liquidacion liquidacion);
    void eliminarLiquidacion(Long id);
}

