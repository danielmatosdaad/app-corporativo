package br.corporativo.cta.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.app.barramento.infra.persistencia.dao.AbstractFacade;
import br.corporativo.cta.model.Assinatura;

@Stateless
public class AssinaturaFacade extends AbstractFacade<Assinatura> {

	public AssinaturaFacade() {
		super(Assinatura.class);
	}

	public AssinaturaFacade(Class<Assinatura> entityClass) {
		super(entityClass);
	}

	@PersistenceContext(unitName = "app-contexto-cta")
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}
	
	public List<Assinatura> buscarTodos() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Assinatura> criteria = cb.createQuery(Assinatura.class);
		Root<Assinatura> parametro = criteria.from(Assinatura.class);
		CriteriaQuery<Assinatura> todos = criteria.select(parametro);
		TypedQuery<Assinatura> allQuery = em.createQuery(todos);
		
		List<Assinatura> resultado = allQuery.getResultList();
		
		System.out.println("Quantidade Assinatura: " + resultado.size());
		return resultado;
	}

}