package br.app.corporativo.usuario.api;

import br.app.smart.api.infra.AbstractLocalizadorServico;
import br.app.smart.api.infra.TipoLocalizador;

public class LocalizarServicoUsuarioSenha<IServicoSenhaUsuario>
		extends AbstractLocalizadorServico<IServicoSenhaUsuario> {

	private static final String LOCALIZACAO_SERVICO = "localizacao_servico.properties";
	private static final String REGISTRO_NOME_LOCAL = "local.controle.sessao";
	private static final String REGISTRO_NOME_REMOTO = "remoto.controle.sessao";

	public LocalizarServicoUsuarioSenha(TipoLocalizador tipoLocalizacao) {
		super(tipoLocalizacao, REGISTRO_NOME_REMOTO, REGISTRO_NOME_LOCAL, LOCALIZACAO_SERVICO);
		this.tipoLocalizacao = tipoLocalizacao;
	}

	public LocalizarServicoUsuarioSenha() {
		this(TipoLocalizador.LOCAL);
	}

}
