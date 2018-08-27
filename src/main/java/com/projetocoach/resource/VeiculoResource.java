package com.projetocoach.resource;

import com.projetocoach.models.Veiculo;
import com.projetocoach.repository.VeiculoRepository;
import io.swagger.annotations.Api;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Api(value="Veiculos API REST")
@RestController
@RequestMapping("/veiculo")
public class VeiculoResource {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @GetMapping(produces="application/json")
    public @ResponseBody Iterable<Veiculo> listaVeiculos(){
        Iterable<Veiculo> listaVeiculos = veiculoRepository.findAll();
        return listaVeiculos;
    }

    @PostMapping
    public Veiculo cadastraVeiculo(@RequestBody @Valid Veiculo veiculo){
        return veiculoRepository.save(veiculo);
    }

    @PutMapping("/{id}")
    public Veiculo atualizaVeiculo(@PathVariable(value = "id") Long id,
                           @Valid @RequestBody Veiculo detalheVeiculo) {

        Veiculo veiculo = veiculoRepository.findById(id);

        veiculo.setMarca(detalheVeiculo.getMarca());
        veiculo.setModelo(detalheVeiculo.getModelo());
        veiculo.setAno(detalheVeiculo.getAno());
        veiculo.setCor(detalheVeiculo.getCor());
        veiculo.setDescricao(detalheVeiculo.getDescricao());
        veiculo.setTipo(detalheVeiculo.getTipo());

        Veiculo atualizaVeiculo = veiculoRepository.save(veiculo);

        return atualizaVeiculo;
    }

    @DeleteMapping
    public Veiculo deletaVeiculo(@RequestBody Veiculo veiculo){
        veiculoRepository.delete(veiculo);
        return veiculo;
    }
}
