package br.com.imperio.dao;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.com.imperio.model.CadastraPedido;

public class CadastraPedidoDao {

	private static CadastraPedidoDao instance;
	protected EntityManager entityManager;

	public static CadastraPedidoDao getInstance() {
		if (instance == null) {
			instance = new CadastraPedidoDao();
		}
		return instance;
	}

	public CadastraPedidoDao() {
		entityManager = getEM();
	}

	private EntityManager getEM() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("imperioaguas");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}

	// Metodo de salvar e atualizar Cliente
	public CadastraPedido salvar(CadastraPedido cad) throws Exception {
		EntityManager em = getEM();
		try {
			em.getTransaction().begin();
			if (cad.getIdCadastro() == null) {
				em.persist(cad); // executa o insert
			} else {
				if (!em.contains(cad)) {
					if (em.find(CadastraPedido.class, cad.getIdCadastro()) == null) {
						throw new Exception("Erro ao atualizar cliente");
					}
				}
				cad = em.merge(cad); // executa o update
			}
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return cad;
	}
	// Metodo de busca por ID

	public CadastraPedido getByidCli(final Long idCadastro) {
		CadastraPedido cad = new CadastraPedido();

		try {
			if (idCadastro != null && !idCadastro.toString().isEmpty()) {
				String jpql = "Select a from CadastroPedido a where a.idCadastro = :idcad";
				Query query = (Query) entityManager.createQuery(jpql);
				((javax.persistence.Query) query).setParameter("idcad", idCadastro);
				@SuppressWarnings("unchecked")
				List<CadastraPedido> cadastroResult = ((javax.persistence.Query) query).getResultList();

				cad = cadastroResult.get(0);

			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Cliente Inexistente");
		}
		return cad;
	}

	@SuppressWarnings("unchecked")
	public List<CadastraPedido> findAll() {
		CadastraPedido cadastra = new CadastraPedido();
		try {
			String jpql = "Select * from CadastraPedido";
			Query query = (Query) entityManager.createQuery(jpql);
			List<CadastraPedido> cadastraResult = ((javax.persistence.Query) query).getResultList();
			cadastra = cadastraResult.get(0);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Tabela nao encontrada");
		}
		return (List<CadastraPedido>) cadastra;
	}

	public void remove(Long idCadastro) {
		EntityManager em = getEM();
		CadastraPedido cad = em.find(CadastraPedido.class, idCadastro);
		try {
			em.getTransaction().begin();
			em.remove(cad); // executa o delete
			em.getTransaction().commit();
		} finally {
			em.close();
		}
	}
}
