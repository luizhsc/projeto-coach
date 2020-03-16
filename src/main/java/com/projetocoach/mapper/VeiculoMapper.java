package com.projetocoach.mapper;

import com.projetocoach.dto.VeiculoDto;
import com.projetocoach.model.Veiculo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring") public interface VeiculoMapper {
    Veiculo toModel(VeiculoDto dto);

    VeiculoDto toDto(Veiculo veiculo);
}
