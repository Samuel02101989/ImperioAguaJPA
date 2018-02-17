package br.com.imperio.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity

public class CadastraPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long IdCadastro;
	public Long getIdCadastro() {
		return IdCadastro;
	}
	public void setIdCadastro(Long idCadastro) {
		IdCadastro = idCadastro;
	}
	public String getRua() {
		return Rua;
	}
	public void setRua(String rua) {
		Rua = rua;
	}
	public String getNumero() {
		return Numero;
	}
	public void setNumero(String numero) {
		Numero = numero;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	private String Rua;
	private String Numero;
	private String Nome;
	private String valor;
	private String Data;
	public String getData() {
		return Data;
	}
	public void setData(String string) {
		Data = string;
	}
	private String situacao;
}
