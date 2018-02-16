package br.com.imperio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "produtos_seq", sequenceName = "produtos_seq",
initialValue = 1, allocationSize = 1)
public class Produtos {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produtos_seq")
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

	public String getPrecounit() {
		return precounit;
	}

	public void setPrecounit(String precounit) {
		this.precounit = precounit;
	}

}
