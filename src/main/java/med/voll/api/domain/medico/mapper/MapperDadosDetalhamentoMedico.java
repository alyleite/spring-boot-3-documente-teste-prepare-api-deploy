package med.voll.api.domain.medico.mapper;

import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.dto.DadosDetalhamentoMedico;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapperDadosDetalhamentoMedico {
    Medico toEntity(DadosDetalhamentoMedico dto);

    DadosDetalhamentoMedico toDto(Medico entity);

    List<DadosDetalhamentoMedico> toListDto(List<Medico> entity);

    List<Medico> toListEntity(List<DadosDetalhamentoMedico> entity);
}
