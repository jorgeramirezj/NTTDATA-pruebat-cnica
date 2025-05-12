package com.jorgeramirez.pruebatecnica.infrastructure.controller.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioResponse {

  private String primerNombre;
  private String segundoNombre;
  private String primerApellido;
  private String segundoApellido;
  private String telefono;
  private String direccion;
  private String ciudadResidencia;

}
