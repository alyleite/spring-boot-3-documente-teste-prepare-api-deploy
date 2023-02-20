package med.voll.api.domain.consulta.mapper;

import med.voll.api.domain.consulta.Consulta;
import med.voll.api.domain.consulta.dto.DadosAgendamentoConsulta;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MapperAgendaConsulta {
    Consulta toEntity(DadosAgendamentoConsulta dto);

    DadosAgendamentoConsulta toDto(Consulta entity);

    List<DadosAgendamentoConsulta> toListDto(List<Consulta> entity);

    List<Consulta> toListEntity(List<DadosAgendamentoConsulta> entity);
}
