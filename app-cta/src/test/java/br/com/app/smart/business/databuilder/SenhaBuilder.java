package br.com.app.smart.business.databuilder;

import java.util.Date;

import br.app.corporativo.integracao.dto.RegistroAuditoriaDTO;
import br.app.corporativo.integracao.dto.SenhaDTO;
import br.app.corporativo.integracao.dto.StatusSenhaDTO;
import br.com.app.smart.business.databuilder.RegistroAuditoriaBuilder.TipoRegistroAuditoriaBuilder;

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

	public void comId(Long id) {
		this.id = id;
	}

	public void comHashSenha(String hashSenha) {
		this.hashSenha = hashSenha;
	}

	public void comRegistroAuditoria(RegistroAuditoriaDTO registroAuditoria) {
		this.registroAuditoria = registroAuditoria;
	}

	public void comStatusSenha(StatusSenhaDTO statusSenha) {
		this.statusSenha = statusSenha;
	}

}
