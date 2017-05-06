package br.corporativo.cta.service;

import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.app.corporativo.integracao.dto.ContratoDTO;
import br.app.corporativo.integracao.interfaces.IServicoContratoLocal;
import br.app.corporativo.integracao.interfaces.IServicoContratoRemote;
import br.app.barramento.infra.persistencia.service.ServiceDAO;
import br.app.barramento.integracao.dao.interfaces.IServicoLocalDAO;
import br.app.barramento.integracao.dao.interfaces.IServicoRemoteDAO;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.corporativo.cta.dao.ContratoFacade;
import br.corporativo.cta.model.Contrato;

@Stateless
@Remote(value = { IServicoContratoRemote.class,IServicoRemoteDAO.class })
@Local(value = { IServicoContratoLocal.class,IServicoLocalDAO.class })
public class ContratoServiceImp implements IServicoContratoRemote, IServicoContratoLocal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Logger log;

	@EJB
	private ContratoFacade contratoFacade;

	@Override
	public ContratoDTO adiconar(ContratoDTO dto) throws InfraEstruturaException, NegocioException {
		try {
			return ServiceDAO.adiconar(this.contratoFacade, Contrato.class, dto);

		} catch (Exception e) {
			
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public List<ContratoDTO> adiconar(List<ContratoDTO> listaDto) throws InfraEstruturaException, NegocioException {
		try {
			
			return ServiceDAO.adiconar(this.contratoFacade, Contrato.class, listaDto);

		} catch (Exception e) {
			
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public ContratoDTO alterar(ContratoDTO dto) throws InfraEstruturaException, NegocioException {
		try {
			
			return ServiceDAO.alterar(this.contratoFacade, Contrato.class, dto);

		} catch (Exception e) {
			
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public void remover(ContratoDTO dto) throws InfraEstruturaException, NegocioException {
		try {
			
			ServiceDAO.remover(this.contratoFacade, Contrato.class, dto);

		} catch (Exception e) {
			
			throw new InfraEstruturaException(e);

		}

	}

	@Override
	public void removerPorId(Long id) throws InfraEstruturaException, NegocioException {
	

	}

	@Override
	public List<ContratoDTO> bustarTodos() throws InfraEstruturaException, NegocioException {
		try {
			
			return ServiceDAO.bustarTodos(this.contratoFacade, ContratoDTO.class);

		} catch (Exception e) {
			
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public ContratoDTO bustarPorID(Long id) throws InfraEstruturaException, NegocioException {
		try {
			
			return ServiceDAO.bustarPorID(this.contratoFacade, ContratoDTO.class,id);

		} catch (Exception e) {
			
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public List<ContratoDTO> bustarPorIntervaloID(int[] range) throws InfraEstruturaException, NegocioException {
		try {
			
			return ServiceDAO.bustarPorIntervaloID(this.contratoFacade, ContratoDTO.class,range);

		} catch (Exception e) {
			
			throw new InfraEstruturaException(e);

		}
	}

}
