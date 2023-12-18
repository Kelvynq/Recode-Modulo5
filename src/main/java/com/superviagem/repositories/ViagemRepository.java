package com.superviagem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.superviagem.model.Viagem;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Long>{

}
