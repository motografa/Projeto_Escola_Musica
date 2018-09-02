package escola.musica.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import escola.musica.modelo.Curso;

public class CursoDAO {

	public void salvar(Curso curso) {
		// isso � jpa puro. Depois ser� substituido por Spring
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(curso);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@SuppressWarnings("unchecked") // anota��o para suprimir avisos
	public List<Curso> listarToso() {
		EntityManager entityManager = JPAUtil.getEntityManager();

		return entityManager.createQuery("from Curso").getResultList();// hql
	}

	public void excluir(Curso curso) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		entityManager.getTransaction().begin();

		curso = entityManager.merge(curso);// para que ele n�o seja transiente
		entityManager.remove(curso);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@SuppressWarnings("unchecked")
	public static List<Curso> listarCursosAccordion() {
		EntityManager entityManager = JPAUtil.getEntityManager();

		return entityManager.createQuery("from Curso where nome in ('Violino'"//
				+ ", 'Bateria'"//
				+ ", 'Clarinete'"//
				+ ", 'Flauta'"//
				+ ", 'Guitarra'"//
				+ ", 'Violão'"//
				+ ", 'Oboé') order by nome").getResultList();// nome é o atributo da classe Curso (Curso.nome)
	}

}
