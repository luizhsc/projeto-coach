package com.projetocoach.controller;

import com.projetocoach.model.Veiculo;
import com.projetocoach.service.VeiculoService;
import com.projetocoach.service.dto.VeiculoDto;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

@Api(value = "Veiculos API REST")
@RestController
@RequestMapping("veiculos")
public class VeiculoController {

    private VeiculoService service;

    public VeiculoController(VeiculoService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<VeiculoDto>> getAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAll(pageable));
    }

    @GetMapping("/{id}")
    @ResponseBody
    public VeiculoDto getById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<VeiculoDto> create(@Valid @RequestBody VeiculoDto veiculoDto) throws URISyntaxException {
        return ResponseEntity.created(new URI("/veiculos/" + service.save(veiculoDto))).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoDto> update(@RequestBody VeiculoDto veiculoDto) {
        return ResponseEntity.ok(service.update(veiculoDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}