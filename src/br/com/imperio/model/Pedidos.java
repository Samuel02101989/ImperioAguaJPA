package br.com.imperio.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pedidos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Comanda;
	public Long getComanda() {
		return Comanda;
	}
	public void setComanda(Long comanda) {
		Comanda = comanda;
	}
	public String getCliente() {
		return Cliente;
	}
	public void setCliente(String cliente) {
		Cliente = cliente;
	}
	public String getProduto() {
		return Produto;
	}
	public void setProduto(String produto) {
		Produto = produto;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getSitua�ao() {
		return situa�ao;
	}
	public void setSitua�ao(String situa�ao) {
		this.situa�ao = situa�ao;
	}
	private String Cliente;
	private String Produto;
	private Date data;
	private String situa�ao;

}
