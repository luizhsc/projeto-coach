package com.projetocoach.service.impl;

import com.projetocoach.repository.VeiculoRepository;
import com.projetocoach.service.VeiculoService;
import com.projetocoach.service.dto.CarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class VeiculoServiceImpl implements VeiculoService {


    private final VeiculoRepository repository;

    @Autowired
    public VeiculoServiceImpl(VeiculoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Page<CarDTO> findAllVeiculos(Pageable pageable) {
        //TODO: use mapper
        return repository.findAll(pageable);
    }

    @Override
    public CarDTO findById(Long id) {
        //TODO: create specific exception / user mapper
        return repository.findById(id).orElseThrow(RuntimeException::new);
    }

    @Override
    public CarDTO save(CarDTO car) {
        //TODO: use mapper
        return repository.save(car);
    }

    @Override
    public CarDTO update(CarDTO car) {
        //TODO: use mapper
        return repository.save(car);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }
}
