package br.com.imperio.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "cadastrapedido_seq", sequenceName = "cadastrapedido_seq",
initialValue = 1, allocationSize = 1)
public class CadastraPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cadastrapedido_seq")
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
	private Date Data;
	public Date getData() {
		return Data;
	}
	public void setData(Date data) {
		Data = data;
	}
	private String situacao;
}
