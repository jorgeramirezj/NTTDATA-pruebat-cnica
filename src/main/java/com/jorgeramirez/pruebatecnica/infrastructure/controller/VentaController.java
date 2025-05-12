package com.jorgeramirez.pruebatecnica.infrastructure.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jorgeramirez.pruebatecnica.domain.model.Venta;
import com.jorgeramirez.pruebatecnica.domain.service.VentaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/ventas")
@RequiredArgsConstructor
public class VentaController {

  private final VentaService ventaService;

  @GetMapping("/empleado/{empleadoId}")
  public ResponseEntity<List<Venta>> obtenerVentasPorEmpleado(
      @PathVariable Long empleadoId) {

    List<Venta> ventas = ventaService.obtenerVentasPorEmpleado(empleadoId);
    return ResponseEntity.ok(ventas);
  }

}
