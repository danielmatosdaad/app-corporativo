package br.app.corporativo.integracao.interfaces;

import br.app.barramento.integracao.dao.interfaces.IServicoDAO;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.corporativo.integracao.dto.UsuarioDTO;

public interface IServicoUsuario<T extends UsuarioDTO> extends IServicoDAO<T> {

	public UsuarioDTO buscarPorLogin(String login) throws InfraEstruturaException, NegocioException;

	public UsuarioDTO validaUsuarioSenha(String login, String senha) throws InfraEstruturaException, NegocioException;
}
