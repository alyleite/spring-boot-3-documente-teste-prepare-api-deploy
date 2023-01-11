package med.voll.api.domain.paciente.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.domain.paciente.dto.DadosAtualizacaoPaciente;
import med.voll.api.domain.paciente.dto.DadosCadastroPaciente;
import med.voll.api.domain.paciente.dto.DadosDetalhamentoPaciente;
import med.voll.api.domain.paciente.dto.DadosListagemPaciente;
import med.voll.api.domain.paciente.mapper.MapperDadosCadastroPaciente;
import med.voll.api.domain.paciente.mapper.MapperDadosDetalhamentoPaciente;
import med.voll.api.domain.paciente.mapper.MapperDadosListagemPaciente;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class PacienteServiceImpl implements PacienteService {

    private final PacienteRepository repository;
    private final MapperDadosCadastroPaciente mapper;
    private final MapperDadosListagemPaciente mapperDadosListagemPaciente;
    private final MapperDadosDetalhamentoPaciente mapperDadosDetalhamentoPaciente;

    @Override
    @Transactional
    public DadosDetalhamentoPaciente cadastrar(DadosCadastroPaciente dados) {
        var paciente = mapper.toEntity(dados).ativar();
        repository.save(paciente);
        return mapperDadosDetalhamentoPaciente.toDto(paciente);
    }

    @Override
    public Page<DadosListagemPaciente> listar(Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(mapperDadosListagemPaciente::toDto);
    }

    @Override
    @Transactional
    public DadosDetalhamentoPaciente atualizar(DadosAtualizacaoPaciente dados) {
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
        return mapperDadosDetalhamentoPaciente.toDto(paciente);
    }

    @Override
    @Transactional
    public void excluir(Long id) {
        var medico = repository.getReferenceById(id);
        medico.excluir();
    }

    @Override
    public DadosDetalhamentoPaciente detalhar(Long id) {
        var paciente = repository.getReferenceById(id);
        return mapperDadosDetalhamentoPaciente.toDto(paciente);
    }
}
