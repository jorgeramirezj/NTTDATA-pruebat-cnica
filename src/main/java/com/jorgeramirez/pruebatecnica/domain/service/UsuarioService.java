package com.jorgeramirez.pruebatecnica.domain.service;

import com.jorgeramirez.pruebatecnica.domain.model.Usuario;

public interface UsuarioService {

  Usuario getUsuarioByTipoAndNumero(String tipoDocumento,
      String numeroDocumento);

}
