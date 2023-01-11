package med.voll.api.domain.paciente.dto;

import med.voll.api.domain.endereco.DadosEndereco;

public record DadosDetalhamentoPaciente(
        Long id,
        String nome,
        String email,
        String telefone,
        String cpf,
        DadosEndereco endereco) {
}
