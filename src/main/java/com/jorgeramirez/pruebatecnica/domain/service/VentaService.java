package com.jorgeramirez.pruebatecnica.domain.service;

import java.util.List;

import com.jorgeramirez.pruebatecnica.domain.model.Venta;

public interface VentaService {

  List<Venta> obtenerVentasPorEmpleado(Long empleadoId);

}
