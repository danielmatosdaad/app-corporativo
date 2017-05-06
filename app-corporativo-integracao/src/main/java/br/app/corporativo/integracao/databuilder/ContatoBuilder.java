package br.app.corporativo.integracao.databuilder;

import br.app.corporativo.integracao.databuilder.RegistroAuditoriaBuilder.TipoRegistroAuditoriaBuilder;
import br.app.corporativo.integracao.dto.ContatoDTO;
import br.app.corporativo.integracao.dto.RegistroAuditoriaDTO;
import br.app.corporativo.integracao.dto.SenhaDTO;
import br.app.corporativo.integracao.dto.TipoContatoDTO;

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

	public ContatoBuilder comId(Long id) {
		this.id = id;
		return this;
	}

	public ContatoBuilder comTipoContato(TipoContatoDTO tipoContato) {
		this.tipoContato = tipoContato;
		return this;
	}

	public ContatoBuilder comValor(String valor) {
		this.valor = valor;
		return this;
	}

}
