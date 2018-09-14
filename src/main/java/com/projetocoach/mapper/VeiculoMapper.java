package com.projetocoach.mapper;

import com.projetocoach.model.Veiculo;
import com.projetocoach.service.dto.VeiculoDTO;
import org.mapstruct.Mapper;

@Mapper
public interface VeiculoMapper extends EntityMapper<VeiculoDTO, Veiculo> {

}
