package br.com.gerenciamentosimples.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.gerenciamentosimples.model.Entrada;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Integer> {
    
}