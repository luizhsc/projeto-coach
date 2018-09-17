package com.projetocoach.web.rest;

import com.projetocoach.model.Veiculo;
import com.projetocoach.repository.VeiculoRepository;
import io.swagger.annotations.Api;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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

@Api(value="Veiculos API REST")
@RestController
@RequestMapping("veiculos")
public class VeiculoResource {

    private VeiculoRepository veiculoRepository;

    @Autowired
    public VeiculoResource(VeiculoRepository veiculoRepository) {
        this.veiculoRepository = veiculoRepository;
    }

    @GetMapping
    public List<Veiculo> getAllVeiculos() {
        return veiculoRepository.findAll();
    }

    @PostMapping
    public Veiculo createVeiculo(@Valid @RequestBody Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> updateVeiculo(@RequestBody Veiculo veiculo) {
        veiculoRepository.save(veiculo);
        return new ResponseEntity<Veiculo>(veiculo, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVeiculo(@PathVariable("id") Long id) {
        veiculoRepository.deleteById(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }


}