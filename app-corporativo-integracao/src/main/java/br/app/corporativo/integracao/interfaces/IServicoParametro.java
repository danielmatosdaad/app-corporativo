package br.app.corporativo.integracao.interfaces;


import br.app.barramento.integracao.dao.interfaces.IServicoDAO;
import br.app.corporativo.integracao.dto.ParametroDTO;

public interface IServicoParametro<T extends ParametroDTO> extends IServicoDAO<T> {

}
