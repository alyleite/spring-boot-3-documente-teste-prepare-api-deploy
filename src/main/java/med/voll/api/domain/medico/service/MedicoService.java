package med.voll.api.domain.medico.service;

import med.voll.api.domain.medico.dto.DadosAtualizacaoMedico;
import med.voll.api.domain.medico.dto.DadosCadastroMedico;
import med.voll.api.domain.medico.dto.DadosListagemMedico;
import med.voll.api.domain.medico.dto.DadosDetalhamentoMedico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MedicoService {
    DadosDetalhamentoMedico cadastrar(DadosCadastroMedico dados);

    Page<DadosListagemMedico> listar(Pageable paginacao);

    DadosDetalhamentoMedico atualizar(DadosAtualizacaoMedico dados);

    void excluir(Long id);

    DadosDetalhamentoMedico detalhar(Long id);
}
