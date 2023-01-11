package med.voll.api.domain.paciente.service;

import med.voll.api.domain.paciente.dto.DadosAtualizacaoPaciente;
import med.voll.api.domain.paciente.dto.DadosCadastroPaciente;
import med.voll.api.domain.paciente.dto.DadosDetalhamentoPaciente;
import med.voll.api.domain.paciente.dto.DadosListagemPaciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PacienteService {
    DadosDetalhamentoPaciente cadastrar(DadosCadastroPaciente dados);

    Page<DadosListagemPaciente> listar(Pageable paginacao);

    DadosDetalhamentoPaciente atualizar(DadosAtualizacaoPaciente dados);

    void excluir(Long id);

    DadosDetalhamentoPaciente detalhar(Long id);
}
