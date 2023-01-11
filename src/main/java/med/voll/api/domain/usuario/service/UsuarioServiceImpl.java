package med.voll.api.domain.usuario.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import med.voll.api.domain.usuario.Usuario;
import med.voll.api.domain.usuario.dto.DadosAutenticacao;
import med.voll.api.infra.security.DadosTokenJWT;
import med.voll.api.infra.security.TokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class UsuarioServiceImpl implements UsuarioService {

    private final AuthenticationManager manager;
    private final TokenService tokenService;

    @Override
    public DadosTokenJWT efetuarLogin(DadosAutenticacao dados) {
        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var authentication = manager.authenticate(authenticationToken);
        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
        return new DadosTokenJWT(tokenJWT);
    }
}
