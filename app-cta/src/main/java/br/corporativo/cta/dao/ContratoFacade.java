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
import br.corporativo.cta.model.Contrato;

@Stateless
public class ContratoFacade extends AbstractFacade<Contrato> {

	
	public ContratoFacade() {
		super(Contrato.class);
	}
	
	public ContratoFacade(Class<Contrato> entityClass) {
		super(entityClass);
	}

	@PersistenceContext(unitName = "app-contexto-cta")
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}
	
	public List<Contrato> buscarTodos() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Contrato> criteria = cb.createQuery(Contrato.class);
		Root<Contrato> parametro = criteria.from(Contrato.class);
		CriteriaQuery<Contrato> todos = criteria.select(parametro);
		TypedQuery<Contrato> allQuery = em.createQuery(todos);
		
		List<Contrato> resultado = allQuery.getResultList();
		
		System.out.println("Quantidade Contratatos: " + resultado.size());
		return resultado;
	}

}
