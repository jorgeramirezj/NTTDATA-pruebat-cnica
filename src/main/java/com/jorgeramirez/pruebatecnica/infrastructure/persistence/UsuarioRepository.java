package com.jorgeramirez.pruebatecnica.infrastructure.persistence;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.jorgeramirez.pruebatecnica.domain.dao.UsuarioDao;
import com.jorgeramirez.pruebatecnica.domain.exception.InternalServerErrorException;
import com.jorgeramirez.pruebatecnica.domain.model.TipoDocumento;
import com.jorgeramirez.pruebatecnica.domain.model.Usuario;
import com.jorgeramirez.pruebatecnica.infrastructure.persistence.inmemory.DemoUsuarios;

@Component
public class UsuarioRepository implements UsuarioDao {

  private final Map<String, Usuario> usuarios = new ConcurrentHashMap<>();

  public UsuarioRepository() {

    cargarUsuariosDemo();
  }

  private void cargarUsuariosDemo() {

    DemoUsuarios.DEMO_USUARIOS.forEach(usuario -> {
      String key = usuario.getTipoDocumento() + usuario.getNumeroDocumento();
      usuarios.put(key, usuario);
    });
  }

  @Override
  public Optional<Usuario> getUsuarioByTipoAndNumero(String tipoDocumento,
      String numeroDocumento) {

    try {
      TipoDocumento tipo = TipoDocumento.valueOf(tipoDocumento.toUpperCase());
      String key = tipo.name() + numeroDocumento;
      return Optional.ofNullable(usuarios.get(key));
    } catch (IllegalArgumentException e) {
      throw new InternalServerErrorException(
          "Error al procesar el tipo de documento: "
              + tipoDocumento);
    }
  }

}
