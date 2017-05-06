package br.corporativo.cta.service;

import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.app.corporativo.integracao.dto.ContaDTO;
import br.app.corporativo.integracao.interfaces.IServicoContaLocal;
import br.app.corporativo.integracao.interfaces.IServicoContaRemote;
import br.app.barramento.infra.persistencia.service.ServiceDAO;
import br.app.barramento.integracao.dao.interfaces.IServicoLocalDAO;
import br.app.barramento.integracao.dao.interfaces.IServicoRemoteDAO;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.corporativo.cta.dao.ContaFacade;
import br.corporativo.cta.model.Conta;

@Stateless
@Remote(value = { IServicoContaRemote.class,IServicoRemoteDAO.class })
@Local(value = { IServicoContaLocal.class,IServicoLocalDAO.class })
public class ContaServiceImp implements IServicoContaRemote, IServicoContaLocal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Logger log;

	@EJB
	ContaFacade contaFacade;

	@Override
	public ContaDTO adiconar(ContaDTO dto) throws InfraEstruturaException, NegocioException {
		try {
			
			return ServiceDAO.adiconar(this.contaFacade, Conta.class, dto);

		} catch (Exception e) {
			
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public List<ContaDTO> adiconar(List<ContaDTO> listaDto) throws InfraEstruturaException, NegocioException {
		try {
			
			return ServiceDAO.adiconar(this.contaFacade, Conta.class, listaDto);

		} catch (Exception e) {
			
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public ContaDTO alterar(ContaDTO dto) throws InfraEstruturaException, NegocioException {
		try {
			
			return ServiceDAO.alterar(this.contaFacade, Conta.class, dto);

		} catch (Exception e) {
			
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public void remover(ContaDTO dto) throws InfraEstruturaException, NegocioException {
		try {
			ServiceDAO.remover(this.contaFacade, Conta.class, dto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}

	}

	@Override
	public void removerPorId(Long id) throws InfraEstruturaException, NegocioException {
	

	}

	@Override
	public List<ContaDTO> bustarTodos() throws InfraEstruturaException, NegocioException {
		try {
			
			return ServiceDAO.bustarTodos(this.contaFacade, ContaDTO.class);

		} catch (Exception e) {
			
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public ContaDTO bustarPorID(Long id) throws InfraEstruturaException, NegocioException {
		try {
			
			return ServiceDAO.bustarPorID(this.contaFacade, ContaDTO.class,id);

		} catch (Exception e) {
			
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public List<ContaDTO> bustarPorIntervaloID(int[] range) throws InfraEstruturaException, NegocioException {
		try {
			
			return ServiceDAO.bustarPorIntervaloID(this.contaFacade, ContaDTO.class,range);

		} catch (Exception e) {
			
			throw new InfraEstruturaException(e);

		}
	}

}
