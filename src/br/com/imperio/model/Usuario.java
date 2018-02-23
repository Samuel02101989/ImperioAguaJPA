package br.com.imperio.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdUsuario;
	public Long getIdUsuario() {
		return IdUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		IdUsuario = idUsuario;
	}
	public String getNomeUsu() {
		return nomeUsu;
	}
	public void setNomeUsu(String nomeUsu) {
		this.nomeUsu = nomeUsu;
	}
	public String getLoginUsu() {
		return loginUsu;
	}
	public void setLoginUsu(String loginUsu) {
		this.loginUsu = loginUsu;
	}
	public String getSenhaUsu() {
		return senhaUsu;
	}
	public void setSenhaUsu(String senhaUsu) {
		this.senhaUsu = senhaUsu;
	}
	public String getTipoUsu() {
		return tipoUsu;
	}
	public void setTipoUsu(String tipoUsu) {
		this.tipoUsu = tipoUsu;
	}
	public String nomeUsu;
	public String loginUsu;
	public String senhaUsu;
	public String tipoUsu;
}
