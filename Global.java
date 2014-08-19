import play.*;

import models.dao.GenericDAO;
import models.dao.GenericDAOImpl;
import play.db.jpa.JPA;

import models.*;

public class Global extends GlobalSettings{
	
	private static GenericDAO dao = new GenericDAOImpl();

	@Override
	public void onStart(Application app) {
		Logger.info("Aplicação inicializada...");
		
		JPA.withTransaction(new play.libs.F.Callback0() {
			
			@Override
			public void invoke() throws Throwable {
	    		
	    		String tema1 = "Engenharia de Software";
	    		String tema2 = "Sistemas da Informacao";
	    		String tema3 = "Banco de Dados";
	    		String tema4 = "Computacao Desplugada";
	    		String tema5 = "Desenvolvimento para Web";
	    		
	    		
	    		Evento evento1 = new Evento("Dados abertos", "Esse evento tem o objetivo de realizar atividades com dados abertos", "11/09/2014", "Jose", "jose@gmail.com");
	    		Evento evento2 = new Evento("HTML", "Esse evento tem o objetivo de realizar atividades com HTML", "09/09/2014", "Jose", "jose@gmail.com");
	    		Evento evento3 = new Evento("Computacao Desplugada", "Esse evento tem o objetivo de realizar atividades com computacao desplugada", "11/06/2014", "Jose", "jose@gmail.com");
	    		Evento evento4 = new Evento("Metodos Formais", "Esse evento tem o objetivo de realizar atividades com metodos formais", "18/06/2014", "Jose", "jose@gmail.com");
	    		Evento evento5 = new Evento("Banco de Dados Gerenciais", "Esse evento tem o objetivo de realizar atividades com banco de dados gerenciais", "11/09/2014", "Jose", "jose@gmail.com");
	    		Evento evento6 = new Evento("Banco de Dados Sequenciais", "Esse evento tem o objetivo de realizar atividades com banco de dados sequenciais", "14/09/2014", "Jose", "jose@gmail.com");
	    		Evento evento7 = new Evento("Sites Dinamicos", "Esse evento tem o objetivo de realizar atividades com sites dinamicos", "17/08/2014", "Jose", "jose@gmail.com");
	    		Evento evento8 = new Evento("Aplicações Java", "Esse evento tem o objetivo de realizar atividades com aplicacoes java", "01/09/2014", "Jose", "jose@gmail.com");
	    		Evento evento9 = new Evento("Estruturas de dados", "Esse evento tem o objetivo de realizar atividades com estruturas de dados", "12/07/2014", "Jose", "jose@gmail.com");
	    		Evento evento10 = new Evento("Binarios", "Esse evento tem o objetivo de realizar atividades com binarios sem a utilizacao de computador", "11/09/2014", "Jose", "jose@gmail.com");
	    		
	    		Usuario usuario1 = new Usuario("sarango@gmail.com", "123", "Aleluia Sarango");
	    		Usuario usuario2 = new Usuario("viola@gmail.com", "123", "Benvindo Viola");
	    		Usuario usuario3 = new Usuario("silva@gmail.com", "123", "Chevrolet da Silva Ford");
	    		Usuario usuario4 = new Usuario("sousa@gmail.com", "123", "Faraó do Egito Sousa");
	    		Usuario usuario5 = new Usuario("pereira@gmail.com", "123", "Hypotenusa Pereira");
	    		Usuario usuario6 = new Usuario("inocencio@gmail.com", "123", "Inocêncio Coitadinho");
	    		Usuario usuario7 = new Usuario("usuario1@gmail.com", "123", "Usuario1");
	    		Usuario usuario8 = new Usuario("usuario2@gmail.com", "123", "Usuario2");
	    		Usuario usuario9 = new Usuario("usuario3@gmail.com", "123", "Usuario3");
	    		Usuario usuario10 = new Usuario("usuario4@gmail.com", "123", "Usuario4");
	    		Usuario usuario11 = new Usuario("usuario5@gmail.com", "123", "Usuario5");
	    		Usuario usuario12 = new Usuario("usuario6@gmail.com", "123", "Usuario6");
	    		Usuario usuario13 = new Usuario("usuario7@gmail.com", "123", "Usuario7");
	    		Usuario usuario14 = new Usuario("usuario8@gmail.com", "123", "Usuario8");
	    		Usuario usuario15 = new Usuario("usuario9@gmail.com", "123", "Usuario9");
	    		Usuario usuario16 = new Usuario("usuario10@gmail.com", "123", "Usuario10");
	    		Usuario usuario17 = new Usuario("usuario11@gmail.com", "123", "Usuario11");
	    		Usuario usuario18 = new Usuario("usuario12@gmail.com", "123", "Usuario12");
	    		Usuario usuario19 = new Usuario("usuario13@gmail.com", "123", "Usuario13");
	    		Usuario usuario20 = new Usuario("usuario14@gmail.com", "123", "Usuario14");
	    		Usuario usuario21 = new Usuario("usuario15@gmail.com", "123", "Usuario15");
	    		Usuario usuario22 = new Usuario("usuario16@gmail.com", "123", "Usuario16");
	    		Usuario usuario23 = new Usuario("usuario17@gmail.com", "123", "Usuario17");
	    		Usuario usuario24 = new Usuario("usuario18@gmail.com", "123", "Usuario18");
	    		Usuario usuario25 = new Usuario("usuario19@gmail.com", "123", "Usuario19");
	    		Usuario usuario26 = new Usuario("usuario20@gmail.com", "123", "Usuario20");
	    		Usuario usuario27 = new Usuario("usuario21@gmail.com", "123", "Usuario21");
	    		Usuario usuario28 = new Usuario("usuario22@gmail.com", "123", "Usuario22");
	    		Usuario usuario29 = new Usuario("usuario23@gmail.com", "123", "Usuario23");
	    		Usuario usuario30 = new Usuario("usuario24@gmail.com", "123", "Usuario24");
	    		Usuario usuario31 = new Usuario("usuario25@gmail.com", "123", "Usuario25");
	    		
	    		Local local1 = new Local("LCC2", 30, "Bloco CN");
	    		Local local2 = new Local("Hatory",20,"Bloco CN");
	    		Local local3 = new Local("Centro de Extensao", 45, "Proximo ao ginasio");
	    		
	    		// 5 eventos no tema 1
	    		evento1.addTema(tema1);
	    		evento4.addTema(tema1);
	    		evento8.addTema(tema1);
	    		evento9.addTema(tema1);
	    		evento10.addTema(tema1);
	    		
	    		// 2 eventos no tema 2
	    		evento4.addTema(tema2);
	    		evento10.addTema(tema2);
	    		
	    		// 4 eventos no tema 3
	    		evento2.addTema(tema3);		
	    		evento4.addTema(tema3);
	    		evento5.addTema(tema3);
	    		evento6.addTema(tema3);
	    		
	    		// 4 eventos no tema 4
	    		evento1.addTema(tema4);
	    		evento3.addTema(tema4);
	    		evento4.addTema(tema4);
	    		evento10.addTema(tema4);
	    		
	    		// 3 eventos no tema 5
	    		evento1.addTema(tema5);
	    		evento2.addTema(tema5);
	    		evento7.addTema(tema5);	
	    		
	    		evento1.setLocal(local1);
	    		evento2.setLocal(local2);
	    		evento3.setLocal(local3);
	    		evento4.setLocal(local1);
	    		evento5.setLocal(local2);
	    		evento6.setLocal(local3);
	    		evento7.setLocal(local1);
	    		evento8.setLocal(local2);
	    		evento9.setLocal(local3);
	    		evento10.setLocal(local1);
	    		
	    		evento1.addParticipanteNoEvento(usuario1);
	    		evento1.addParticipanteNoEvento(usuario2);
	    		evento1.addParticipanteNoEvento(usuario3);
	    		evento1.addParticipanteNoEvento(usuario4);
	    		evento1.addParticipanteNoEvento(usuario5);
	    		evento1.addParticipanteNoEvento(usuario6);
	    		evento1.addParticipanteNoEvento(usuario7);
	    		evento1.addParticipanteNoEvento(usuario8);
	    		evento1.addParticipanteNoEvento(usuario9);
	    		evento1.addParticipanteNoEvento(usuario10);
	    		evento1.addParticipanteNoEvento(usuario11);
	    		evento1.addParticipanteNoEvento(usuario12);
	    		evento1.addParticipanteNoEvento(usuario13);
	    		evento1.addParticipanteNoEvento(usuario14);
	    		evento1.addParticipanteNoEvento(usuario15);
	    		evento1.addParticipanteNoEvento(usuario16);
	    		evento1.addParticipanteNoEvento(usuario17);
	    		evento1.addParticipanteNoEvento(usuario18);
	    		evento1.addParticipanteNoEvento(usuario19);
	    		
	    		evento2.addParticipanteNoEvento(usuario1);
	    		evento2.addParticipanteNoEvento(usuario2);
	    		evento2.addParticipanteNoEvento(usuario3);
	    		evento2.addParticipanteNoEvento(usuario4);
	    		evento2.addParticipanteNoEvento(usuario5);
	    		evento2.addParticipanteNoEvento(usuario6);
	    		evento2.addParticipanteNoEvento(usuario7);
	    		evento2.addParticipanteNoEvento(usuario8);
	    		evento2.addParticipanteNoEvento(usuario15);
	    		evento2.addParticipanteNoEvento(usuario16);
	    		evento2.addParticipanteNoEvento(usuario17);
	    		evento2.addParticipanteNoEvento(usuario18);
	    		evento2.addParticipanteNoEvento(usuario19);
	    		
	    		evento3.addParticipanteNoEvento(usuario1);
	    		evento3.addParticipanteNoEvento(usuario2);
	    		evento3.addParticipanteNoEvento(usuario3);
	    		evento3.addParticipanteNoEvento(usuario4);
	    		evento3.addParticipanteNoEvento(usuario5);
	    		evento3.addParticipanteNoEvento(usuario6);
	    		evento3.addParticipanteNoEvento(usuario7);
	    		
	    		
	    		evento4.addParticipanteNoEvento(usuario1);
	    		evento4.addParticipanteNoEvento(usuario2);
	    		evento4.addParticipanteNoEvento(usuario3);
	    		evento4.addParticipanteNoEvento(usuario4);
	    		evento4.addParticipanteNoEvento(usuario5);
	    		evento4.addParticipanteNoEvento(usuario6);
	    		evento4.addParticipanteNoEvento(usuario7);
	    		evento4.addParticipanteNoEvento(usuario8);
	    		evento4.addParticipanteNoEvento(usuario9);
	    		evento4.addParticipanteNoEvento(usuario10);
	    		evento4.addParticipanteNoEvento(usuario11);
	    		evento4.addParticipanteNoEvento(usuario12);
	    		evento4.addParticipanteNoEvento(usuario13);
	    		evento4.addParticipanteNoEvento(usuario14);
	    		evento4.addParticipanteNoEvento(usuario15);
	    		evento4.addParticipanteNoEvento(usuario16);
	    		evento4.addParticipanteNoEvento(usuario17);
	    		evento4.addParticipanteNoEvento(usuario18);
	    		evento4.addParticipanteNoEvento(usuario19);
	    		
	    	
	    		evento5.addParticipanteNoEvento(usuario10);
	    		evento5.addParticipanteNoEvento(usuario11);
	    		evento5.addParticipanteNoEvento(usuario12);
	    		evento5.addParticipanteNoEvento(usuario13);
	    		evento5.addParticipanteNoEvento(usuario14);
	    		evento5.addParticipanteNoEvento(usuario15);
	    		evento5.addParticipanteNoEvento(usuario16);
	    		evento5.addParticipanteNoEvento(usuario17);
	    		evento5.addParticipanteNoEvento(usuario18);
	    		evento5.addParticipanteNoEvento(usuario19);
	    		
	    		evento6.addParticipanteNoEvento(usuario1);
	    		evento6.addParticipanteNoEvento(usuario2);
	    		evento6.addParticipanteNoEvento(usuario3);
	    		evento6.addParticipanteNoEvento(usuario4);
	    		evento6.addParticipanteNoEvento(usuario5);
	    		evento6.addParticipanteNoEvento(usuario6);
	    		evento6.addParticipanteNoEvento(usuario7);
	    
	    		evento6.addParticipanteNoEvento(usuario16);
	    		evento6.addParticipanteNoEvento(usuario17);
	    		evento6.addParticipanteNoEvento(usuario18);
	    		evento6.addParticipanteNoEvento(usuario19);
	    		
	    		evento7.addParticipanteNoEvento(usuario1);
	    		evento7.addParticipanteNoEvento(usuario2);
	    		evento7.addParticipanteNoEvento(usuario3);
	    		evento7.addParticipanteNoEvento(usuario4);
	    		evento7.addParticipanteNoEvento(usuario5);
	    		evento7.addParticipanteNoEvento(usuario6);
	    		evento7.addParticipanteNoEvento(usuario7);
	    		evento7.addParticipanteNoEvento(usuario8);
	    		evento7.addParticipanteNoEvento(usuario9);
	    		evento7.addParticipanteNoEvento(usuario10);
	    		evento7.addParticipanteNoEvento(usuario11);
	    		evento7.addParticipanteNoEvento(usuario12);
	    		evento7.addParticipanteNoEvento(usuario13);
	    		evento7.addParticipanteNoEvento(usuario14);
	    		evento7.addParticipanteNoEvento(usuario15);
	    		evento7.addParticipanteNoEvento(usuario16);
	    		evento7.addParticipanteNoEvento(usuario17);
	    		evento7.addParticipanteNoEvento(usuario18);
	    		evento7.addParticipanteNoEvento(usuario19);
	    		
	    		dao.persist(evento1);
	    		dao.persist(evento2);
	    		dao.persist(evento3);
	    		dao.persist(evento4);
	    		dao.persist(evento5);
	    		dao.persist(evento6);
	    		dao.persist(evento7);
	    		dao.persist(evento8);
	    		dao.persist(evento9);
	    		dao.persist(evento10);
	    		dao.flush();
	    		
			}
		});
	}
	
	@Override
	public void onStop(Application app) {
		Logger.info("Aplicação desligada...");
	}
}
