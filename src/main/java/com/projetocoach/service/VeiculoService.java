package com.projetocoach.service;


import com.projetocoach.model.Veiculo;
import java.util.List;

public interface VeiculoService {
    Veiculo findById(long id);

    Veiculo findByModelo(String modelo);

    void saveVeiculo(Veiculo veiculo);

    void updateVeiculo(Veiculo veiculo);

    void deleteVeiculoById(long id);

    List<Veiculo> findAllVeiculos();

    public boolean isVeiculoExist(Veiculo veiculo);

}
