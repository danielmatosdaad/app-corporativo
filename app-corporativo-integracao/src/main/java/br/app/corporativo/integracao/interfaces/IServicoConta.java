package br.app.corporativo.integracao.interfaces;

import br.app.barramento.integracao.dao.interfaces.IServicoDAO;
import br.app.corporativo.integracao.dto.ContaDTO;

public interface IServicoConta<T extends ContaDTO> extends IServicoDAO<T>{

}
