package com.projetocoach.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.projetocoach.exception.VeiculoException;
import com.projetocoach.mapper.VeiculoMapper;
import com.projetocoach.repository.VeiculoRepository;
import com.projetocoach.service.VeiculoService;
import com.projetocoach.service.dto.VeiculoDto;

@Service
public class VeiculoServiceImpl implements VeiculoService {

	@Autowired
    private final VeiculoRepository veiculoRepository;

	@Autowired
    private final VeiculoMapper mapper;

    public VeiculoServiceImpl(VeiculoRepository veiculoRepository, VeiculoMapper mapper) {
        this.veiculoRepository = veiculoRepository;
        this.mapper = mapper;
    }

    @Override
    public Page<VeiculoDto> findAll(Pageable pageable) {
        return veiculoRepository.findAll(pageable).map(mapper::toDto); 
    }

    @Override
    public VeiculoDto findById(Long id) {
        return mapper.toDto(veiculoRepository.findById(id).orElseThrow(VeiculoException::new));
    }

    @Override
    public VeiculoDto save(VeiculoDto veiculoDto) {
        return mapper.toDto(veiculoRepository.save(mapper.toModel(veiculoDto)));
    }

    @Override
    public VeiculoDto update(VeiculoDto veiculoDto) {
        return mapper.toDto(veiculoRepository.save(mapper.toModel(veiculoDto)));
    }

    @Override
    public void deleteById(Long id) {
        veiculoRepository.deleteById(id);
    }


}
