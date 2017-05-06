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
import br.app.corporativo.usr.model.Senha;

@Stateless
public class SenhaFacade extends AbstractFacade<Senha> {

	public SenhaFacade() {
		super(Senha.class);
	}

	public SenhaFacade(Class<Senha> entityClass) {
		super(entityClass);
	}
	

	@PersistenceContext(unitName = "app-contexto-usr")
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}


	public List<Senha> buscarTodos() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Senha> criteria = cb.createQuery(Senha.class);
		Root<Senha> parametro = criteria.from(Senha.class);
		CriteriaQuery<Senha> todos = criteria.select(parametro);
		TypedQuery<Senha> allQuery = em.createQuery(todos);
		
		List<Senha> resultado = allQuery.getResultList();
		
		System.out.println("Quantidade todos? " + resultado.size());
		return resultado;
	}
}
