package med.voll.api.domain.paciente.mapper;

import med.voll.api.domain.paciente.Paciente;
import med.voll.api.domain.paciente.dto.DadosDetalhamentoPaciente;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapperDadosDetalhamentoPaciente {
    Paciente toEntity(DadosDetalhamentoPaciente dto);

    DadosDetalhamentoPaciente toDto(Paciente entity);

    List<DadosDetalhamentoPaciente> toListDto(List<Paciente> entity);

    List<Paciente> toListEntity(List<DadosDetalhamentoPaciente> entity);
}
