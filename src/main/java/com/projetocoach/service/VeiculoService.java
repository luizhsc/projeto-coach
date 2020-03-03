package com.projetocoach.service;

import com.projetocoach.service.dto.VeiculoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VeiculoService {

    Page<VeiculoDto> findAll(Pageable pageable);

    VeiculoDto findById(Long id);

    VeiculoDto save(VeiculoDto veiculoDto);

    VeiculoDto update(VeiculoDto veiculoDto);

    void deleteById(Long id);
}
