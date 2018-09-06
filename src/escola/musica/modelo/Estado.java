package escola.musica.modelo;

public enum Estado {
//	SP("São Paulo"), //
//	RJ("Rio de Janeiro"), //
//	PR("Paraná"), //
//	SC("Santa Catarina"), //
//	MG("Minas Gerais");//
	
	

	AC("Acre"),//
	AL("Alagoas"),//
	AP("Amapá"),//
	AM("Amazonas"),//
	BA("Bahia"),//
	CE("Ceará"),//
	DFL("Distrito Federal"),//
	ES("Espírito Santo"),//
	GO("Goiás"),//
	MA("Maranhão"),//
	MT("Mato Grosso"),//
	MS("Mato Grosso do Sul"),//
	MG("Minas Gerais"),//
	PA("Pará"),//
	PB("Paraíba"),//
	PR("Paraná"),//
	PE("Pernambuco"),//
	PI("Piauí"),//
	RR("Roraima"),//
	RO("Rondônia"),//
	RJ("Rio de Janeiro"),//
	RN("Rio Grande do Norte"),//
	RS("Rio Grande do Sul"),//
	SC("Santa Catarina"),//
	SP("São Paulo"),//
	SE("Sergipe"),//
	TO("Tocantins");

	private Estado(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	private String label;

}
