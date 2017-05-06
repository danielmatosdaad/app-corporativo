package br.app.corporativo.conta.api;

import br.app.smart.api.infra.AbstractLocalizadorServico;
import br.app.smart.api.infra.TipoLocalizador;

@SuppressWarnings("hiding")
public class LocalizarServicoAssinatura<IServicoAssinatura> extends AbstractLocalizadorServico<IServicoAssinatura> {

	private static final String LOCALIZACAO_SERVICO = "localizacao_servico.properties";
	private static final String REGISTRO_NOME_LOCAL = "local.assinatura";
	private static final String REGISTRO_NOME_REMOTO = "remote.assinatura";;
	public static final String REGISTRO_REMOTO_DAO = 	"remote.assinatura.dao";
	public static final String REGISTRO_LOCAL_DAO = "local.assinatura.dao";

	public LocalizarServicoAssinatura(TipoLocalizador tipoLocalizacao) {
		super(tipoLocalizacao, REGISTRO_NOME_REMOTO, REGISTRO_NOME_LOCAL, LOCALIZACAO_SERVICO);
	}

	public LocalizarServicoAssinatura() {
		super(TipoLocalizador.LOCAL, REGISTRO_NOME_REMOTO, REGISTRO_NOME_LOCAL, LOCALIZACAO_SERVICO);
	}
	
	public LocalizarServicoAssinatura(String tipoLocalizacao, String registroNomeLocal, String registroNomeRemoto) {
		super(TipoLocalizador.getLocalizador(tipoLocalizacao), registroNomeLocal, registroNomeRemoto,
				LOCALIZACAO_SERVICO);
	}


}
