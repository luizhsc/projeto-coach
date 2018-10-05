package com.projetocoach.service.impl;

import com.projetocoach.mapper.VeiculoMapperImpl;
import com.projetocoach.model.Veiculo;
import com.projetocoach.repository.VeiculoRepository;
import com.projetocoach.service.VeiculoService;
import com.projetocoach.service.dto.VeiculoDTO;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource({"/application-test.properties"})
public class VeiculoServiceImplTest{

    @Test
    public void buscarTodosVeiculos() {
        VeiculoService veiculoService = Mockito.mock(VeiculoService.class);
        VeiculoRepository veiculoRepository = Mockito.mock(VeiculoRepository.class);
        VeiculoMapperImpl veiculoMapper = Mockito.mock(VeiculoMapperImpl.class);
        Pageable pageable = Mockito.mock(Pageable.class);

        VeiculoDTO veiculoDTO = new VeiculoDTO();

        veiculoDTO.setMarca("Teste");
        veiculoDTO.setModelo("Teste");
        veiculoDTO.setAno("2000");

        List<Veiculo> veiculo = new ArrayList<>();

        Page<Veiculo> page = new PageImpl<>(veiculo);

        Mockito.when(veiculoRepository.findAll()).thenReturn(veiculo, (List<Veiculo>) page);

        Assert.assertEquals(page.map(veiculoMapper::toDto), veiculoService.findAll(pageable));
    }


    @Test
    public void buscaPorId(){

    }

}