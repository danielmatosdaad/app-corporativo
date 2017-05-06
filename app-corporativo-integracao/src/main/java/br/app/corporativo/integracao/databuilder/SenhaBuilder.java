package br.app.corporativo.integracao.databuilder;

import java.util.Date;

import br.app.corporativo.integracao.databuilder.RegistroAuditoriaBuilder.TipoRegistroAuditoriaBuilder;
import br.app.corporativo.integracao.dto.RegistroAuditoriaDTO;
import br.app.corporativo.integracao.dto.SenhaDTO;
import br.app.corporativo.integracao.dto.StatusSenhaDTO;

public class SenhaBuilder {

	private Long id;
	private String hashSenha;
	private RegistroAuditoriaDTO registroAuditoria;
	private StatusSenhaDTO statusSenha;

	private SenhaBuilder() {
	}

	public static SenhaBuilder umaInstancia() {

		return new SenhaBuilder();
	}

	public SenhaDTO construir() {
		SenhaDTO senha = new SenhaDTO();

		senha.setId(id);
		senha.setHashSenha(hashSenha);
		senha.setStatusSenha(statusSenha);

		RegistroAuditoriaDTO registroAuditoria = RegistroAuditoriaBuilder
				.getInstanceDTO(TipoRegistroAuditoriaBuilder.DEFAULT);

		senha.setRegistroAuditoria(registroAuditoria);

		return senha;
	}

	public SenhaBuilder comId(Long id) {
		this.id = id;
		return this;
	}

	public SenhaBuilder comHashSenha(String hashSenha) {
		this.hashSenha = hashSenha;
		return this;
	}

	public SenhaBuilder comStatusSenha(StatusSenhaDTO statusSenha) {
		this.statusSenha = statusSenha;
		return this;
	}

}
