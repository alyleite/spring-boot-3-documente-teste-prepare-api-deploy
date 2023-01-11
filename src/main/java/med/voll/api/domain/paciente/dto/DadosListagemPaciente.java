package med.voll.api.domain.paciente.dto;

public record DadosListagemPaciente(
        Long id,
        String nome,
        String email,
        String cpf) {
}
