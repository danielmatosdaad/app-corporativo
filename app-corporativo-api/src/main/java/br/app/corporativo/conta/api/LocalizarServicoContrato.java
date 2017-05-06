package br.app.corporativo.conta.api;

import br.app.smart.api.infra.AbstractLocalizadorServico;
import br.app.smart.api.infra.TipoLocalizador;

@SuppressWarnings("hiding")
public class LocalizarServicoContrato<IServicoContrato> extends AbstractLocalizadorServico<IServicoContrato> {

	private static final String LOCALIZACAO_SERVICO = "localizacao_servico.properties";
	private static final String REGISTRO_NOME_LOCAL = "remoto.controle.sessao";
	private static final String REGISTRO_NOME_REMOTO = "local.controle.sessao";

	public LocalizarServicoContrato(TipoLocalizador tipoLocalizacao) {
		super(tipoLocalizacao, REGISTRO_NOME_REMOTO, REGISTRO_NOME_LOCAL, LOCALIZACAO_SERVICO);
	}

	public LocalizarServicoContrato() {
		super(TipoLocalizador.LOCAL, REGISTRO_NOME_REMOTO, REGISTRO_NOME_LOCAL, LOCALIZACAO_SERVICO);
	}

}
