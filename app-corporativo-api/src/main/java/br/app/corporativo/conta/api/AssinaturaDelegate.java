package br.app.corporativo.conta.api;

import br.app.barramento.integracao.dto.EnvioDTO;
import br.app.barramento.integracao.dto.IService;
import br.app.barramento.integracao.dto.LocalizadorServico;
import br.app.barramento.integracao.dto.Mensagem;
import br.app.barramento.integracao.dto.RespostaDTO;
import br.app.barramento.integracao.dto.TipoAcao;
import br.app.barramento.integracao.exception.InfraEstruturaException;
import br.app.barramento.integracao.exception.NegocioException;
import br.app.corporativo.integracao.interfaces.IServicoAssinatura;
import br.app.smart.api.infra.AbstractDelegate;
import br.app.smart.api.infra.TipoLocalizador;

public class AssinaturaDelegate extends AbstractDelegate<IServicoAssinatura> {

	public AssinaturaDelegate(LocalizadorServico<IServicoAssinatura> localizaServico) {
		super(localizaServico);
	}

	public IServicoAssinatura getServico() {
		return getLocalizadorServico().getServico();
	}

	public static AssinaturaDelegate getIntancia() {

		LocalizadorServico<IServicoAssinatura> localizaServico = new LocalizarServicoAssinatura<IServicoAssinatura>(
				TipoLocalizador.REMOTO);

		AssinaturaDelegate delegate = new AssinaturaDelegate(localizaServico);

		return delegate;
	}

	@Override
	public LocalizadorServico<IServicoAssinatura> getLocalizadorServico(TipoAcao acao) {

		if (TipoAcao.isAcaoDAO(acao)) {
			LocalizadorServico<IServicoAssinatura> localizaServico = new LocalizarServicoAssinatura<IServicoAssinatura>(
					TipoLocalizador.REMOTO.getValue(), LocalizarServicoAssinatura.REGISTRO_LOCAL_DAO,
					LocalizarServicoAssinatura.REGISTRO_REMOTO_DAO);
			return localizaServico;
		}

		LocalizadorServico<IServicoAssinatura> localizaServico = new LocalizarServicoAssinatura<IServicoAssinatura>(
				TipoLocalizador.REMOTO);
		return localizaServico;
	}


	@Override
	public void executarServico(TipoAcao acao, EnvioDTO envio, RespostaDTO resposta, IServicoAssinatura servico)
			throws NegocioException, InfraEstruturaException {
		resposta.setMensagem(Mensagem.ERRO);
		resposta.getMensagem().setErro("Funcionalidade nao implementada:" + acao.getValue());
		
	}

}
