package br.app.corporativo.integracao.interfaces;

import br.app.barramento.integracao.dao.interfaces.IServicoDAO;
import br.app.corporativo.integracao.dto.ContatoDTO;

public interface IServicoUsuarioContato<T extends ContatoDTO> extends IServicoDAO<T> {

}
