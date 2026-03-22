package com.example.Gestor.Gestor_Sueldos.Controllers;


import com.example.Gestor.Gestor_Sueldos.Models.Liquidacion;
import com.example.Gestor.Gestor_Sueldos.Services.LiquidacionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/liquidaciones")
public class LiquidacionController {

    private final LiquidacionService liquidacionService;

    public LiquidacionController(LiquidacionService liquidacionService) {
        this.liquidacionService = liquidacionService;
    }

    // Listar todas las liquidaciones
    @GetMapping
    public List<Liquidacion> listar() {
        return liquidacionService.listarLiquidaciones();
    }

    // Obtener liquidación por ID
    @GetMapping("/{id}")
    public ResponseEntity<Liquidacion> obtener(@PathVariable Long id) {
        Liquidacion liquidacion = liquidacionService.obtenerLiquidacionPorId(id);
        return (liquidacion != null) ? ResponseEntity.ok(liquidacion) : ResponseEntity.notFound().build();
    }

    // Crear liquidación
    @PostMapping
    public ResponseEntity<Liquidacion> crear(@RequestBody Liquidacion liquidacion) {
        Liquidacion nueva = liquidacionService.crearLiquidacion(liquidacion);
        return ResponseEntity.ok(nueva);
    }

    // Listar liquidaciones por empleado
    @GetMapping("/empleado/{empleadoId}")
    public List<Liquidacion> listarPorEmpleado(@PathVariable Long empleadoId) {
        return liquidacionService.listarPorEmpleado(empleadoId);
    }

    // Actualizar liquidación
    @PutMapping("/{id}")
    public ResponseEntity<Liquidacion> actualizar(@PathVariable Long id, @RequestBody Liquidacion liquidacion) {
        Liquidacion actualizada = liquidacionService.actualizarLiquidacion(id, liquidacion);
        return (actualizada != null) ? ResponseEntity.ok(actualizada) : ResponseEntity.notFound().build();
    }

    // Eliminar liquidación
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        liquidacionService.eliminarLiquidacion(id);
        return ResponseEntity.noContent().build();
    }
}
