package com.projetocoach.web.rest;

import com.projetocoach.service.VeiculoService;
import com.projetocoach.service.dto.CarDTO;
import io.swagger.annotations.Api;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value="Veiculos API REST")
@RestController
@RequestMapping("veiculos")
public class VeiculoResource {

    private final VeiculoService service;

    @Autowired
    public VeiculoResource(VeiculoService service) {
        this.service = service;
    }

    @GetMapping("/")
    public ResponseEntity<Page<CarDTO>> getAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAllVeiculos(pageable));
    }

    @PostMapping("/")
    public ResponseEntity<CarDTO> createVeiculo(@Valid @RequestBody CarDTO car) {
        return ResponseEntity.ok(service.save(car));
    }

    //more methods here
    //use: http://mapstruct.org/ to convert DTO to Entity and Entity to DTO
    // read about DTO (DDD - Domain Drive Designer)
}