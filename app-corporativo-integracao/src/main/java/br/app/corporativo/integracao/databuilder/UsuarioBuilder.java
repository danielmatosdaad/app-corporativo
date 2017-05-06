package br.app.corporativo.integracao.databuilder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.app.corporativo.integracao.databuilder.RegistroAuditoriaBuilder.TipoRegistroAuditoriaBuilder;
import br.app.corporativo.integracao.dto.ContatoDTO;
import br.app.corporativo.integracao.dto.RegistroAuditoriaDTO;
import br.app.corporativo.integracao.dto.SenhaDTO;
import br.app.corporativo.integracao.dto.StatusSenhaDTO;
import br.app.corporativo.integracao.dto.StatusUsuarioDTO;
import br.app.corporativo.integracao.dto.TipoContatoDTO;
import br.app.corporativo.integracao.dto.UsuarioDTO;

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

	public UsuarioBuilder comId(Long id) {
		this.id = id;
		return this;
	}

	public UsuarioBuilder comNome(String nome) {
		this.nome = nome;
		return this;
	}

	public UsuarioBuilder comSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
		return this;
	}

	public UsuarioBuilder comLogin(String login) {
		this.login = login;
		return this;
	}

	public UsuarioBuilder comDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
		return this;
	}

	public UsuarioBuilder comChave(String chave) {
		this.chave = chave;
		return this;
	}

	public UsuarioBuilder comInitChave(String initChave) {
		this.initChave = initChave;
		return this;
	}

	public UsuarioBuilder comContatos(List<ContatoDTO> contatos) {
		this.contatos = contatos;
		return this;
	}

	public UsuarioBuilder comSenhas(List<SenhaDTO> senhas) {
		this.senhas = senhas;
		return this;
	}

	public UsuarioBuilder comStatusUsuario(StatusUsuarioDTO statusUsuario) {
		this.statusUsuario = statusUsuario;
		return this;
	}

	public UsuarioBuilder comCpf(String cpf) {
		this.cpf = cpf;
		return this;
	}

}
