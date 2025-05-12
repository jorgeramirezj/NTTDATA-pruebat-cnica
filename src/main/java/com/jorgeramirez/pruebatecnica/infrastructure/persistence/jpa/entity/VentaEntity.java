package com.jorgeramirez.pruebatecnica.infrastructure.persistence.jpa.entity;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ventas")
public class VentaEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_venta")
  private Long idVenta;

  @Column(
      name = "id_empleado",
      nullable = false
  )
  private Long idEmpleado;

  @Column(
      name = "descripcion_venta",
      length = 200
  )
  private String descripcionVenta;

  @Column(
      name = "valor_venta",
      nullable = false,
      precision = 14,
      scale = 2
  )
  private BigDecimal valorVenta;

}
