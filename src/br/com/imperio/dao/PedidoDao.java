package br.com.imperio.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import br.com.imperio.model.Pedidos;

public class PedidoDao {

	private static PedidoDao instance;
	protected EntityManager entityManager;
	
	public static PedidoDao getInstance(){
		if(instance == null){
			instance = new PedidoDao();
		}
		return instance;
	}
	public PedidoDao(){
		entityManager = getEM();
	}
	private EntityManager getEM(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Marmitaria");
		if(entityManager == null){
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}

	public void preencher_Tabela(){
		
		
		try {
			SessionFactory tabela = new Configuration().configure().buildSessionFactory();
			Session sessao = tabela.openSession();
			
			List<Pedidos> lista_pedidos = new ArrayList();
			lista_pedidos = sessao.createQuery("from Pedidos").list();
			int tamanho_lista = lista_pedidos.size();
			String dados = "";
			for(int i=0; i < tamanho_lista; i++){
				Pedidos pedido = lista_pedidos.get(i);
				
			}
			
		} catch (Exception e) {
			
		}
	
		
		
	}
}
