package med.voll.api.domain.consulta.validacoes.agendamento;

import lombok.AllArgsConstructor;
import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.dto.DadosAgendamentoConsulta;
import med.voll.api.domain.medico.MedicoRepository;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta {

    private final MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados) {
        //escolha do medico opcional
        if (dados.idMedico() == null)
            return;

        var medicoEstaAtivo = repository.existsAtivoById(dados.idMedico());
        if (!medicoEstaAtivo)
            throw new ValidacaoException("Consulta não pode ser agendada com médico excluído");
    }
}
