import static org.junit.Assert.*;
import models.Evento;
import models.Local;
import models.Usuario;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import controllers.Sistema;


public class SistemaHackTest extends AbstractTest{
	
	private Sistema sistema;
	private Evento evento1;
	private Usuario pessoa1;
	private Local local1;
	
	@Before
	public void iniciar(){
		sistema = Sistema.getInstance();
		evento1 = new Evento("Arduino", "introduçao ao Arduino", "10/08/2014", "italo", "italo@gmail");
		pessoa1 = new Usuario("italo@gmail", "123","Italo");
		local1 = new Local("lcc", 10, "pergunte a alguem");
		evento1.addLocal("lcc", "pergunte a alguem",10);
	}
	
//	@Test
//	public void testaCriarEvento(){
//		evento1 = new Evento("Arduino","introduçao ao Arduino","10/08/2014","italo",);
//	}
	
	
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
	public void testaNaoAdicionarMesmaPessoaNoEvento(){
		sistema.addEvento(evento1);
		sistema.addPessoaNoEvento(evento1, pessoa1);
		sistema.addPessoaNoEvento(evento1, pessoa1);
		Assert.assertTrue(evento1.numDePessoasQueConfirmaram() == 1 );
	}
	
//	@Test
//	public void testaAdicionarPessoaNoSistema(){
//		sistema.signUp("Italo", "italo@gmail", "123");
//		Assert.assertTrue(sistema.temUsuario("Italo", "123"));
//	}
//	
//	@Test
//	public void testaRemoverEvento(){
//		sistema.addEvento(evento1);
//		Assert.assertTrue(sistema.removeEvento(evento1));
//	}

}
