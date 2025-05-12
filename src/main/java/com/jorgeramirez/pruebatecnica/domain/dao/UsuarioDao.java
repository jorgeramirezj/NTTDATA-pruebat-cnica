package com.jorgeramirez.pruebatecnica.domain.dao;

import java.util.Optional;

import com.jorgeramirez.pruebatecnica.domain.model.Usuario;

public interface UsuarioDao {

  Optional<Usuario> getUsuarioByTipoAndNumero(String tipoDocumento,
      String numeroDocumento);

}
