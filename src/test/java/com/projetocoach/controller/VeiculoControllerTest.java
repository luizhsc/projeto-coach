package com.projetocoach.controller;

import com.projetocoach.service.VeiculoService;
import com.projetocoach.service.dto.VeiculoDto;
import java.net.URISyntaxException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class VeiculoResourceTest {

    @InjectMocks
    private VeiculoController veiculoResource;

    @Mock
    private VeiculoService veiculoService;

    @Test
    public void buscarTodosVeiculos() {
        PageRequest pageable = new PageRequest(1, 1);
        ResponseEntity<Page<VeiculoDto>> veiculoDto = veiculoResource.getAll(pageable);
        Mockito.verify(veiculoService).findAll(pageable);
    }

    @Test
    public void buscarVeiculoPorId() {
        long id = 1;

        ResponseEntity<VeiculoDto> veiculoDto = veiculoResource.getOne(id);
        Mockito.verify(veiculoService).findById(id);
    }

    @Test
    public void salvarVeiculo() throws URISyntaxException {
        VeiculoDto veiculoDto = new VeiculoDto();
        veiculoResource.create(veiculoDto);
        Mockito.verify(veiculoService).save(veiculoDto);
    }

    @Test
    public void deletarVeiculo() {
        long id = 1;

        veiculoResource.delete(id);
        Mockito.verify(veiculoService).deleteById(id);
    }

    @Test
    public void atualizarVeiculo() {
        VeiculoDto veiculoDto = new VeiculoDto();
        veiculoResource.update(veiculoDto);
        Mockito.verify(veiculoService).update(veiculoDto);
    }

}
