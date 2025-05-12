package com.jorgeramirez.pruebatecnica.domain.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TipoDocumento {
    C("Cédula de Ciudadanía"),
    P("Pasaporte");

  private final String descripcion;
}
