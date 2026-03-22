package com.example.Gestor.Gestor_Sueldos.Services;

import com.example.Gestor.Gestor_Sueldos.Models.ItemFactura;

import java.util.List;

public interface ItemFacturaService {
    ItemFactura crearItem(ItemFactura item);
    ItemFactura obtenerItemPorId(Long id);
    List<ItemFactura> listarItems();
    ItemFactura actualizarItem(Long id, ItemFactura item);
    void eliminarItem(Long id);
}

