package com.projetocoach.service;

import com.projetocoach.model.Veiculo;
import com.projetocoach.service.dto.VeiculoDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VeiculoService {

    Page<VeiculoDTO> findAll(Pageable pageable);

    Optional<VeiculoDTO> findById(Long id);

    void save(Veiculo veiculo);

    void update(Veiculo veiculo);

    void delete(Veiculo veiculo);
}
