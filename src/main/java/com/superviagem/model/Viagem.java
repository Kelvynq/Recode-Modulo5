package com.superviagem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "viagem")
public class Viagem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_viagem;
	
	private String cidade;
	private String estado;
	private String img;
	private float valor;
	@Column(columnDefinition = "TEXT")
	private String descricao;
	
	public Viagem(Long id_viagem, String cidade, String estado, String img, float valor, String descricao) {
		super();
		this.id_viagem = id_viagem;
		this.cidade = cidade;
		this.estado = estado;
		this.img = img;
		this.valor = valor;
		this.descricao = descricao;
	}

	public Viagem() {
		super();
	}
	
	public Long getId_viagem() {
		return id_viagem;
	}
	public void setId_viagem(Long id_viagem) {
		this.id_viagem = id_viagem;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}