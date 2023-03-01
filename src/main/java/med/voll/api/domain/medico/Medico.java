package med.voll.api.domain.medico;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.converter.BooleanNotNullConverter;
import med.voll.api.domain.endereco.Endereco;
import med.voll.api.domain.medico.dto.DadosAtualizacaoMedico;
import med.voll.api.domain.medico.dto.DadosCadastroMedico;
import med.voll.api.domain.model.AbstractEntity;
import org.hibernate.Hibernate;

import java.util.Objects;

@Table(name = "medico")
@Entity(name = "Medico")
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Medico extends AbstractEntity<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    @NotNull
    @Column(name = "ativo", nullable = false)
    @Convert(converter = BooleanNotNullConverter.class)
    private Boolean ativo;

    public Medico(DadosCadastroMedico dadosMedico) {
        this.ativo = true;
        this.email = dadosMedico.email();
        this.endereco = new Endereco(dadosMedico.endereco());
        this.nome = dadosMedico.nome();
        this.crm = dadosMedico.crm();
        this.especialidade = dadosMedico.especialidade();
        this.telefone = dadosMedico.telefone();
    }

    @Override
    public Long getId() {
        return this.id;
    }

    public void excluir() {
        this.ativo = false;
    }

    public Medico ativar() {
        this.ativo = true;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Medico medico = (Medico) o;
        return id != null && Objects.equals(id, medico.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public void atualizarInformacoes(DadosAtualizacaoMedico dados) {
        if (dados.nome() != null)
            this.nome = dados.nome();
        if (dados.telefone() != null)
            this.telefone = dados.telefone();
        if (dados.endereco() != null)
            this.endereco.atualizarInformacoes(dados.endereco());
    }
}
