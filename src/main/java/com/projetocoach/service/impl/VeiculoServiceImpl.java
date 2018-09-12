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
        for (Veiculo user : veiculos) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public Veiculo findByModelo(String name) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getModelo()
                       .equalsIgnoreCase(name)) {
                return veiculo;
            }
        }
        return null;
    }


    public void saveVeiculo(Veiculo user) {
        user.setId(counter.incrementAndGet());
        veiculos.add(user);
    }

    public void updateVeiculo(Veiculo user) {
        int index = veiculos.indexOf(user);
        veiculos.set(index, user);
    }

    public void deleteVeiculoById(long id) {
        for (Iterator<Veiculo> iterator = veiculos.iterator(); iterator.hasNext(); ) {
            Veiculo user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
            }
        }
    }

    public void deleteAllVeiculos() {
        veiculos.clear();
    }

    @Override
    public boolean isVeiculoExist(Veiculo veiculo) {
        return findByModelo(veiculo.getModelo()) != null;
    }
}
