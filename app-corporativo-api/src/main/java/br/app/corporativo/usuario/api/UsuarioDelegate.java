package br.app.corporativo.usuario.api;

import java.util.List;

import br.app.barramento.integracao.dto.EnvioDTO;
import br.app.barramento.integracao.dto.IService;
import br.app.barramento.integracao.dto.LocalizadorServico;
import br.app.barramento.integracao.dto.Mensagem;
import br.app.barramento.integracao.dto.RespostaDTO;
import br.app.barramento.integracao.dto.TipoAcao;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.corporativo.integracao.dto.UsuarioDTO;
import br.app.corporativo.integracao.interfaces.IServicoUsuario;
import br.app.corporativo.integracao.interfaces.IServicoUsuarioContato;
import br.app.smart.api.infra.AbstractDelegate;
import br.app.smart.api.infra.TipoLocalizador;

public class UsuarioDelegate extends AbstractDelegate<IServicoUsuario> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioDelegate() {
	}

	public UsuarioDelegate(LocalizadorServico<IServicoUsuario> localizaServico) {
		super(localizaServico);
	}

	@SuppressWarnings("unchecked")
	public IServicoUsuario<UsuarioDTO> getServico() {
		return this.getLocalizadorServico().getServico();
	}

	public static UsuarioDelegate getInstancia() {

		LocalizadorServico<IServicoUsuario> localizaServico = new LocalizarServicoUsuario<IServicoUsuario>(
				TipoLocalizador.REMOTO);

		UsuarioDelegate delegate = new UsuarioDelegate(localizaServico);

		return delegate;
	}

	public UsuarioDTO adiconar(UsuarioDTO dto) throws InfraEstruturaException, NegocioException {
		return getServico().adiconar(dto);

	}

	public List<UsuarioDTO> adiconar(List<UsuarioDTO> listaDto) throws InfraEstruturaException, NegocioException {
		return getServico().adiconar(listaDto);
	}

	public UsuarioDTO alterar(UsuarioDTO dto) throws InfraEstruturaException, NegocioException {
		return getServico().alterar(dto);
	}

	public void remover(UsuarioDTO dto) throws InfraEstruturaException, NegocioException {
		getServico().remover(dto);
	}

	public void removerPorId(Long id) throws InfraEstruturaException, NegocioException {

		getServico().removerPorId(id);
	}

	public List<UsuarioDTO> bustarTodos() throws InfraEstruturaException, NegocioException {
		return getServico().bustarTodos();
	}

	public UsuarioDTO bustarPorID(Long id) throws InfraEstruturaException, NegocioException {
		return getServico().bustarPorID(id);
	}

	public List<UsuarioDTO> bustarPorIntervaloID(int[] range) throws InfraEstruturaException, NegocioException {
		return getServico().bustarPorIntervaloID(range);
	}

	public UsuarioDTO buscarPorLogin(String login) throws InfraEstruturaException, NegocioException {
		return getServico().buscarPorLogin(login);
	}

	public UsuarioDTO validaUsuarioSenha(String login, String senha) throws InfraEstruturaException, NegocioException {
		return getServico().validaUsuarioSenha(login, senha);
	}

	@Override
	public LocalizadorServico<IServicoUsuario> getLocalizadorServico(TipoAcao acao) {

		if (TipoAcao.isAcaoDAO(acao)) {
			LocalizadorServico<IServicoUsuario> localizaServico = new LocalizarServicoUsuario<IServicoUsuario>(
					TipoLocalizador.REMOTO.getValue(), LocalizarServicoUsuario.REGISTRO_LOCAL_DAO,
					LocalizarServicoUsuario.REGISTRO_REMOTO_DAO);
			return localizaServico;
		}

		LocalizadorServico<IServicoUsuario> localizaServico = new LocalizarServicoUsuario<IServicoUsuario>(
				TipoLocalizador.REMOTO);

		return localizaServico;
	}

	@Override
	public void executarServico(TipoAcao acao, EnvioDTO envio, RespostaDTO resposta, IServicoUsuario servico)
			throws NegocioException, InfraEstruturaException {
		resposta.setMensagem(Mensagem.ERRO);
		resposta.getMensagem().setErro("Funcionalidade nao implementada:" + acao.getValue());
	}
}
