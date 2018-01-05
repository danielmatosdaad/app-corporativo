package br.corporativo.cta.service;

import java.util.List;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;

import br.app.corporativo.integracao.dto.AssinaturaDTO;
import br.app.corporativo.integracao.interfaces.IServicoAssinaturaLocal;
import br.app.corporativo.integracao.interfaces.IServicoAssinaturaRemote;
import br.app.barramento.infra.persistencia.service.ServiceDAO;
import br.app.barramento.integracao.dao.interfaces.IServicoLocalDAO;
import br.app.barramento.integracao.dao.interfaces.IServicoRemoteDAO;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.corporativo.cta.dao.AssinaturaFacade;
import br.corporativo.cta.model.Assinatura;

@Stateless
@Remote(value = { IServicoAssinaturaRemote.class, IServicoRemoteDAO.class })
@Local(value = { IServicoAssinaturaLocal.class, IServicoLocalDAO.class })
public class AssinaturaServiceImp implements IServicoAssinaturaRemote, IServicoAssinaturaLocal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private Logger log;

	@EJB
	private AssinaturaFacade assinaturaFacade;

	@Override
	public AssinaturaDTO adiconar(AssinaturaDTO dto) throws InfraEstruturaException, NegocioException {
		try {
			return ServiceDAO.adiconar(this.assinaturaFacade, Assinatura.class, dto);

		} catch (Exception e) {

			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public List<AssinaturaDTO> adiconar(List<AssinaturaDTO> listaDto) throws InfraEstruturaException, NegocioException {
		try {

			return ServiceDAO.adiconar(this.assinaturaFacade, Assinatura.class, listaDto);

		} catch (Exception e) {

			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public AssinaturaDTO alterar(AssinaturaDTO dto) throws InfraEstruturaException, NegocioException {
		try {

			return ServiceDAO.alterar(this.assinaturaFacade, Assinatura.class, dto);

		} catch (Exception e) {

			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public void remover(AssinaturaDTO dto) throws InfraEstruturaException, NegocioException {
		try {

			ServiceDAO.remover(this.assinaturaFacade, Assinatura.class, dto);

		} catch (Exception e) {

			throw new InfraEstruturaException(e);

		}

	}

	@Override
	public List<AssinaturaDTO> bustarTodos() throws InfraEstruturaException, NegocioException {
		try {

			return ServiceDAO.bustarTodos(this.assinaturaFacade, AssinaturaDTO.class);

		} catch (Exception e) {

			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public AssinaturaDTO bustarPorID(Long id) throws InfraEstruturaException, NegocioException {
		try {

			return ServiceDAO.bustarPorID(this.assinaturaFacade, AssinaturaDTO.class, id);

		} catch (Exception e) {

			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public List<AssinaturaDTO> bustarPorIntervaloID(int[] range) throws InfraEstruturaException, NegocioException {
		try {

			return ServiceDAO.bustarPorIntervaloID(this.assinaturaFacade, AssinaturaDTO.class, range);

		} catch (Exception e) {

			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public void removerPorId(Long id) throws InfraEstruturaException, NegocioException {
		ServiceDAO.removerPorId(this.assinaturaFacade, id);

	}

}
