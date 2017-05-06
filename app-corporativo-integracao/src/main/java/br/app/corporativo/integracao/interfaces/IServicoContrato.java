package br.app.corporativo.integracao.interfaces;

import br.app.barramento.integracao.dao.interfaces.IServicoDAO;
import br.app.corporativo.integracao.dto.ContratoDTO;

public interface IServicoContrato<T extends ContratoDTO> extends IServicoDAO<T>{

}
