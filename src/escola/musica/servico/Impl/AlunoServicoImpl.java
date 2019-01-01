package escola.musica.servico.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import escola.musica.modelo.Aluno;
import escola.musica.servico.AlunoServico;

@Service("alunoServico") // quando o unico atributo é value, pode por direto. Não precisa ser @Service(value = "alunoServico")
@Transactional
public class AlunoServicoImpl implements AlunoServico {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void salvar(Aluno aluno) {
		entityManager.merge(aluno);
		
	}

	@Override
	public List<Aluno> listarTodos() {
		return entityManager.createQuery("from Aluno").getResultList();
	}

}
