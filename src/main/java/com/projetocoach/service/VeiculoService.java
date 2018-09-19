package com.projetocoach.service;

import com.projetocoach.service.dto.VeiculoDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VeiculoService {

    Page<VeiculoDTO> findAll(Pageable pageable);

    Optional<VeiculoDTO> findById(Long id);

    VeiculoDTO save(VeiculoDTO veiculoDTO);

    VeiculoDTO update(VeiculoDTO veiculoDTO);

    void deleteById(Long id);


}
