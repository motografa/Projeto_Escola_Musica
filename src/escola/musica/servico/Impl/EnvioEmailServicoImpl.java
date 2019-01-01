package escola.musica.servico.Impl;

import org.springframework.stereotype.Service;

import escola.musica.servico.EnvioEmailServico;

@Service //Para se tornar um Bean do spring
public class EnvioEmailServicoImpl implements EnvioEmailServico {

	@Override
//	@Scheduled(fixedDelay = 5000)
	public void enviaremail() {
		System.out.println("Enviando email...");
	}

}
