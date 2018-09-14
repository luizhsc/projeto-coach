package com.projetocoach.service.impl;

import com.projetocoach.mapper.VeiculoMapper;
import com.projetocoach.model.Veiculo;
import com.projetocoach.repository.VeiculoRepository;
import com.projetocoach.service.VeiculoService;
import com.projetocoach.service.dto.VeiculoDTO;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class VeiculoServiceImpl implements VeiculoService {

    private final VeiculoRepository veiculoRepository;

    private final VeiculoMapper mapper;

    @Autowired
    public VeiculoServiceImpl(VeiculoRepository veiculoRepository, VeiculoMapper mapper) {
        this.veiculoRepository = veiculoRepository;
        this.mapper = mapper;
    }

    @Override
    public Page<VeiculoDTO> findAll(Pageable pageable) {
        return veiculoRepository.findAll(pageable).map(mapper::toDto);
    }

    @Override
    public Optional<VeiculoDTO> findById(Long id) {
        //TODO: create specific exception / user mapper
        return veiculoRepository.findById(id).map(mapper::toDto);
    }

    public Veiculo save(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    @Override
    public Veiculo update(Veiculo veiculo) {
        //TODO: use mapper
        return veiculoRepository.save(veiculo);
    }

    @Override
    public void delete(Long id) {
        return veiculoRepository.deleteById(id);
    }

}
