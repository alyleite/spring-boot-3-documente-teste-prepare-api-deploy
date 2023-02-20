package med.voll.api.domain.consulta.service;

import med.voll.api.domain.consulta.dto.DadosAgendamentoConsulta;
import med.voll.api.domain.consulta.dto.DadosCancelamentoConsulta;
import med.voll.api.domain.consulta.dto.DadosDetalhamentoConsulta;

public interface AgendaDeConsultasService {
    DadosDetalhamentoConsulta agendar(DadosAgendamentoConsulta dados);

    void cancelar(DadosCancelamentoConsulta dados);
}
