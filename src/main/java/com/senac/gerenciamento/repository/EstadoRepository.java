package com.senac.gerenciamento.repository;

import com.senac.gerenciamento.model.Estado;
import com.senac.gerenciamento.model.Pais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {

    List<Estado> findByNome(String nome);

    List<Estado> findBySigla(String sigla);

}
