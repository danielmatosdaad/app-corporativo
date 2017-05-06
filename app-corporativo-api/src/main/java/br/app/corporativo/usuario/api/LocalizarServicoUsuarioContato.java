package br.app.corporativo.usuario.api;

import br.app.smart.api.infra.AbstractLocalizadorServico;
import br.app.smart.api.infra.TipoLocalizador;

@SuppressWarnings("hiding")
public class LocalizarServicoUsuarioContato<IServicoUsuarioContato>
		extends AbstractLocalizadorServico<IServicoUsuarioContato> {

	private static final String LOCALIZACAO_SERVICO = "localizacao_servico.properties";
	private static final String REGISTRO_NOME_LOCAL = "local.controle.sessao";
	private static final String REGISTRO_NOME_REMOTO = "remoto.controle.sessao";

	public LocalizarServicoUsuarioContato(TipoLocalizador tipoLocalizacao) {
		super(tipoLocalizacao, REGISTRO_NOME_REMOTO, REGISTRO_NOME_LOCAL, LOCALIZACAO_SERVICO);
		this.tipoLocalizacao = tipoLocalizacao;
	}

	public LocalizarServicoUsuarioContato() {
		super(TipoLocalizador.LOCAL, REGISTRO_NOME_REMOTO, REGISTRO_NOME_LOCAL, LOCALIZACAO_SERVICO);
	}

}
