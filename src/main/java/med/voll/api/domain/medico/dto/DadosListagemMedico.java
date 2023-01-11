package med.voll.api.domain.medico.dto;

import med.voll.api.domain.medico.Especialidade;

public record DadosListagemMedico(Long id, String nome, String email, String crm, Especialidade especialidade) {
}
