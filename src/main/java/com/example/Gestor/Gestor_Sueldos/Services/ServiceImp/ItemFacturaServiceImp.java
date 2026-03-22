package com.example.Gestor.Gestor_Sueldos.Services.ServiceImp;

import com.example.Gestor.Gestor_Sueldos.Models.ItemFactura;
import com.example.Gestor.Gestor_Sueldos.Repository.ItemFacturaRepository;
import com.example.Gestor.Gestor_Sueldos.Services.ItemFacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ItemFacturaServiceImp implements ItemFacturaService {

    @Autowired
    private ItemFacturaRepository itemFacturaRepository;

    @Override
    public ItemFactura crearItem(ItemFactura item) {
        if (item.getCantidad() <= 0) {
            throw new RuntimeException("La cantidad debe ser mayor a cero");
        }
        if (item.getPrecioUnitario() == null || item.getPrecioUnitario().compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("El precio debe ser mayor a cero");
        }


        return itemFacturaRepository.save(item);
    }

    @Override
    public ItemFactura obtenerItemPorId(Long id) {
        return itemFacturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ItemFactura no encontrado"));
    }

    @Override
    public List<ItemFactura> listarItems() {
        return itemFacturaRepository.findAll();
    }

    @Override
    public ItemFactura actualizarItem(Long id, ItemFactura item) {
        ItemFactura existente = obtenerItemPorId(id);
        existente.setCantidad(item.getCantidad());
        existente.setPrecioUnitario(item.getPrecioUnitario());
        existente.setDescripcion(item.getDescripcion());
        return itemFacturaRepository.save(existente);
    }

    @Override
    public void eliminarItem(Long id) {
        itemFacturaRepository.deleteById(id);
    }
}

