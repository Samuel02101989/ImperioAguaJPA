package br.com.imperio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import br.com.imperio.model.Usuario;

public class UsuarioDao {

	private static UsuarioDao instance;
	protected EntityManager entityManager;

	public static UsuarioDao getInstance() {
		if (instance == null) {
			instance = new UsuarioDao();
		}
		return instance;
	}

	public UsuarioDao() {
		entityManager = getEM();
	}

	private EntityManager getEM() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("Marmitaria");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}
		return entityManager;
	}

	// Metodo salvar Usuario
	public Usuario salvar(Usuario usuario) throws Exception {
		EntityManager em = getEM();
		try {
			em.getTransaction().begin();
			if (usuario.getIdUsuario() == null) {
				em.persist(usuario);// executa o insert
			} else {
				if (!em.contains(usuario)) {
					if (em.find(Usuario.class, usuario.getIdUsuario()) == null) {
						throw new Exception("Usuario nao cadastrado");
					}
				}
				em.merge(usuario);
			}
			em.getTransaction().commit();
		} finally {
			em.close();
		}
		return usuario;
	}

	// metodo busca Usuario
	public Usuario getByIdUsuario(final Long idUsuario) {
		Usuario usuario = new Usuario();
		try {
			if (idUsuario != null && !idUsuario.toString().isEmpty()) {
				String jpql = "Select a from Usuario a where a.idUsuario = :idUsu";
				Query query = entityManager.createQuery(jpql);
				query.setParameter("idUSU", idUsuario);
				@SuppressWarnings("unchecked")
				List<Usuario> usuarioResult = query.getResultList();

				usuario = usuarioResult.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Usuario nao encontrado");
		}
		return usuario;

	}
}
