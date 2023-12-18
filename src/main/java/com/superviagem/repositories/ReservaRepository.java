package com.superviagem.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.superviagem.model.Reserva;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long>{
	

}
