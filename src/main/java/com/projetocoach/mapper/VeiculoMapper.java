package com.projetocoach.mapper;

import com.projetocoach.model.Veiculo;
import com.projetocoach.service.dto.VeiculoDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring") public interface VeiculoMapper {
    Veiculo toModel(VeiculoDto dto);

    VeiculoDto toDto(Veiculo veiculo);
}
