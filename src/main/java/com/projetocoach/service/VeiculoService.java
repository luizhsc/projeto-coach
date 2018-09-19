package com.projetocoach.service;

import com.projetocoach.service.dto.VeiculoDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VeiculoService {

    Page<VeiculoDTO> findAll(Pageable pageable);

    Optional<VeiculoDTO> findById(Long id);

    void save(VeiculoDTO veiculoDTO);

    void update(VeiculoDTO veiculoDTO);

    void delete(VeiculoDTO veiculoDTO);
}
