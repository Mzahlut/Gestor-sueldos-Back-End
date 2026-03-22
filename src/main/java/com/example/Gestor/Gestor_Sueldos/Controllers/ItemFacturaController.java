package com.example.Gestor.Gestor_Sueldos.Controllers;

import com.example.Gestor.Gestor_Sueldos.Models.ItemFactura;
import com.example.Gestor.Gestor_Sueldos.Repository.ItemFacturaRepository;
import com.example.Gestor.Gestor_Sueldos.Repository.FacturaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/items")
public class ItemFacturaController {

    private final ItemFacturaRepository itemFacturaRepository;
    private final FacturaRepository facturaRepository;

    public ItemFacturaController(ItemFacturaRepository itemFacturaRepository, FacturaRepository facturaRepository) {
        this.itemFacturaRepository = itemFacturaRepository;
        this.facturaRepository = facturaRepository;
    }

    // Listar todos los ítems
    @GetMapping
    public List<ItemFactura> listar() {
        return itemFacturaRepository.findAll();
    }

    // Obtener ítem por ID
    @GetMapping("/{id}")
    public ResponseEntity<ItemFactura> obtener(@PathVariable Long id) {
        return itemFacturaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Crear ítem asociado a una factura
    @PostMapping("/factura/{facturaId}")
    public ResponseEntity<ItemFactura> crear(@PathVariable Long facturaId, @RequestBody ItemFactura item) {
        return facturaRepository.findById(facturaId)
                .map(factura -> {
                    item.setFactura(factura);
                    return ResponseEntity.ok(itemFacturaRepository.save(item));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Actualizar ítem
    @PutMapping("/{id}")
    public ResponseEntity<ItemFactura> actualizar(@PathVariable Long id, @RequestBody ItemFactura item) {
        return itemFacturaRepository.findById(id)
                .map(i -> {
                    i.setDescripcion(item.getDescripcion());
                    i.setCantidad(item.getCantidad());
                    i.setPrecioUnitario(item.getPrecioUnitario());
                    return ResponseEntity.ok(itemFacturaRepository.save(i));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Eliminar ítem
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> eliminar(@PathVariable Long id) {
        return itemFacturaRepository.findById(id)
                .map(i -> {
                    itemFacturaRepository.delete(i);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}