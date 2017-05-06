package br.app.corporativo.usr.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.app.barramento.infra.persistencia.dao.AbstractFacade;
import br.app.corporativo.usr.model.Usuario;

@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> {

	public UsuarioFacade() {
		super(Usuario.class);
	}

	public UsuarioFacade(Class<Usuario> entityClass) {
		super(entityClass);
	}

	@PersistenceContext(unitName = "app-contexto-usr")
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}

	public List<Usuario> buscarTodos() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Usuario> criteria = cb.createQuery(Usuario.class);
		Root<Usuario> parametro = criteria.from(Usuario.class);
		CriteriaQuery<Usuario> todos = criteria.select(parametro);
		TypedQuery<Usuario> allQuery = em.createQuery(todos);

		List<Usuario> resultado = allQuery.getResultList();

		System.out.println("Quantidade todos? " + resultado.size());
		return resultado;
	}

	public Usuario buscarPorLogin(String login) {

		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM usuario u WHERE u.login = ?1", Usuario.class);
		return query.setParameter(1, login).getSingleResult();
	}
}
