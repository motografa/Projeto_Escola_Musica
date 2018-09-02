package escola.musica.dao;

import java.util.List;

import javax.persistence.EntityManager;

import escola.musica.modelo.Cidade;
import escola.musica.modelo.Estado;

public class CidadeDAO {

	public static List<Cidade> obterCidadesDoEstado(Estado estado){
		
		EntityManager entityManager = JPAUtil.getEntityManager();
		
		@SuppressWarnings("unchecked")
		List<Cidade> cidades = entityManager.createQuery("from Cidade where estado = :uf")
				.setParameter("uf", estado).getResultList();
		
		entityManager.clear();
		return cidades;
	}
}
