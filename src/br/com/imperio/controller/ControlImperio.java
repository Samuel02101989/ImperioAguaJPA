package br.com.imperio.controller;

import java.util.List;
import java.util.Vector;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.table.DefaultTableModel;

import br.com.imperio.dao.CadastraPedidoDao;
import br.com.imperio.model.CadastraPedido;

public class ControlImperio {

	public List<CadastraPedido> findAllCadastraPedidos() {
		
		CadastraPedidoDao cadao = new CadastraPedidoDao();
		List<CadastraPedido> listado = cadao.findAll();

		return listado;
	}
	

}