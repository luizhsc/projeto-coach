package com.projetocoach.repository;

import com.projetocoach.models.Veiculo;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, String> {




}



