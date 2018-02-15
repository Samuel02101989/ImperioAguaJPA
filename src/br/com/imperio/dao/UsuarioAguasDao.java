package br.com.imperio.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;

import br.com.imperio.model.Usuario;

public class UsuarioAguasDao {

	private static UsuarioAguasDao instance;
	protected EntityManager entityManager;

	public static UsuarioAguasDao getInstance() {
		if (instance == null) {
			instance = new UsuarioAguasDao();
		}
		return instance;
	}

	public UsuarioAguasDao() {
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

	public boolean getByLogo(String loginUsu, String senhaUsu) {
		if ((loginUsu != null && !loginUsu.isEmpty()) && (senhaUsu != null && !senhaUsu.isEmpty())) {

			String login = loginUsu.trim().toLowerCase();
			String senha = senhaUsu.trim().toLowerCase();
			String jpql = "select u from Usuario u where u.loginUsu = :user AND u.senhaUsu = :senha";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("user", login);
			query.setParameter("senha", senha);
			@SuppressWarnings("unchecked")
			List<Usuario> usuarioResult = query.getResultList();
			if (usuarioResult.get(0) != null) {
				return true;

			} else {
				return false;
			}
		}
		return false;
	}

	public void remove(Usuario usuario) {

		try {
			entityManager.getTransaction().begin();
			usuario = entityManager.find(Usuario.class, usuario.getIdUsuario());
			entityManager.remove(usuario);
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}
}
