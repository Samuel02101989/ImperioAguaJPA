package br.com.imperio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produtos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long IdProduto;

	public Long getIdProduto() {
		return IdProduto;
	}

	public void setIdProduto(Long idProduto) {
		IdProduto = idProduto;
	}

	public String getNomeProd() {
		return nomeProd;
	}

	public void setNomeProd(String nomeProd) {
		this.nomeProd = nomeProd;
	}

	public String getQuantProd() {
		return quantProd;
	}

	public void setQuantProd(String quantProd) {
		this.quantProd = quantProd;
	}

	public String getPrecoProd() {
		return precoProd;
	}

	public void setPrecoProd(String precoProd) {
		this.precoProd = precoProd;
	}

	public String nomeProd;
	public String quantProd;
	public String precoProd;
	public String precounit;
	public String dataEntrega;
	public String placa;
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(String veiculo) {
		this.veiculo = veiculo;
	}

	public String veiculo;

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		dataEntrega = dataEntrega;
	}

	public String getPrecounit() {
		return precounit;
	}

	public void setPrecounit(String precounit) {
		this.precounit = precounit;
	}

}
