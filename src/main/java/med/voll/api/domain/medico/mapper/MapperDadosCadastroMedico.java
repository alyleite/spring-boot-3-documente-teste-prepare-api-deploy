package med.voll.api.domain.medico.mapper;

import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.dto.DadosCadastroMedico;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapperDadosCadastroMedico {
    Medico toEntity(DadosCadastroMedico dto);

    DadosCadastroMedico toDto(Medico entity);

    List<DadosCadastroMedico> toListDto(List<Medico> entity);

    List<Medico> toListEntity(List<DadosCadastroMedico> entity);
}
