package br.app.corporativo.usuario.api;

import java.util.List;

import br.app.barramento.integracao.dto.EnvioDTO;
import br.app.barramento.integracao.dto.LocalizadorServico;
import br.app.barramento.integracao.dto.Mensagem;
import br.app.barramento.integracao.dto.RespostaDTO;
import br.app.barramento.integracao.dto.TipoAcao;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.corporativo.integracao.dto.SenhaDTO;
import br.app.corporativo.integracao.interfaces.IServicoUsuarioSenha;
import br.app.smart.api.infra.AbstractDelegate;
import br.app.smart.api.infra.TipoLocalizador;

public class UsuarioSenhaDelegate extends AbstractDelegate<IServicoUsuarioSenha> {

	public UsuarioSenhaDelegate(LocalizadorServico<IServicoUsuarioSenha> localizarServico) {
		super(localizarServico);
	}

	public static UsuarioSenhaDelegate getInstancia() {

		LocalizadorServico<IServicoUsuarioSenha> localizaServico = new LocalizarServicoUsuarioSenha<IServicoUsuarioSenha>(
				TipoLocalizador.REMOTO);

		UsuarioSenhaDelegate delegate = new UsuarioSenhaDelegate(localizaServico);

		return delegate;
	}

	@SuppressWarnings("unchecked")
	public IServicoUsuarioSenha<SenhaDTO> getServico() {
		return getLocalizadorServico().getServico();
	}

	public SenhaDTO adiconar(SenhaDTO dto) throws InfraEstruturaException, NegocioException {
		return getServico().adiconar(dto);

	}

	public List<SenhaDTO> adiconar(List<SenhaDTO> listaDto) throws InfraEstruturaException, NegocioException {
		return getServico().adiconar(listaDto);
	}

	public SenhaDTO alterar(SenhaDTO dto) throws InfraEstruturaException, NegocioException {
		return getServico().alterar(dto);
	}

	public void remover(SenhaDTO dto) throws InfraEstruturaException, NegocioException {
		getServico().remover(dto);
	}

	public void removerPorId(Long id) throws InfraEstruturaException, NegocioException {

		getServico().removerPorId(id);
	}

	public List<SenhaDTO> bustarTodos() throws InfraEstruturaException, NegocioException {
		return getServico().bustarTodos();
	}

	public SenhaDTO bustarPorID(Long id) throws InfraEstruturaException, NegocioException {
		return getServico().bustarPorID(id);
	}

	public List<SenhaDTO> bustarPorIntervaloID(int[] range) throws InfraEstruturaException, NegocioException {
		return getServico().bustarPorIntervaloID(range);
	}

	@Override
	public LocalizadorServico<IServicoUsuarioSenha> getLocalizadorServico(TipoAcao acao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void executarServico(TipoAcao acao, EnvioDTO envio, RespostaDTO resposta,IServicoUsuarioSenha servico)
			throws NegocioException, InfraEstruturaException {
		resposta.setMensagem(Mensagem.ERRO);
		resposta.getMensagem().setErro("Funcionalidade nao implementada:" + acao.getValue());
	}

}
