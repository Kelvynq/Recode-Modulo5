package com.superviagem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import com.superviagem.model.Reserva;
import com.superviagem.repositories.ReservaRepository;
import com.superviagem.services.ReservaService;


@Service
public class ReservaService {
	
	@Autowired
	private ReservaRepository reservaRepository;
	
	public List<Reserva> getAllReservas() {
		return reservaRepository.findAll();
		}
	
	@Transactional
	public Reserva saveReserva(Reserva reserva) {	
		return reservaRepository.save(reserva);
	}

	@Transactional()
	public Reserva getReservaById(Long id_reserva) {
		return reservaRepository.findById(id_reserva).orElse(null);
	}
	
	public Reserva updateReserva(Long id_reserva, Reserva reservaAtualizada) {
		Reserva reservaExistente = reservaRepository.findById(id_reserva).orElse(null);
		if (reservaExistente != null) { 
			reservaExistente.setCheckin(reservaAtualizada.getCheckin()); 
			reservaExistente.setCheckout(reservaAtualizada.getCheckout()); 
			reservaExistente.setId(reservaAtualizada.getUsuario().getId());
			reservaExistente.setID_viagem(reservaAtualizada.getViagem().getId_viagem()); 

			return reservaRepository.save(reservaExistente);
		} else { 
			throw new RuntimeException("Reserva com o ID" + id_reserva + "não encontrado.");
		}
	}
	
	
	

}