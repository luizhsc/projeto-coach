package com.projetocoach.service.impl;

import com.projetocoach.mapper.VeiculoMapper;
import com.projetocoach.service.VeiculoService;
import com.projetocoach.service.dto.VeiculoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class VeiculoServiceImpl implements VeiculoService {

    private final VeiculoService veiculoService;

    private final VeiculoMapper mapper;

    @Autowired
    public VeiculoServiceImpl(VeiculoService veiculoService, VeiculoMapper mapper) {
        this.veiculoService = veiculoService;
        this.mapper = mapper;
    }

    @Override
    public Page<VeiculoDTO> findAll(Pageable pageable) {
        return veiculoService.findAll(pageable);
    }

    @Override
    public VeiculoDTO findById(Long id) {
        //TODO: create specific exception / user mapper
        return veiculoService.findById(id);
    }

    @Override
    public VeiculoDTO save(VeiculoDTO veiculoDTO) {
        //TODO: use mapper
        return veiculoService.save(veiculoDTO);
    }

    @Override
    public VeiculoDTO update(VeiculoDTO veiculoDTO) {
        //TODO: use mapper
        return veiculoService.save(veiculoDTO);
    }

    @Override
    public void delete(long id) {
        veiculoService.delete(id);
    }

}
