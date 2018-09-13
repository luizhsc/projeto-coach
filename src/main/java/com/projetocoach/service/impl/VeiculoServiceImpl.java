package com.projetocoach.service.impl;

import com.projetocoach.mapper.VeiculoMapper;
import com.projetocoach.model.Veiculo;
import com.projetocoach.repository.VeiculoRepository;
import com.projetocoach.service.VeiculoService;
import com.projetocoach.service.dto.VeiculoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class VeiculoServiceImpl implements VeiculoService {


    private final VeiculoRepository repository;

    private final VeiculoMapper mapper;

    @Autowired
    public VeiculoServiceImpl(VeiculoRepository repository, VeiculoMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Page<VeiculoDTO> findAll(Pageable pageable) {
        return (Page<VeiculoDTO>) mapper.toDto(repository.findAll());
    }

    @Override
    public VeiculoDTO findById(Long id) {
        //TODO: create specific exception / user mapper
        return mapper.toDto(repository.findById(id).orElseThrow(RuntimeException::new));
    }

    @Override
    public VeiculoDTO save(VeiculoDTO veiculoDTO) {
        //TODO: use mapper
        return mapper.toDto(repository.save(veiculoDTO));
    }

    @Override
    public VeiculoDTO update(VeiculoDTO veiculoDTO) {
        //TODO: use mapper
        return repository.save(veiculoDTO);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
