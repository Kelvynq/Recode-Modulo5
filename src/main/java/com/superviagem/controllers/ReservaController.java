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

import com.superviagem.model.Reserva;
import com.superviagem.services.ReservaService;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

	@Autowired
	private ReservaService reservaService;

	// Listar
	@GetMapping
	public String listReservas(Model model) {
		List<Reserva> reservas = reservaService.getAllReservas();
		model.addAttribute("reservas", reservas);
		return "reservas/listarReservas";
	}

	// Formulário de criação
	@GetMapping("/novo")
	public String showFormForAdd(Model model) {
		Reserva reserva = new Reserva();
		model.addAttribute("reserva", reserva);
		return "reservas/reservaForm";
	}

	// Persistencia da criação
	@PostMapping("/save")
	public String saveReserva(@ModelAttribute("reserva") Reserva reserva) {
		reservaService.saveReserva(reserva);
		return "redirect:/reservas";
	}
	
	// Formulário de edição
			@GetMapping("/editar/{id_reserva}")
			public String showFormForUpdate(@PathVariable Long id_reserva, Model model) {
				Reserva reserva = reservaService.getReservaById(id_reserva);
				model.addAttribute("reserva", reserva);
				return "reservas/editarReserva";
			}

	// Persistencia da edição
	@PostMapping("/editar/{id_reserva}")
	public String updateReserva(@PathVariable Long id_reserva, @ModelAttribute("reserva") Reserva reserva) {
		reservaService.updateReserva(id_reserva, reserva);
		return "redirect:/reservas";
	}

}
