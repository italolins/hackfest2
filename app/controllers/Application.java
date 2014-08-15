package controllers;

import java.util.List;

import models.*;
import models.dao.GenericDAO;
import models.dao.GenericDAOImpl;
import play.*;
import play.data.DynamicForm;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.*;
import views.html.*;
import play.mvc.Controller;

public class Application extends Controller {
	static Form<Evento> eventoForm = Form.form(Evento.class);
	static Form<Pessoa> pessoaForm = Form.form(Pessoa.class);
	private static GenericDAO dao = new GenericDAOImpl();
	private static int controleInicio;
	
	private static Sistema sistema = Sistema.getInstance();
	
	@Transactional
    public static Result index() {
		inicializaDados();
    	if(session().get("user") == null){
    		return redirect(routes.Login.show());
    	}
    	Sistema sistema = Sistema.getInstance();
        return ok(index.render("Home Page",sistema));
    }
    
    @Transactional
    public static Result sistema() {
    	inicializaDados();
    	Sistema sistema = Sistema.getInstance();
    	return ok(views.html.sistema.render(sistema,false));
    	
    }
    
    @Transactional
    public static void inicializaDados(){
    	controleInicio = controleInicio + 1;
    	if (controleInicio == 1){
    		
    		Evento evento1;
    		Evento evento2;
    		Evento evento3;
    		Evento evento4;
    		Evento evento5;
    		Evento evento6;
    		Evento evento7;
    		Evento evento8;
    		Evento evento9;
    		Evento evento10;
    		
    		String tema1;
    		String tema2;
    		String tema3;
    		String tema4;
    		String tema5;
    		
    		
    		evento1 = new Evento("Dados abertos", "Esse evento tem o objetivo de realizar atividades com dados abertos", "11/09/2014", "Jose", "jose@gmail.com");
    		evento2 = new Evento("HTML", "Esse evento tem o objetivo de realizar atividades com HTML", "09/09/2014", "Jose", "jose@gmail.com");
    		evento3 = new Evento("Computacao Desplugada", "Esse evento tem o objetivo de realizar atividades com computacao desplugada", "11/06/2014", "Jose", "jose@gmail.com");
    		evento4 = new Evento("Metodos Formais", "Esse evento tem o objetivo de realizar atividades com metodos formais", "18/06/2014", "Jose", "jose@gmail.com");
    		evento5 = new Evento("Banco de Dados Gerenciais", "Esse evento tem o objetivo de realizar atividades com banco de dados gerenciais", "11/09/2014", "Jose", "jose@gmail.com");
    		evento6 = new Evento("Banco de Dados Sequenciais", "Esse evento tem o objetivo de realizar atividades com banco de dados sequenciais", "14/09/2014", "Jose", "jose@gmail.com");
    		evento7 = new Evento("Sites Dinamicos", "Esse evento tem o objetivo de realizar atividades com sites dinamicos", "17/08/2014", "Jose", "jose@gmail.com");
    		evento8 = new Evento("Aplicações Java", "Esse evento tem o objetivo de realizar atividades com aplicacoes java", "01/09/2014", "Jose", "jose@gmail.com");
    		evento9 = new Evento("Estruturas de dados", "Esse evento tem o objetivo de realizar atividades com estruturas de dados", "12/07/2014", "Jose", "jose@gmail.com");
    		evento10 = new Evento("Binarios", "Esse evento tem o objetivo de realizar atividades com binarios sem a utilizacao de computador", "11/09/2014", "Jose", "jose@gmail.com");
    		
    		tema1 = "Engenharia de Software";
    		tema2 = "Sistemas da Informacao";
    		tema3 = "Banco de Dados";
    		tema4 = "Computacao Desplugada";
    		tema5 = "Desenvolvimento para Web";
    		
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
    		
    		
    		
    		getDao().persist(evento1);
    		getDao().persist(evento2);
    		getDao().persist(evento3);
    		getDao().persist(evento4);
    		getDao().persist(evento5);
    		getDao().persist(evento6);
    		getDao().persist(evento7);
    		getDao().persist(evento8);
    		getDao().persist(evento9);
    		getDao().persist(evento10);
    		getDao().flush();
    		controleInicio++;
    		
    	}
    }
    
    
    @Transactional
    public static Result cadastro() {
    	Sistema sistema = Sistema.getInstance();
    	return ok(views.html.cadastro.render(sistema));
    	
    }
    
    @Transactional
    public static Result newEvento() {
    	
    	// O formulario de evento
		Form<Evento> filledForm = eventoForm.bindFromRequest();
		DynamicForm requestData = Form.form().bindFromRequest();
		
		String nome = requestData.get("nome");
		String descricao = requestData.get("descricao");
		String data = requestData.get("data");
		String tema1 = requestData.get("tema1");
		String tema2 = requestData.get("tema2");
		String tema3 = requestData.get("tema3");
		String tema4 = requestData.get("tema4");
		String tema5 = requestData.get("tema5");
		String email = requestData.get("EmailAdmin");
		String nomeAdm = requestData.get("nomeAdmin");
		
		String nomeLocal = requestData.get("nomeLocal");
		String comoChego = requestData.get("rota");
		int capacidade = Integer.parseInt(requestData.get("capacidade"));
		
		
		//Não entendi como funciona isso
		Evento evento = filledForm.get(); 
		
		evento = new Evento(nome,descricao,data,email,nomeAdm);
		evento.addTema(tema1);
		evento.addTema(tema2);
		evento.addTema(tema3);
		evento.addTema(tema4);
		evento.addTema(tema5);
		
		Sistema sistema = Sistema.getInstance();
		evento.addLocal(nomeLocal, comoChego, capacidade);
    	if (filledForm.hasErrors()) {
			return badRequest(views.html.cadastro.render(sistema));
		} else {
			
			sistema.addEvento(evento);
			
			return redirect(routes.Application.index());
		}
    	
    	
    }
    
    @Transactional
    public static Result participar(Long id) {
    	Sistema sistema = Sistema.getInstance();
    	Evento evento = sistema.getEvento(id);
    	String email = session().get("email");
    	sistema.addPessoaNoEvento(id, new Usuario(email,null,null));
    	return ok(views.html.evento.render(sistema, evento));
    }
    
    @Transactional
    public static Result addParticipante(Long id) {
    	DynamicForm requestData = Form.form().bindFromRequest();
    	
		String nome = requestData.get("nome");
		String email = requestData.get("email");
		
		Evento evento = sistema.getEvento(id); 
		
		Sistema sistema = Sistema.getInstance();
		sistema.addPessoaNoEvento(evento, new Usuario(email,null,nome));
		return ok(views.html.evento.render(sistema, evento));
	}
    	
    	
    	
    	
    

	public static GenericDAO getDao() {
		return dao;
	}

	public static void setDao(GenericDAO dao) {
		Application.dao = dao;
	}
    
    

}
