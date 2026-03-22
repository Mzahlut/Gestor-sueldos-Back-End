package com.example.Gestor.Gestor_Sueldos.Services.ServiceImp;

import com.example.Gestor.Gestor_Sueldos.Models.Liquidacion;
import com.example.Gestor.Gestor_Sueldos.Repository.LiquidacionRepository;
import com.example.Gestor.Gestor_Sueldos.Repository.EmpleadoRepository;
import com.example.Gestor.Gestor_Sueldos.Services.LiquidacionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LiquidacionServiceImp implements LiquidacionService {

    private final LiquidacionRepository liquidacionRepository;
    private final EmpleadoRepository empleadoRepository;

    public LiquidacionServiceImp(LiquidacionRepository liquidacionRepository,
                                 EmpleadoRepository empleadoRepository) {
        this.liquidacionRepository = liquidacionRepository;
        this.empleadoRepository = empleadoRepository;
    }

    @Override
    public Liquidacion crearLiquidacion(Liquidacion liquidacion) {
        // cálculo automático del sueldo neto
        liquidacion.setSueldoNeto(liquidacion.getSueldoBruto() - liquidacion.getDescuentos());
        return liquidacionRepository.save(liquidacion);
    }

    @Override
    public Liquidacion obtenerLiquidacionPorId(Long id) {
        return liquidacionRepository.findById(id).orElse(null);
    }

    @Override
    public List<Liquidacion> listarLiquidaciones() {
        return liquidacionRepository.findAll();
    }

    @Override
    public List<Liquidacion> listarPorEmpleado(Long empleadoId) {
        return liquidacionRepository.findByEmpleadoId(empleadoId);
    }

    @Override
    public Liquidacion actualizarLiquidacion(Long id, Liquidacion liquidacion) {
        return liquidacionRepository.findById(id).map(l -> {
            l.setSueldoBruto(liquidacion.getSueldoBruto());
            l.setDescuentos(liquidacion.getDescuentos());
            l.setPeriodo(liquidacion.getPeriodo());
            l.setSueldoNeto(liquidacion.getSueldoBruto() - liquidacion.getDescuentos());
            return liquidacionRepository.save(l);
        }).orElse(null);
    }

    @Override
    public void eliminarLiquidacion(Long id) {
        liquidacionRepository.findById(id).ifPresent(liquidacionRepository::delete);
    }
}