package br.com.imperio.dao;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import br.com.imperio.model.Produtos;

public class ProdutosDao {

	private static ProdutosDao instance;
	protected EntityManager entityManager;

	public static ProdutosDao getInstance() {
		if (instance == null) {
			instance = new ProdutosDao();
		}
		return instance;
	}

	public ProdutosDao() {
		entityManager = getEM();
	}

	private EntityManager getEM() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("imperioaguas");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}

	// Metodo salvar
	public Produtos salvar(Produtos produtos) throws Exception {
		EntityManager em = getEM();
		try {
			em.getTransaction().begin();
			if (produtos.getIdProduto() == null) {
				em.persist(produtos); // executa o insert
			} else {
				if (!em.contains(produtos)) {
					if (em.find(Produtos.class, produtos.getIdProduto()) == null) {
						throw new Exception("Erro ao atualizar Produto");
					}
				}
				em.merge(produtos);
			}
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return produtos;
	}

	// Metodo busca por idProduto
	public Produtos getByIdProdutos(final Long idProduto) {
		Produtos produto = new Produtos();
		try {
			if (idProduto != null && !idProduto.toString().isEmpty()) {
				String jpql = "Select a from Produtos a where a.idProduto = :idProd";
				Query query = (Query) entityManager.createQuery(jpql);
				((javax.persistence.Query) query).setParameter("idProd", idProduto);
				@SuppressWarnings("unchecked")
				List<Produtos> produtoResult = ((javax.persistence.Query) query).getResultList();
				produto = produtoResult.get(0);

			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Produto nao encontrado");
		}
		return produto;
	}

	// Metodo remove
	public void remove(Long idProduto) {
		EntityManager em = getEM();
		Produtos produto = em.find(Produtos.class, idProduto);
		try {
			em.getTransaction().begin();
			em.remove(produto); // executa o delete
			em.getTransaction().commit();
		} finally {
			em.close();
		}

	}
}
