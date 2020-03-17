package com.projetocoach.controller;

import com.projetocoach.dto.VeiculoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URISyntaxException;

@Component public interface VeiculoController {

    @GetMapping ResponseEntity<Page<VeiculoDto>> getAll(Pageable pageable);

    @GetMapping("/{id}") @ResponseBody VeiculoDto getById(@PathVariable("id") Long id);

    @PostMapping ResponseEntity<VeiculoDto> create(@Valid @RequestBody VeiculoDto veiculoDto)
        throws URISyntaxException;

    @PutMapping("/{id}") ResponseEntity<VeiculoDto> update(@RequestBody VeiculoDto veiculoDto);

    @DeleteMapping("/{id}") public ResponseEntity delete(@PathVariable("id") Long id);

}
