package med.voll.api.domain.medico.mapper;

import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.dto.DadosListagemMedico;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapperDadosListagemMedico {
    Medico toEntity(DadosListagemMedico dto);

    DadosListagemMedico toDto(Medico entity);

    List<DadosListagemMedico> toListDto(List<Medico> entity);

    List<Medico> toListEntity(List<DadosListagemMedico> entity);
}
