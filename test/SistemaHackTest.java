import static org.junit.Assert.*;
import models.Evento;
import models.Pessoa;
import models.Sistema;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SistemaHackTest {
	
	private Sistema sistema;
	private Evento evento1;
	private Pessoa pessoa1;
	
	@Before
	public void iniciar(){
		sistema = new Sistema();
		evento1 = new Evento("Arduino", "introduçao ao Arduino", "10/08/2014", "italo", "italo@gmail");
		pessoa1 = new Pessoa("Italo", "italo@gmail", "123");
	}
	
	@Test
	public void testaAdicionarEvento(){
		sistema.addEvento(evento1);
		Assert.assertEquals(evento1, sistema.getEvento("Arduino"));
	}
	
	@Test
	public void testaAdicionarPessoaNoEvento(){
		sistema.addEvento(evento1);
		sistema.addPessoaNoEvento(evento1, pessoa1);
		Assert.assertTrue(evento1.numDePessoasQueConfirmaram() == 1 );
	}
	
	@Test
	public void testaAdicionarPessoaNoSistema(){
		sistema.signUp("Italo", "italo@gmail", "123");
		Assert.assertTrue(sistema.temUsuario("Italo", "123"));
	}
	
	@Test
	public void testaRemoverEvento(){
		sistema.addEvento(evento1);
		Assert.assertTrue(sistema.removeEvento(evento1));
	}

}
