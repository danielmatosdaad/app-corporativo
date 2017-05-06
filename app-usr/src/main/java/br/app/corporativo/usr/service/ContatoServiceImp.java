package br.app.corporativo.usr.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.app.barramento.infra.persistencia.service.ServiceDAO;
import br.app.barramento.integracao.dao.interfaces.IServicoLocalDAO;
import br.app.barramento.integracao.dao.interfaces.IServicoRemoteDAO;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.corporativo.integracao.dto.ContatoDTO;
import br.app.corporativo.integracao.interfaces.IServicoUsuarioContatoLocal;
import br.app.corporativo.integracao.interfaces.IServicoUsuarioContatoRemote;
import br.app.corporativo.usr.dao.ContatoFacade;
import br.app.corporativo.usr.model.Contato;

@Stateless
@Remote(value = { IServicoUsuarioContatoRemote.class,IServicoRemoteDAO.class })
@Local(value = { IServicoUsuarioContatoLocal.class,IServicoLocalDAO.class})
public class ContatoServiceImp implements IServicoUsuarioContatoRemote, IServicoUsuarioContatoLocal {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private ContatoFacade contatoFacade;

	@Override
	public ContatoDTO adiconar(ContatoDTO dto) throws InfraEstruturaException, NegocioException {
		try {
			return ServiceDAO.adiconar(this.contatoFacade, Contato.class, dto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public List<ContatoDTO> adiconar(List<ContatoDTO> listaDto) throws InfraEstruturaException, NegocioException {
		try {
			return ServiceDAO.adiconar(this.contatoFacade, Contato.class, listaDto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public ContatoDTO alterar(ContatoDTO dto) throws InfraEstruturaException, NegocioException {
		try {
			return ServiceDAO.alterar(this.contatoFacade, Contato.class, dto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public void remover(ContatoDTO dto) throws InfraEstruturaException, NegocioException {
		try {
			ServiceDAO.remover(this.contatoFacade, Contato.class, dto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}

	}

	@Override
	public void removerPorId(Long id) throws InfraEstruturaException, NegocioException {
	

	}

	@Override
	public List<ContatoDTO> bustarTodos() throws InfraEstruturaException, NegocioException {
		try {
			return ServiceDAO.bustarTodos(this.contatoFacade, ContatoDTO.class);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public ContatoDTO bustarPorID(Long id) throws InfraEstruturaException, NegocioException {
		try {
			return ServiceDAO.bustarPorID(this.contatoFacade, ContatoDTO.class,id);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public List<ContatoDTO> bustarPorIntervaloID(int[] range) throws InfraEstruturaException, NegocioException {
		try {
			return ServiceDAO.bustarPorIntervaloID(this.contatoFacade, ContatoDTO.class,range);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}
	}

}
