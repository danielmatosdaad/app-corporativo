package br.corporativo.cta.dao;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
	

}
