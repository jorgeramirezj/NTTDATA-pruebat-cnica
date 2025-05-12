package com.jorgeramirez.pruebatecnica.infrastructure.controller.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioRequest {

  @NotBlank(message = "El tipo de documento es obligatorio.")
  @Pattern(
      regexp = "C|P",
      message = "El tipo de documento debe ser 'C' o 'P'."
  )
  private String tipoDocumento;

  @NotBlank(message = "El número de documento es obligatorio.")
  private String numeroDocumento;

}
