package escola.musica.dao;

import java.util.List;

import javax.persistence.EntityManager;

public class GenericDAO<T> {

	private final Class<T> classe;

	public GenericDAO(Class<T> classe) {
		this.classe = classe;
	}

	public void salvar(T t) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		entityManager.merge(t); // Se existir ele atualiza, senão ele cria.

		entityManager.getTransaction().commit();

		entityManager.close();
	}

	public void excluir(T t) {
		EntityManager entityManager = JPAUtil.getEntityManager();

		entityManager.getTransaction().begin();

		t = entityManager.merge(t);
		entityManager.remove(t); // Se existir ele atualiza, senão ele cria.

		entityManager.getTransaction().commit();

		entityManager.close();
	}

	public List<T> listarTodos() {
		EntityManager entityManager = JPAUtil.getEntityManager();

		// é o mesmo que: ("from " + classe)
		// "c" é um apelido para o classe.getName()
		List<T> resultados = entityManager.createQuery("select c from " + classe.getName() + " c", classe).getResultList();

		entityManager.close();

		return resultados;
	}

	public T obterPorId(Integer id) {
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		T t = entityManager.createQuery("from " + classe.getName() + " where id = :id", classe).setParameter("id", id).getSingleResult();
	
		entityManager.close();
		
		return t;
	}

}
