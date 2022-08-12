package com.aulas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aulas.entidades.Comida;

@Repository
public interface ComidaRepository extends JpaRepository<Comida, Long> {
	
}
