package com.example.Gestor.Gestor_Sueldos.Services.ServiceImp;

import com.example.Gestor.Gestor_Sueldos.Models.Factura;
import com.example.Gestor.Gestor_Sueldos.Repository.ClienteRepository;
import com.example.Gestor.Gestor_Sueldos.Repository.FacturaRepository;
import com.example.Gestor.Gestor_Sueldos.Services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class FacturaServiceImp implements FacturaService {

    @Autowired
    private FacturaRepository facturaRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public Factura crearFactura(Factura factura) {
        if (factura.getCliente() == null ||
                !clienteRepository.existsById(factura.getCliente().getId())) {
            throw new RuntimeException("La factura debe estar asociada a un cliente válido");
        }
        BigDecimal total = factura.getItems().stream()
                .map(item -> item.getPrecioUnitario()
                        .multiply(BigDecimal.valueOf(item.getCantidad())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        factura.setMontoTotal(total);

        return facturaRepository.save(factura);
    }

    @Override
    public Factura obtenerFacturaPorId(Long id) {
        return facturaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Factura no encontrada"));
    }

    @Override
    public List<Factura> listarFacturas() {
        return facturaRepository.findAll();
    }

    @Override
    public Factura actualizarFactura(Long id, Factura factura) {
        Factura existente = obtenerFacturaPorId(id);
        existente.setFecha(factura.getFecha());
        existente.setCliente(factura.getCliente());
        existente.setItems(factura.getItems());

        BigDecimal total = existente.getItems().stream()
                .map(item -> item.getPrecioUnitario()
                        .multiply(BigDecimal.valueOf(item.getCantidad())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        existente.setMontoTotal(total);


        return facturaRepository.save(existente);
    }

    @Override
    public void eliminarFactura(Long id) {
        facturaRepository.deleteById(id);
    }

    @Override
    public BigDecimal calcularTotal(Long idFactura) {
        Factura factura = obtenerFacturaPorId(idFactura);
        return factura.getItems().stream()
                .map(item -> item.getPrecioUnitario().multiply(new BigDecimal(item.getCantidad())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
