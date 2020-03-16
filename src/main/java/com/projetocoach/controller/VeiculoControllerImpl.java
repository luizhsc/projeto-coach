package com.projetocoach.controller;

import com.projetocoach.dto.VeiculoDto;
import com.projetocoach.service.VeiculoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Veiculos API REST") @RestController @RequestMapping("veiculos")
public class VeiculoControllerImpl implements VeiculoController {

    @Autowired private VeiculoService service;

    @Override public Page<VeiculoDto> getAll(Pageable pageable) {
        return service.findAll(pageable);
    }

    @Override public VeiculoDto getById(Long id) {
        return service.findById(id);
    }

    @Override public VeiculoDto create(VeiculoDto veiculoDto) {
        return service.save(veiculoDto);
    }

    @Override public VeiculoDto update(@RequestBody VeiculoDto veiculoDto) {
        return service.update(veiculoDto);
    }

    @Override public void delete(@PathVariable("id") Long id) {
        service.deleteById(id);
    }
}
