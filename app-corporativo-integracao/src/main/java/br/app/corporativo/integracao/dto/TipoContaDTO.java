package br.app.corporativo.integracao.dto;

public enum TipoContaDTO {

	MASTER(1);

	private Integer value;

	private TipoContaDTO(Integer valor) {

		this.value = valor;
	}

	public Integer getValue() {
		return value;
	}
}
