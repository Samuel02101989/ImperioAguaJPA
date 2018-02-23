package br.com.imperio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity

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

	public CadastraPedido(String ruaAguas,int numeroAguas,String nomeAguas,String valorAguas,String dataAguas,String situacao){
		this.ruaAguas = ruaAguas;
		this.numeroAguas = numeroAguas;
		this.nomeAguas = nomeAguas;
		this.valorAguas = valorAguas;
		this.dataAguas = dataAguas;
		this.situacao = situacao;
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
	/*public Vector<String> ObterDados() {
		Vector<String> dados = new Vector<String>();
		dados.addElement(Rua);
		dados.addElement(Numero);
		dados.addElement(valor);
		dados.addElement(Data);
		dados.addElement(Nome);
		dados.addElement(situacao);
		return dados;
	}*/
	public Object[] obterDados(){
		return new Object[]{ruaAguas, numeroAguas, valorAguas, dataAguas, nomeAguas, situacao};

}
}
