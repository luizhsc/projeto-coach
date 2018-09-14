package com.projetocoach.service;


import com.projetocoach.model.Veiculo;
import com.projetocoach.service.dto.VeiculoDTO;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VeiculoService {
    Page<VeiculoDTO> findAll(Pageable pageable);

    VeiculoDTO findById(Long id);

    VeiculoDTO save(VeiculoDTO veiculoDTO);

    VeiculoDTO update(VeiculoDTO veiculoDTO);

    void delete(long id);

}
