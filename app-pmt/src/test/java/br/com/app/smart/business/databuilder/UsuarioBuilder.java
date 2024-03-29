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

public class UsuarioBuilder {

	public static UsuarioDTO getInstanceDTO(TipoUsuarioBuilder tipoUsuario) {

		switch (tipoUsuario) {

		case USUARIO_COMPLETO:
			return criarUsuarioCompleto();
		case USUARIO_APENAS_CONTATO:

			break;
		case USUARIO_APENAS_SENHA:

			break;
		case USUARIO_DEFAULT:

			break;

		default:
			break;
		}
		return new UsuarioDTO();
	}

	private static UsuarioDTO criarUsuarioCompleto() {
		RegistroAuditoriaDTO r = new RegistroAuditoriaDTO();
		r.setDataCadastro(new Date());

		SenhaDTO senhaDTO = new SenhaDTO();
		senhaDTO.setHashSenha("=3DF34334DFDDF");
		senhaDTO.setStatusSenha(StatusSenhaDTO.ATIVO);
		senhaDTO.setRegistroAuditoria(r);

		List<SenhaDTO> senhas = new ArrayList<SenhaDTO>();
		senhas.add(senhaDTO);

		ContatoDTO contatoDTO = new ContatoDTO();
		contatoDTO.setTipoContato(TipoContatoDTO.CELULAR);
		contatoDTO.setValor("556192318154");
		contatoDTO.setRegistroAuditoria(r);

		List<ContatoDTO> contatos = new ArrayList<ContatoDTO>();
		contatos.add(contatoDTO);

		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setLogin("login");
		usuarioDTO.setNome("x");
		usuarioDTO.setSobrenome("y");
		usuarioDTO.setStatusUsuario(StatusUsuarioDTO.ATIVO);
		usuarioDTO.setContatos(contatos);

		usuarioDTO.setSenhas(senhas);
		usuarioDTO.setRegistroAuditoria(r);

		return usuarioDTO;

	}

	public static enum TipoUsuarioBuilder {

		USUARIO_COMPLETO, USUARIO_APENAS_CONTATO, USUARIO_APENAS_SENHA, USUARIO_DEFAULT;
	}
}
