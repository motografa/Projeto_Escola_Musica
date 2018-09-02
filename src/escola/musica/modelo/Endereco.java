package escola.musica.modelo;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Embeddable
public class Endereco {

	@NotEmpty(message = "Logradouro é obrigatório")
	private String logradouro;
	
	@NotNull(message = "Informe o número")
	private Integer numero;
	
	@NotNull(message = "Informe o CEP")
	private String cep;
	
	@ManyToOne
	@JoinColumn(name = "id_cidade")
	@NotNull(message = "Selecione a cidade")
	private Cidade cidade = new Cidade();
	
	
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Cidade getCidade() {
		return cidade;
	}
	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
}
