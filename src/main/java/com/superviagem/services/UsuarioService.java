package com.superviagem.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.superviagem.model.Usuario;
import com.superviagem.repositories.UsuarioRepository;
import com.superviagem.services.UsuarioService;

@Service
public class UsuarioService{
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> getAllUsuarios() {
		return usuarioRepository.findAll();
		}

	@Transactional(readOnly = true)
	public Usuario getUsuarioById(Long id) {
		return usuarioRepository.findById(id).orElse(null);
	}

	@Transactional
	public Usuario saveUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public Usuario updateUsuario(Long id, Usuario usuarioAtualizado) {
		Usuario usuarioExistente = usuarioRepository.findById(id).orElse(null);
		if (usuarioExistente != null) { 
			usuarioExistente.setNome(usuarioAtualizado.getNome());
			usuarioExistente.setTelefone(usuarioAtualizado.getTelefone());
			usuarioExistente.setNome_usuario(usuarioAtualizado.getNome_usuario());
			usuarioExistente.setSenha(usuarioAtualizado.getSenha());
			usuarioExistente.setEmail(usuarioAtualizado.getEmail());

			return usuarioRepository.save(usuarioExistente);
		} else { 
			throw new RuntimeException("Usuário com o ID" + id + "não encontrado.");
		}
	}

	public void deleteUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}

}

