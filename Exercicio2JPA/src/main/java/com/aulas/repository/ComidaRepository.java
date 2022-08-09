package com.aulas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aulas.entidades.Comida;

@Repository
public interface ComidaRepository extends CrudRepository<Comida, Integer>{

}
