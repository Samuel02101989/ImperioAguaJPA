package br.com.imperio.model;

import java.util.Date;
import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name="Cadastra_Pedido")

public class CadastraPedido {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long IdCadastro;
	private String ruaAguas;
	private int numeroAguas;
	private String nomeAguas;
	private String valorAguas;
	private String dataAguas;
	private String situacao;
	private String hora;

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public CadastraPedido(String ruaAguas, int numeroAguas, String nomeAguas, String valorAguas, String dataAguas,
			String situacao, String hora) {
		this.ruaAguas = ruaAguas;
		this.numeroAguas = numeroAguas;
		this.nomeAguas = nomeAguas;
		this.valorAguas = valorAguas;
		this.dataAguas = dataAguas;
		this.situacao = situacao;
		this.hora = hora;
	}

	public Long getIdCadastro() {
		return IdCadastro;
	}

	public void setIdCadastro(Long idCadastro) {
		IdCadastro = idCadastro;
	}

	public String getRua() {
		return ruaAguas;
	}

	public void setRua(String rua) {
		rua = rua;
	}

	public int getNumero() {
		return numeroAguas;
	}

	public void setNumero(int numero) {
		numero = numero;
	}

	public String getNome() {
		return nomeAguas;
	}

	public void setNome(String nome) {
		nome = nome;
	}

	public String getValor() {
		return valorAguas;
	}

	public void setValor(String valor) {
		this.valorAguas = valor;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public String getData() {
		return dataAguas;
	}

	public void setData(String string) {
		dataAguas = string;
	}

	// metodo para retornar um array com os dados do pedidos
	/*
	 * public Vector<String> ObterDados() { Vector<String> dados = new
	 * Vector<String>(); 
	 * dados.addElement(ruaAguas); 
	 * dados.add(numeroAguas,null); 
	 * dados.addElement(valorAguas); 
	 * dados.addElement(dataAguas);
	 * dados.addElement(nomeAguas); 
	 * dados.addElement(situacao); 
	 * return dados; }
	 */
	public Object[] obterDados() {
		return new Object[] { ruaAguas, numeroAguas, valorAguas, dataAguas,hora, nomeAguas, situacao };

	}
}
