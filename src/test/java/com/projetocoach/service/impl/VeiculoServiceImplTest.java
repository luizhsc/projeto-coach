package com.projetocoach.service.impl;

import com.projetocoach.service.VeiculoService;
import com.projetocoach.service.dto.VeiculoDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class VeiculoServiceImplTest{

    @Test
    public void buscarTodosVeiculos() {
        VeiculoService veiculoService = Mockito.mock(VeiculoService.class);
        Pageable pageable = Mockito.mock(Pageable.class);
        Page page = Mockito.mock(Page.class);

        VeiculoDTO veiculoDTO = new VeiculoDTO();

        veiculoDTO.setMarca("Teste");
        veiculoDTO.setModelo("Teste");
        veiculoDTO.setAno("2000");

        Mockito.when(veiculoService.findAll(pageable)).thenReturn(page);

        Assert.assertEquals(veiculoService.findAll(pageable), page);
    }


    @Test
    public void buscarVeiculoPorId(){
        VeiculoService veiculoService = Mockito.mock(VeiculoService.class);

        long id = 1;

        VeiculoDTO veiculoDTO = new VeiculoDTO();

        Mockito.when(veiculoService.findById(id)).thenReturn(veiculoDTO);

        Assert.assertEquals(veiculoService.findById(id), veiculoDTO);
    }

    @Test
    public void salvaVeiculo(){
        VeiculoService veiculoService = Mockito.mock(VeiculoService.class);

        VeiculoDTO veiculoDTO = new VeiculoDTO();

        Mockito.when(veiculoService.save(veiculoDTO)).thenReturn(veiculoDTO);
        Assert.assertEquals(veiculoService.save(veiculoDTO), veiculoDTO);
    }


    @Test
    public void atualizaVeiculo(){
        VeiculoService veiculoService = Mockito.mock(VeiculoService.class);

        VeiculoDTO veiculoDTO = new VeiculoDTO();

        Mockito.when(veiculoService.update(veiculoDTO)).thenReturn(veiculoDTO);
        Assert.assertEquals(veiculoService.update(veiculoDTO), veiculoDTO);
    }

}