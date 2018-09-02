package escola.musica.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Curso implements Serializable {

	private static final long serialVersionUID = 3223617028339662203L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotEmpty(message = "O campo nome deve ser informado")
	@Length(min = 3, max = 50, message = "Tamanho permitino: De 3 at� 50 caracteres")
	private String nome;
	
	@NotEmpty(message = "A descrição deve ser informada")
	private String descricao;
	
	@Min(value = 1, message = "A duração deve ser minima de 1 ano.")
	private double duracao = 1.0;
	
	@NotNull(message = "O tipo deve ser selecionado.")
	private TipoCurso tipo;
	
	@NotNull(message = "Uma data deve ser informada.")
	private Date dataCriacao;


	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getDuracao() {
		return duracao;
	}

	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}

	public TipoCurso getTipo() {
		return tipo;
	}

	public void setTipo(TipoCurso tipo) {
		this.tipo = tipo;
	}
	
	public String obterImagem() {
		return nome.toLowerCase().replaceAll("ã", "a")
		.replaceAll("é", "e")
		.replaceAll(" ", "_")
		.concat(".png");
	}

}
