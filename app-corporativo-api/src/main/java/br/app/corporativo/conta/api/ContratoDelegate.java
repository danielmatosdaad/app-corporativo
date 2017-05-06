package br.app.corporativo.conta.api;

import br.app.barramento.integracao.dto.EnvioDTO;
import br.app.barramento.integracao.dto.LocalizadorServico;
import br.app.barramento.integracao.dto.Mensagem;
import br.app.barramento.integracao.dto.RespostaDTO;
import br.app.barramento.integracao.dto.TipoAcao;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.corporativo.integracao.interfaces.IServicoContrato;
import br.app.smart.api.infra.AbstractDelegate;
import br.app.smart.api.infra.TipoLocalizador;

public class ContratoDelegate extends AbstractDelegate<IServicoContrato> {

	public ContratoDelegate(LocalizadorServico<IServicoContrato> localizaServico) {
		super(localizaServico);
	}

	public IServicoContrato getServico() {
		return getLocalizadorServico().getServico();
	}

	public static ContratoDelegate getIntancia() {

		LocalizadorServico<IServicoContrato> localizaServico = new LocalizarServicoContrato<IServicoContrato>(
				TipoLocalizador.REMOTO);

		ContratoDelegate delegate = new ContratoDelegate(localizaServico);

		return delegate;
	}

	@Override
	public LocalizadorServico<IServicoContrato> getLocalizadorServico(TipoAcao acao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void executarServico(TipoAcao acao, EnvioDTO envio, RespostaDTO resposta,IServicoContrato servico)
			throws NegocioException, InfraEstruturaException {
		resposta.setMensagem(Mensagem.ERRO);
		resposta.getMensagem().setErro("Funcionalidade nao implementada:" + acao.getValue());
	}
}
