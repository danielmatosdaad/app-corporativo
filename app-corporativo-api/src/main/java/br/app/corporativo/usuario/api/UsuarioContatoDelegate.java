package br.app.corporativo.usuario.api;

import java.util.List;

import br.app.barramento.integracao.dto.EnvioDTO;
import br.app.barramento.integracao.dto.LocalizadorServico;
import br.app.barramento.integracao.dto.Mensagem;
import br.app.barramento.integracao.dto.RespostaDTO;
import br.app.barramento.integracao.dto.TipoAcao;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.corporativo.integracao.dto.ContatoDTO;
import br.app.corporativo.integracao.interfaces.IServicoUsuarioContato;
import br.app.smart.api.infra.AbstractDelegate;
import br.app.smart.api.infra.TipoLocalizador;

@SuppressWarnings("rawtypes")
public class UsuarioContatoDelegate extends AbstractDelegate<IServicoUsuarioContato> {

	public UsuarioContatoDelegate() {
	}
	public UsuarioContatoDelegate(LocalizadorServico<IServicoUsuarioContato> localizarServico) {
		super(localizarServico);
	}

	public static UsuarioContatoDelegate getInstancia() {

		LocalizadorServico<IServicoUsuarioContato> localizaServico = new LocalizarServicoUsuarioSenha<IServicoUsuarioContato>(
				TipoLocalizador.REMOTO);

		UsuarioContatoDelegate delegate = new UsuarioContatoDelegate(localizaServico);

		return delegate;
	}

	@SuppressWarnings("unchecked")
	public IServicoUsuarioContato<ContatoDTO> getServico() {
		return getLocalizadorServico().getServico();
	}

	public ContatoDTO adiconar(ContatoDTO dto) throws InfraEstruturaException, NegocioException {
		return getServico().adiconar(dto);

	}

	public List<ContatoDTO> adiconar(List<ContatoDTO> listaDto) throws InfraEstruturaException, NegocioException {
		return getServico().adiconar(listaDto);
	}

	public ContatoDTO alterar(ContatoDTO dto) throws InfraEstruturaException, NegocioException {
		return getServico().alterar(dto);
	}

	public void remover(ContatoDTO dto) throws InfraEstruturaException, NegocioException {
		getServico().remover(dto);
	}

	public void removerPorId(Long id) throws InfraEstruturaException, NegocioException {

		getServico().removerPorId(id);
	}

	public List<ContatoDTO> bustarTodos() throws InfraEstruturaException, NegocioException {
		return getServico().bustarTodos();
	}

	public ContatoDTO bustarPorID(Long id) throws InfraEstruturaException, NegocioException {
		return getServico().bustarPorID(id);
	}

	public List<ContatoDTO> bustarPorIntervaloID(int[] range) throws InfraEstruturaException, NegocioException {
		return getServico().bustarPorIntervaloID(range);
	}

	@Override
	public LocalizadorServico<IServicoUsuarioContato> getLocalizadorServico(TipoAcao acao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void executarServico(TipoAcao acao, EnvioDTO envio, RespostaDTO resposta,IServicoUsuarioContato servico)
			throws NegocioException, InfraEstruturaException {
		resposta.setMensagem(Mensagem.ERRO);
		resposta.getMensagem().setErro("Funcionalidade nao implementada:" + acao.getValue());
	}
}
