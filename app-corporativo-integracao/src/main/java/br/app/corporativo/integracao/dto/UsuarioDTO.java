package br.app.corporativo.integracao.dto;

import java.io.Serializable;
import java.util.List;

import br.app.barramento.integracao.dto.DTO;

public class UsuarioDTO implements DTO, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private String sobrenome;
	private String login;
	private String dataNascimento;
	private String chave;
	private String initChave;

	private RegistroAuditoriaDTO registroAuditoria;
	private List<ContatoDTO> contatos;
	private List<SenhaDTO> senhas;
	private StatusUsuarioDTO statusUsuario;
	private String cpf;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public List<ContatoDTO> getContatos() {
		return contatos;
	}

	public void setContatos(List<ContatoDTO> contatos) {
		this.contatos = contatos;
	}

	public List<SenhaDTO> getSenhas() {
		return senhas;
	}

	public void setSenhas(List<SenhaDTO> senhas) {
		this.senhas = senhas;
	}

	public RegistroAuditoriaDTO getRegistroAuditoria() {
		return registroAuditoria;
	}

	public void setRegistroAuditoria(RegistroAuditoriaDTO registroAuditoria) {
		this.registroAuditoria = registroAuditoria;
	}

	public StatusUsuarioDTO getStatusUsuario() {
		return statusUsuario;
	}

	public void setStatusUsuario(StatusUsuarioDTO statusUsuario) {
		this.statusUsuario = statusUsuario;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getChave() {
		return chave;
	}

	public void setChave(String chave) {
		this.chave = chave;
	}

	public String getInitChave() {
		return initChave;
	}

	public void setInitChave(String initChave) {
		this.initChave = initChave;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}


}
