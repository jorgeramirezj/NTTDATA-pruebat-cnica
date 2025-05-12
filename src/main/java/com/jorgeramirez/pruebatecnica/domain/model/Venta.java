package com.jorgeramirez.pruebatecnica.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
public class Venta {

  private Long id;
  private Long empleadoId;
  private String descripcion;
  private BigDecimal valor;

}
