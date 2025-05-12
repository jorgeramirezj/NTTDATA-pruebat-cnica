package com.jorgeramirez.pruebatecnica.domain.dao;

import java.util.List;

import com.jorgeramirez.pruebatecnica.domain.model.Venta;

public interface VentaDao {

  List<Venta> obtenerVentasPorEmpleado(Long empleadoId);

}
