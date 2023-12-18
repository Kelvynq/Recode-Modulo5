package com.superviagem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.superviagem.model.Viagem;
import com.superviagem.repositories.ViagemRepository;

@Service
public class ViagemService {
	

	@Autowired
	private ViagemRepository viagemRepository;

	public List<Viagem> getAllViagens() {
		return viagemRepository.findAll();
		}

	@Transactional(readOnly = true)
	public Viagem getViagemById(Long id_viagem) {
		return viagemRepository.findById(id_viagem).orElse(null);
	}

	@Transactional
	public Viagem saveViagem(Viagem viagem) {
		return viagemRepository.save(viagem);
	}

	public Viagem updateViagem(Long id_viagem, Viagem viagemAtualizado) {
		Viagem viagemExistente = viagemRepository.findById(id_viagem).orElse(null);
		if (viagemExistente != null) { 
			viagemExistente.setCidade(viagemAtualizado.getCidade());
			viagemExistente.setEstado(viagemAtualizado.getEstado());
			viagemExistente.setImg(viagemAtualizado.getImg());
			viagemExistente.setValor(viagemAtualizado.getValor());
			viagemExistente.setDescricao(viagemAtualizado.getDescricao());

			return viagemRepository.save(viagemExistente);
		} else { 
			throw new RuntimeException("Viagem com o ID" + id_viagem + "não encontrado.");
		}
	}

	public void deleteViagem(Long id_viagem) {
		viagemRepository.deleteById(id_viagem);
	}

}
