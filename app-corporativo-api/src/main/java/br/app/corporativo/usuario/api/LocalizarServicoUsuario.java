package br.app.corporativo.usuario.api;

import br.app.smart.api.infra.AbstractLocalizadorServico;
import br.app.smart.api.infra.TipoLocalizador;

@SuppressWarnings("hiding")
public class LocalizarServicoUsuario<IServicoUsuario> extends AbstractLocalizadorServico<IServicoUsuario> {

	private static final String LOCALIZACAO_SERVICO = "localizacao_servico.properties";
	private static final String REGISTRO_NOME_LOCAL = "remoto.usuario";
	private static final String REGISTRO_NOME_REMOTO = "local.usuario";
	public static final String REGISTRO_LOCAL_DAO = "local.usuario.dao";
	public static final String REGISTRO_REMOTO_DAO = "remoto.usuario.dao";

	public LocalizarServicoUsuario(TipoLocalizador tipoLocalizacao) {
		super(tipoLocalizacao, REGISTRO_NOME_REMOTO, REGISTRO_NOME_LOCAL, LOCALIZACAO_SERVICO);
		this.tipoLocalizacao = tipoLocalizacao;
	}

	public LocalizarServicoUsuario() {
		super(TipoLocalizador.LOCAL, REGISTRO_NOME_REMOTO, REGISTRO_NOME_LOCAL, LOCALIZACAO_SERVICO);
	}

	public LocalizarServicoUsuario(String tipoLocalizacao, String registroNomeLocal, String registroNomeRemoto) {
		super(TipoLocalizador.getLocalizador(tipoLocalizacao), registroNomeLocal, registroNomeRemoto,
				LOCALIZACAO_SERVICO);
	}

}
