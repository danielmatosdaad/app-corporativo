package br.com.app.smart.business.databuilder;

import br.app.corporativo.integracao.dto.ContatoDTO;
import br.app.corporativo.integracao.dto.RegistroAuditoriaDTO;
import br.app.corporativo.integracao.dto.SenhaDTO;
import br.app.corporativo.integracao.dto.TipoContatoDTO;
import br.com.app.smart.business.databuilder.RegistroAuditoriaBuilder.TipoRegistroAuditoriaBuilder;

public class ContatoBuilder {

	private Long id;
	private TipoContatoDTO tipoContato;
	private String valor;
	private RegistroAuditoriaDTO registroAuditoria;

	private ContatoBuilder() {
	}

	public static ContatoBuilder umaInstancia() {

		return new ContatoBuilder();
	}

	public ContatoDTO construir() {
		ContatoDTO contato = new ContatoDTO();
		contato.setId(id);
		contato.setTipoContato(tipoContato);
		contato.setValor(valor);
		contato.setRegistroAuditoria(registroAuditoria);

		RegistroAuditoriaDTO registroAuditoria = RegistroAuditoriaBuilder
				.getInstanceDTO(TipoRegistroAuditoriaBuilder.DEFAULT);

		contato.setRegistroAuditoria(registroAuditoria);

		return contato;
	}

	public void comId(Long id) {
		this.id = id;
	}

	public void comTipoContato(TipoContatoDTO tipoContato) {
		this.tipoContato = tipoContato;
	}

	public void comValor(String valor) {
		this.valor = valor;
	}

	public void comRegistroAuditoria(RegistroAuditoriaDTO registroAuditoria) {
		this.registroAuditoria = registroAuditoria;
	}

}
