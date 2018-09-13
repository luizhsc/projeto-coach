package com.projetocoach.service;


import com.projetocoach.service.dto.CarDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VeiculoService {

    Page<CarDTO> findAllVeiculos(Pageable pageable);

    CarDTO findById(Long id);

    CarDTO save(CarDTO car);

    CarDTO update(CarDTO car);

    void delete(long id);
}
