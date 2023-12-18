package com.superviagem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.superviagem.model.Viagem;
import com.superviagem.services.ViagemService;

@Controller
@RequestMapping("/viagens")
public class ViagemController {


	@Autowired
	private ViagemService viagemService;
	
	
	// Listar
			@GetMapping
			public String listViagens(Model model) {
				List<Viagem> viagens = viagemService.getAllViagens();
				model.addAttribute("viagens", viagens);
				return "viagens/ListarViagens";
			}

			// Formulário de criação
			@GetMapping("/novo")
			public String showFormForAdd(Model model) {
				Viagem viagem = new Viagem();
				model.addAttribute("viagem", viagem);
				return "viagens/viagemForm";
			}

			// Persistencia da criação
			@PostMapping("/save")
			public String saveViagem(@ModelAttribute("viagem") Viagem viagem) {
				viagemService.saveViagem(viagem);
				return "redirect:/viagens";
			}

			// Formulário de edição
			@GetMapping("/editar/{id_viagem}")
			public String showFormForUpdate(@PathVariable Long id_viagem, Model model) {
				Viagem viagem = viagemService.getViagemById(id_viagem);
				model.addAttribute("viagem", viagem);
				return "viagens/editarViagem";
			}

			// Persistencia da edição
			@PostMapping("/editar/{id_viagem}")
			public String updateViagem(@PathVariable Long id_viagem, @ModelAttribute("viagem") 
			Viagem viagem) {
				viagemService.updateViagem(id_viagem, viagem);
				return "redirect:/viagens";
			}
			
			// Excluir categoria
			@GetMapping("/deletar/{id_viagem}")
			public String deleteViagem(@PathVariable Long id_viagem) { 
				
			
				viagemService.deleteViagem(id_viagem);
				return "redirect:/viagens";
			}
}
