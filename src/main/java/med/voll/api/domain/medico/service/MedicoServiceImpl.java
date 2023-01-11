package med.voll.api.domain.medico.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.medico.dto.DadosAtualizacaoMedico;
import med.voll.api.domain.medico.dto.DadosCadastroMedico;
import med.voll.api.domain.medico.dto.DadosDetalhamentoMedico;
import med.voll.api.domain.medico.dto.DadosListagemMedico;
import med.voll.api.domain.medico.mapper.MapperDadosCadastroMedico;
import med.voll.api.domain.medico.mapper.MapperDadosDetalhamentoMedico;
import med.voll.api.domain.medico.mapper.MapperDadosListagemMedico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class MedicoServiceImpl implements MedicoService {

    private final MedicoRepository repository;
    private final MapperDadosCadastroMedico mapper;
    private final MapperDadosListagemMedico mapperDadosListagemMedico;
    private final MapperDadosDetalhamentoMedico mapperDadosDetalhamentoMedico;

    @Override
    @Transactional
    public DadosDetalhamentoMedico cadastrar(DadosCadastroMedico dados) {
        var medico = mapper.toEntity(dados).ativar();
        repository.save(medico);
        return mapperDadosDetalhamentoMedico.toDto(medico);
    }

    @Override
    public Page<DadosListagemMedico> listar(Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(mapperDadosListagemMedico::toDto);
    }

    @Override
    @Transactional
    public DadosDetalhamentoMedico atualizar(DadosAtualizacaoMedico dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
        return mapperDadosDetalhamentoMedico.toDto(medico);
    }

    @Override
    @Transactional
    public void excluir(Long id) {
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }

    @Override
    public DadosDetalhamentoMedico detalhar(Long id) {
        var paciente = repository.getReferenceById(id);
        return mapperDadosDetalhamentoMedico.toDto(paciente);
    }
}
