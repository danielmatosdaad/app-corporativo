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
import br.app.corporativo.integracao.dto.SenhaDTO;
import br.app.corporativo.integracao.interfaces.IServicoUsuarioSenhaLocal;
import br.app.corporativo.integracao.interfaces.IServicoUsuarioSenhaRemote;
import br.app.corporativo.usr.dao.SenhaFacade;
import br.app.corporativo.usr.model.Senha;

@Stateless
@Remote(value = { IServicoUsuarioSenhaRemote.class,IServicoRemoteDAO.class })
@Local(value = { IServicoUsuarioSenhaLocal.class,IServicoLocalDAO.class })
public class SenhaServiceImp implements IServicoUsuarioSenhaRemote, IServicoUsuarioSenhaLocal {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@EJB
	private SenhaFacade senhaFacede;

	@Override
	public SenhaDTO adiconar(SenhaDTO dto) throws InfraEstruturaException, NegocioException {
		try {
			return ServiceDAO.adiconar(this.senhaFacede, Senha.class, dto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}

	}

	@Override
	public List<SenhaDTO> adiconar(List<SenhaDTO> listaDto) throws InfraEstruturaException, NegocioException {
		try {
			return ServiceDAO.adiconar(this.senhaFacede, Senha.class, listaDto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public SenhaDTO alterar(SenhaDTO dto) throws InfraEstruturaException, NegocioException {
		try {
			return ServiceDAO.adiconar(this.senhaFacede, Senha.class, dto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public void remover(SenhaDTO dto) throws InfraEstruturaException, NegocioException {
		try {
			ServiceDAO.remover(this.senhaFacede, Senha.class, dto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}

	}

	@Override
	public void removerPorId(Long id) throws InfraEstruturaException, NegocioException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SenhaDTO> bustarTodos() throws InfraEstruturaException, NegocioException {
		try {
			return ServiceDAO.bustarTodos(this.senhaFacede, SenhaDTO.class);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public SenhaDTO bustarPorID(Long id) throws InfraEstruturaException, NegocioException {
		try {
			return ServiceDAO.bustarPorID(this.senhaFacede, SenhaDTO.class, id);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public List<SenhaDTO> bustarPorIntervaloID(int[] range) throws InfraEstruturaException, NegocioException {
		try {
			return ServiceDAO.bustarPorIntervaloID(this.senhaFacede, SenhaDTO.class, range);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}
	}

}
