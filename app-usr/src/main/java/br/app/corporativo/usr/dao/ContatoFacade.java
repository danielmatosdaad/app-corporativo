package br.app.corporativo.usr.dao;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import br.app.barramento.infra.persistencia.dao.AbstractFacade;
import br.app.barramento.infra.persistencia.dao.IFacedeDAO;
import br.app.corporativo.usr.model.Contato;

@Stateless
public class ContatoFacade extends AbstractFacade<Contato> implements IFacedeDAO<Contato>{

	public ContatoFacade() {
		super(Contato.class);
	}

	public ContatoFacade(Class<Contato> entityClass) {
		super(entityClass);
	}
	

	@PersistenceContext(unitName = "app-contexto-usr")
	private EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}

	
}
