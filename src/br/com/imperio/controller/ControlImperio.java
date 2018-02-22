package br.com.imperio.controller;

import java.util.List;
import java.util.Vector;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.table.DefaultTableModel;

import br.com.imperio.dao.CadastraPedidoDao;
import br.com.imperio.model.CadastraPedido;

public class ControlImperio {

	public void readJtable() {
		
		DefaultTableModel dadosTable = new DefaultTableModel();
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("imperioaguas");
		
		CadastraPedidoDao cadao = new CadastraPedidoDao();
		List<CadastraPedido> listado = cadao.findAll();

		for (CadastraPedido pedido : listado) {
			Vector<String> dados = pedido.convertVector();
			dadosTable.addRow(dados);
		}
		
	}
	

}