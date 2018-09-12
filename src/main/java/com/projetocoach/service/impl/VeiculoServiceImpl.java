package com.projetocoach.service.impl;

import com.projetocoach.model.Veiculo;
import com.projetocoach.service.VeiculoService;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class VeiculoServiceImpl implements VeiculoService {

    private static final AtomicLong counter = new AtomicLong();

    private static List<Veiculo> veiculos;

    public List<Veiculo> findAllVeiculos() {
        return veiculos;
    }

    public Veiculo findById(long id) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getId() == id) {
                return veiculo;
            }
        }
        return null;
    }

    public Veiculo findByModelo(String name) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getModelo().equalsIgnoreCase(name)) {
                return veiculo;
            }
        }
        return null;
    }

    public void saveVeiculo(Veiculo veiculo) {
        veiculo.setId(counter.incrementAndGet());
        veiculos.add(veiculo);
    }

    public void updateVeiculo(Veiculo veiculo) {
        int index = veiculos.indexOf(veiculo);
        veiculos.set(index, veiculo);
    }

    public void deleteVeiculoById(long id) {
        for (Iterator<Veiculo> iterator = veiculos.iterator(); iterator.hasNext(); ) {
            Veiculo veiculo = iterator.next();
            if (veiculo.getId() == id) {
                iterator.remove();
            }
        }
    }

    @Override
    public boolean isVeiculoExist(Veiculo veiculo) {
        return findByModelo(veiculo.getModelo()) != null;
    }
}
