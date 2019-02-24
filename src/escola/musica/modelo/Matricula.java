package escola.musica.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@NamedQueries({
	@NamedQuery(name = "Matricula.ListarTodas", query = "select new escola.musica.modelo.MatriculaVO("
			+ "id, numero, dataMatricula, aluno.nome, curso.nome) "
			+ "from Matricula"),
	@NamedQuery(name = "Matricula.ListarTodasAtivas", query = "select m from Matricula m where ativo = true")
})

public class Matricula implements Serializable {

	private static final long serialVersionUID = 8083358052410703771L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotEmpty(message = "Campo 'numero' é obrigatório")
	private String numero;
	
	@NotNull(message = "A data da matricula deve ser preenchida")
	@Temporal(TemporalType.DATE)
	private Date dataMatricula;
	
	@NotNull(message = "Selecione um aluno")
	@ManyToOne
	@JoinColumn(name = "id_aluno")
	private Aluno aluno;
	
	@NotNull(message = "Selecione um curso")
	@ManyToOne
	@JoinColumn(name = "id_curso")
	private Curso curso;
	
	private boolean Ativo = true;
	
	@Temporal(TemporalType.DATE)
	private Date dataDesativacao;
	
	public Matricula() {}
	
	public Matricula(Integer id, Date dataMatricula, String numero, String nomeAluno, String nomeCurso) {
		this.id = id;
		this.dataMatricula = dataMatricula;

		Aluno aluno = new Aluno();
		aluno.setNome(nomeAluno);
		this.aluno = aluno;
		
		Curso curso = new Curso();
		curso.setNome(nomeCurso);
		this.curso = curso;
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public boolean isAtivo() {
		return Ativo;
	}

	public void setAtivo(boolean ativo) {
		Ativo = ativo;
	}

	public Date getDataDesativacao() {
		return dataDesativacao;
	}

	public void setDataDesativacao(Date dataDesativacao) {
		this.dataDesativacao = dataDesativacao;
	}

	public Date getDataMatricula() {
		return dataMatricula;
	}

	public void setDataMatricula(Date dataMatricula) {
		this.dataMatricula = dataMatricula;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Matricula other = (Matricula) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
