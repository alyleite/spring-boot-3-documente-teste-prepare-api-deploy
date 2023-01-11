package med.voll.api.domain.usuario.service;

import med.voll.api.domain.usuario.dto.DadosAutenticacao;
import med.voll.api.infra.security.DadosTokenJWT;

public interface UsuarioService {

    DadosTokenJWT efetuarLogin(DadosAutenticacao dados);
}
