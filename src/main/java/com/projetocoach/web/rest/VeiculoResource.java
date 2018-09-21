package com.projetocoach.web.rest;

import com.projetocoach.service.VeiculoService;
import com.projetocoach.service.dto.VeiculoDTO;
import io.swagger.annotations.Api;
import java.net.URI;
import java.net.URISyntaxException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Veiculos API REST")
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

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoDTO> getOne(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<VeiculoDTO> create(@Valid @RequestBody VeiculoDTO veiculoDTO) throws URISyntaxException {
        return ResponseEntity.created(new URI("/veiculos/" + service.save(veiculoDTO))).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoDTO> update(@RequestBody VeiculoDTO veiculoDTO) {
        return ResponseEntity.ok(service.update(veiculoDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}