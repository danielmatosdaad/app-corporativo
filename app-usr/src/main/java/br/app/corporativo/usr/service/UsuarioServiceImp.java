package br.app.corporativo.usr.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.app.barramento.infra.persistencia.conversores.Conversor;
import br.app.barramento.infra.persistencia.service.ServiceDAO;
import br.app.barramento.integracao.dao.interfaces.IServicoLocalDAO;
import br.app.barramento.integracao.dao.interfaces.IServicoRemoteDAO;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.corporativo.integracao.dto.ContatoDTO;
import br.app.corporativo.integracao.dto.SenhaDTO;
import br.app.corporativo.integracao.dto.StatusSenhaDTO;
import br.app.corporativo.integracao.dto.StatusUsuarioDTO;
import br.app.corporativo.integracao.dto.UsuarioDTO;
import br.app.corporativo.integracao.interfaces.IServicoUsuarioLocal;
import br.app.corporativo.integracao.interfaces.IServicoUsuarioRemote;
import br.app.corporativo.usr.dao.UsuarioFacade;
import br.app.corporativo.usr.model.Usuario;

@Stateless
@Remote(value = { IServicoUsuarioRemote.class, IServicoRemoteDAO.class })
@Local(value = { IServicoUsuarioLocal.class, IServicoLocalDAO.class })
public class UsuarioServiceImp implements IServicoUsuarioRemote, IServicoUsuarioLocal {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB
	private UsuarioFacade usuarioFacade;

	@EJB(beanName = "SenhaServiceImp", beanInterface = IServicoLocalDAO.class)
	private IServicoLocalDAO<SenhaDTO> senhaServiceImp;

	@EJB(beanName = "ContatoServiceImp", beanInterface = IServicoLocalDAO.class)
	private IServicoLocalDAO<ContatoDTO> contatoServiceImp;

	@Override
	public UsuarioDTO adiconar(UsuarioDTO dto) throws InfraEstruturaException, NegocioException {
		try {

			if (dto.getSenhas() != null || !dto.getSenhas().isEmpty()) {

				dto.setSenhas(senhaServiceImp.adiconar(dto.getSenhas()));
			}

			if (dto.getSenhas() != null || !dto.getSenhas().isEmpty()) {

				dto.setContatos(contatoServiceImp.adiconar(dto.getContatos()));
			}

			return ServiceDAO.adiconar(this.usuarioFacade, Usuario.class, dto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public List<UsuarioDTO> adiconar(List<UsuarioDTO> listaDto) throws InfraEstruturaException, NegocioException {
		try {
			return ServiceDAO.adiconar(this.usuarioFacade, Usuario.class, listaDto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public UsuarioDTO alterar(UsuarioDTO dto) throws InfraEstruturaException, NegocioException {
		try {
			return ServiceDAO.alterar(this.usuarioFacade, Usuario.class, dto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public void remover(UsuarioDTO dto) throws InfraEstruturaException, NegocioException {
		try {
			ServiceDAO.remover(this.usuarioFacade, Usuario.class, dto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}

	}

	@Override
	public void removerPorId(Long id) throws InfraEstruturaException, NegocioException {
		// TODO Auto-generated method stub

	}

	@Override
	public List<UsuarioDTO> bustarTodos() throws InfraEstruturaException, NegocioException {
		try {
			return ServiceDAO.bustarTodos(this.usuarioFacade, UsuarioDTO.class);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public UsuarioDTO bustarPorID(Long id) throws InfraEstruturaException, NegocioException {
		try {
			return ServiceDAO.bustarPorID(this.usuarioFacade, UsuarioDTO.class, id);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public List<UsuarioDTO> bustarPorIntervaloID(int[] range) throws InfraEstruturaException, NegocioException {
		try {
			return ServiceDAO.bustarPorIntervaloID(this.usuarioFacade, UsuarioDTO.class, range);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public UsuarioDTO buscarPorLogin(String login) throws InfraEstruturaException, NegocioException {

		try {

			Usuario usuario = this.usuarioFacade.buscarPorLogin(login);
			if(usuario==null){
				throw new NegocioException(1,"login nao encontrado");
			}
			UsuarioDTO usuarioDTO = Conversor.converter(usuario, UsuarioDTO.class);
			return usuarioDTO;

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}

	}

	public UsuarioDTO validaUsuarioSenha(String login, String senha) throws InfraEstruturaException, NegocioException {

		UsuarioDTO usuarioDTO = buscarPorLogin(login);

		if (!usuarioDTO.getStatusUsuario().equals(StatusUsuarioDTO.ATIVO)) {

			throw new NegocioException("Login " + usuarioDTO.getStatusUsuario().name(), new RuntimeException());
		}

		
		if (usuarioDTO.getSenhas() != null) {
			for (SenhaDTO senhaDTO : usuarioDTO.getSenhas()) {
				if (senhaDTO.getHashSenha().equals(senha)) {
					System.out.println("senha:" + senhaDTO.getHashSenha());
					if (!senhaDTO.getStatusSenha().equals(StatusSenhaDTO.ATIVO)) {
						throw new NegocioException("Senha Usuario " + senhaDTO.getStatusSenha().name(),
								new RuntimeException());
					}
					return usuarioDTO;
				}
			}
		}

		throw new NegocioException("Login ou senha invalidos", new RuntimeException());

	}

}
