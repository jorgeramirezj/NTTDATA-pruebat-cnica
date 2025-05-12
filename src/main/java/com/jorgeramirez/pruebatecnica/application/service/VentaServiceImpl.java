package com.jorgeramirez.pruebatecnica.application.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jorgeramirez.pruebatecnica.domain.dao.VentaDao;
import com.jorgeramirez.pruebatecnica.domain.exception.VentaNotFoundException;
import com.jorgeramirez.pruebatecnica.domain.model.Venta;
import com.jorgeramirez.pruebatecnica.domain.service.VentaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VentaServiceImpl implements VentaService {

  private final VentaDao ventaDao;

  @Override
  public List<Venta> obtenerVentasPorEmpleado(Long empleadoId) {

    List<Venta> ventas = ventaDao.obtenerVentasPorEmpleado(empleadoId);

    if (ventas.isEmpty()) {
      throw new VentaNotFoundException("No sales found for employee ID: "
          + empleadoId);
    }

    return ventas;
  }
}
