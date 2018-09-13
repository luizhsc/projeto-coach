package com.projetocoach.web.rest;

import com.projetocoach.model.Veiculo;
import com.projetocoach.service.VeiculoService;
import com.projetocoach.service.dto.VeiculoDTO;
import io.swagger.annotations.Api;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

    @GetMapping
    public ResponseEntity<Page<VeiculoDTO>> getAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<VeiculoDTO> createVeiculo(@Valid @RequestBody VeiculoDTO veiculoDTO) {
        return ResponseEntity.ok(service.save(veiculoDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> updateVeiculo(@RequestBody VeiculoDTO veiculoDTO) {
        VeiculoDTO veiculoUpdate = service.update(veiculoDTO);
        return new ResponseEntity<Veiculo>((MultiValueMap<String, String>) veiculoUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteVeiculo(@RequestBody VeiculoDTO veiculoDTO, Long id) {
        return (ResponseEntity) ResponseEntity.status(HttpStatus.OK);
    }

    //more methods here
    //use: http://mapstruct.org/ to convert DTO to Entity and Entity to DTO
    // read about DTO (DDD - Domain Drive Designer)
}