package com.jorgeramirez.pruebatecnica.domain.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Usuario {

  private TipoDocumento tipoDocumento;
  private String numeroDocumento;
  private String primerNombre;
  private String segundoNombre;
  private String primerApellido;
  private String segundoApellido;
  private String telefono;
  private String direccion;
  private String ciudadResidencia;

}
