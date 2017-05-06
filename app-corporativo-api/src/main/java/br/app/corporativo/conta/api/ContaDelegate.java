package br.app.corporativo.conta.api;

import br.app.barramento.integracao.dto.EnvioDTO;
import br.app.barramento.integracao.dto.LocalizadorServico;
import br.app.barramento.integracao.dto.Mensagem;
import br.app.barramento.integracao.dto.RespostaDTO;
import br.app.barramento.integracao.dto.TipoAcao;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.corporativo.integracao.interfaces.IServicoConta;
import br.app.smart.api.infra.AbstractDelegate;
import br.app.smart.api.infra.TipoLocalizador;

public class ContaDelegate extends AbstractDelegate<IServicoConta> {

	public ContaDelegate(LocalizadorServico<IServicoConta> localizaServico) {
		super(localizaServico);
	}

	public IServicoConta getServico() {
		return getLocalizadorServico().getServico();
	}

	public static ContaDelegate getIntancia() {

		LocalizadorServico<IServicoConta> localizaServico = new LocalizarServicoConta<IServicoConta>(
				TipoLocalizador.REMOTO);

		ContaDelegate delegate = new ContaDelegate(localizaServico);

		return delegate;
	}

	@Override
	public LocalizadorServico<IServicoConta> getLocalizadorServico(TipoAcao acao) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void executarServico(TipoAcao acao, EnvioDTO envio, RespostaDTO resposta,IServicoConta servico)
			throws NegocioException, InfraEstruturaException {
		resposta.setMensagem(Mensagem.ERRO);
		resposta.getMensagem().setErro("Funcionalidade nao implementada:" + acao.getValue());
	}
}
