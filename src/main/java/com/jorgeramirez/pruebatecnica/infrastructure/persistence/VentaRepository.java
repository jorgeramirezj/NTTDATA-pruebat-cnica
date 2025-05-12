package com.jorgeramirez.pruebatecnica.infrastructure.persistence;

import java.util.List;

import org.springframework.stereotype.Component;

import com.jorgeramirez.pruebatecnica.domain.dao.VentaDao;
import com.jorgeramirez.pruebatecnica.domain.model.Venta;
import com.jorgeramirez.pruebatecnica.infrastructure.persistence.jpa.VentaJpaRepository;
import com.jorgeramirez.pruebatecnica.infrastructure.persistence.jpa.mapper.VentaEntityMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class VentaRepository implements VentaDao {

  private final VentaJpaRepository ventaJpaRepository;
  private final VentaEntityMapper ventaEntityMapper;

  @Override
  public List<Venta> obtenerVentasPorEmpleado(Long empleadoId) {

    return ventaJpaRepository.findByIdEmpleado(empleadoId)
        .stream()
        .map(ventaEntityMapper::toDomain)
        .toList();
  }
}
