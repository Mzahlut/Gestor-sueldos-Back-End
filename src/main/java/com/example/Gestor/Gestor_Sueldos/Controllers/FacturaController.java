package com.example.Gestor.Gestor_Sueldos.Controllers;

import com.example.Gestor.Gestor_Sueldos.Models.Factura;
import com.example.Gestor.Gestor_Sueldos.Services.FacturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping
    public List<Factura> listar() {
        return facturaService.listarFacturas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Factura> obtener(@PathVariable Long id) {
        Factura factura = facturaService.obtenerFacturaPorId(id);
        return ResponseEntity.ok(factura);
    }

    @PostMapping
    public Factura crear(@RequestBody Factura factura) {
        return facturaService.crearFactura(factura);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Factura> actualizar(@PathVariable Long id, @RequestBody Factura factura) {
        Factura actualizada = facturaService.actualizarFactura(id, factura);
        return ResponseEntity.ok(actualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable Long id) {
        facturaService.eliminarFactura(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}/total")
    public BigDecimal obtenerTotal(@PathVariable Long id) {
        return facturaService.calcularTotal(id);
    }
}

