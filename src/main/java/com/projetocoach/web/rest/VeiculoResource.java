package com.projetocoach.web.rest;

import com.projetocoach.model.Veiculo;
import com.projetocoach.repository.VeiculoRepository;
import io.swagger.annotations.Api;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value="Veiculos API REST")
@RestController
@RequestMapping("veiculos")
public class VeiculoResource {

    private VeiculoRepository veiculoRepository;

    @Autowired
    public VeiculoResource(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    @GetMapping("/")
    public List<Veiculo> getAllVeiculos() {
        return veiculoRepository.findAll();
    }

    @PostMapping("/")
    public Veiculo createVeiculo(@Valid @RequestBody Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }




}