package com.projetocoach.controller;

import com.projetocoach.dto.VeiculoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Component public interface VeiculoController {

    @GetMapping @Consumes(MediaType.APPLICATION_JSON) @Produces(MediaType.APPLICATION_JSON)
    public Page<VeiculoDto> getAll(Pageable pageable);

    @GetMapping("/{id}") @Consumes(MediaType.APPLICATION_JSON) @Produces(MediaType.APPLICATION_JSON)
    public VeiculoDto getById(@PathVariable("id") Long id);

    @PostMapping @Consumes(MediaType.APPLICATION_JSON) @Produces(MediaType.APPLICATION_JSON)
    public VeiculoDto create(@Valid @RequestBody VeiculoDto veiculoDto);

    @PutMapping("/{id}") @Consumes(MediaType.APPLICATION_JSON) @Produces(MediaType.APPLICATION_JSON)
    public VeiculoDto update(@RequestBody VeiculoDto veiculoDto);

    @DeleteMapping("/{id}") @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON) public void delete(@PathVariable("id") Long id);
}
