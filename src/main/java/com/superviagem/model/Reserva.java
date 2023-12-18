package com.superviagem.model;


import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "reserva")
public class Reserva {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id_reserva;

		@Column(name = "data_checkin")
		@DateTimeFormat(iso = ISO.DATE)
		private LocalDate checkin;
		
		@Column(name = "data_checkout")
		@DateTimeFormat(iso = ISO.DATE)
		private LocalDate checkout;

		@ManyToOne
		@JoinColumn(name = "id", nullable = false)
		private Usuario usuario;

		@ManyToOne
		@JoinColumn(name = "id_viagem", nullable = false)
		private Viagem viagem;

		public Reserva(Long id_reserva, LocalDate checkin, LocalDate checkout, Usuario usuario, Viagem viagem) {
			super();
			this.id_reserva = id_reserva;
			this.checkin = checkin;
			this.checkout = checkout;
			this.usuario = usuario;
			this.viagem = viagem;
		}
		
		public Reserva() {
			super();
			
		}

		public void setId(Long id) {
			if (usuario == null) {
				usuario = new Usuario();
			}
			usuario.setId(id);
		}

		public void setID_viagem(Long id_viagem) {
			if (viagem == null) {
				viagem = new Viagem();
			}
			viagem.setId_viagem(id_viagem);
		}

		public Long getId_reserva() {
			return id_reserva;
		}

		public void setId_reserva(Long id_reserva) {
			this.id_reserva = id_reserva;
		}

		public LocalDate getCheckin() {
			return checkin;
		}

		public void setCheckin(LocalDate checkin) {
			this.checkin = checkin;
		}

		public LocalDate getCheckout() {
			return checkout;
		}

		public void setCheckout(LocalDate checkout) {
			this.checkout = checkout;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

		public Viagem getViagem() {
			return viagem;
		}

		public void setViagem(Viagem viagem) {
			this.viagem = viagem;
		}
	}
