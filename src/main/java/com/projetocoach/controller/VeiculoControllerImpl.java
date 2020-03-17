package com.projetocoach.controller;

import com.projetocoach.dto.VeiculoDto;
import com.projetocoach.service.VeiculoService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@Api(value = "Veiculos API REST") @RestController @RequestMapping("veiculos")
public class VeiculoControllerImpl implements VeiculoController {

    @Autowired private VeiculoService service;

    public ResponseEntity<Page<VeiculoDto>> getAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    public VeiculoDto getById(Long id) {
        return service.findById(id);
    }

    public ResponseEntity<VeiculoDto> create(VeiculoDto veiculoDto) throws URISyntaxException {
        return ResponseEntity.created(new URI("/veiculos/" + service.save(veiculoDto))).build();
    }

    public ResponseEntity<VeiculoDto> update(VeiculoDto veiculoDto) {
        return ResponseEntity.ok(service.update(veiculoDto));
    }

    public ResponseEntity delete(Long id) {
        service.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
