package br.com.app.smart.business.databuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.app.corporativo.integracao.dto.ContatoDTO;
import br.app.corporativo.integracao.dto.RegistroAuditoriaDTO;
import br.app.corporativo.integracao.dto.SenhaDTO;
import br.app.corporativo.integracao.dto.StatusSenhaDTO;
import br.app.corporativo.integracao.dto.StatusUsuarioDTO;
import br.app.corporativo.integracao.dto.TipoContatoDTO;
import br.app.corporativo.integracao.dto.UsuarioDTO;
import br.com.app.smart.business.databuilder.RegistroAuditoriaBuilder.TipoRegistroAuditoriaBuilder;

public class UsuarioBuilder {

	private Long id;
	private String nome;
	private String sobrenome;
	private String login;
	private String dataNascimento;
	private String chave;
	private String initChave;
	private String cpf;
	private RegistroAuditoriaDTO registroAuditoria;
	private List<ContatoDTO> contatos;
	private List<SenhaDTO> senhas;
	private StatusUsuarioDTO statusUsuario;

	private UsuarioBuilder() {
	}

	public static UsuarioBuilder umaInstancia() {

		return new UsuarioBuilder();
	}

	public UsuarioDTO construir() {

		UsuarioDTO usuario = new UsuarioDTO();
		usuario.setId(this.id);
		usuario.setNome(this.nome);
		usuario.setSobrenome(sobrenome);
		usuario.setDataNascimento(dataNascimento);
		usuario.setLogin(this.login);
		usuario.setChave(this.chave);
		usuario.setInitChave(this.initChave);
		usuario.setCpf(this.cpf);
		usuario.setRegistroAuditoria(this.registroAuditoria);
		usuario.setContatos(this.contatos);
		usuario.setSenhas(this.senhas);
		usuario.setStatusUsuario(this.statusUsuario);

		RegistroAuditoriaDTO registroAuditoria = RegistroAuditoriaBuilder
				.getInstanceDTO(TipoRegistroAuditoriaBuilder.DEFAULT);

		usuario.setRegistroAuditoria(registroAuditoria);

		return usuario;
	}

	public void comId(Long id) {
		this.id = id;
	}

	public void comNome(String nome) {
		this.nome = nome;
	}

	public void comSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public void comLogin(String login) {
		this.login = login;
	}

	public void comDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void comChave(String chave) {
		this.chave = chave;
	}

	public void comInitChave(String initChave) {
		this.initChave = initChave;
	}

	public void comRegistroAuditoria(RegistroAuditoriaDTO registroAuditoria) {
		this.registroAuditoria = registroAuditoria;
	}

	public void comContatos(List<ContatoDTO> contatos) {
		this.contatos = contatos;
	}

	public void comSenhas(List<SenhaDTO> senhas) {
		this.senhas = senhas;
	}

	public void comStatusUsuario(StatusUsuarioDTO statusUsuario) {
		this.statusUsuario = statusUsuario;
	}

	public void comCpf(String cpf) {
		this.cpf = cpf;
	}

}
