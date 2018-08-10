package com.projetocoach.repository;

import com.projetocoach.models.Veiculo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends CrudRepository<Veiculo, String> {

    Veiculo findById(int id);
}
