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
	private static Form<Evento> eventoForm = Form.form(Evento.class);
	private static GenericDAO dao = new GenericDAOImpl();
	private static int controleInicio;
	
	private static Sistema sistema = Sistema.getInstance();
	
	@Transactional
    public static Result index() {
    	if(session().get("user") == null){
    		return redirect(routes.Login.show());
    	}
    	Sistema sistema = Sistema.getInstance();
        return ok(index.render("Home Page",sistema));
    }
    
    @Transactional
    public static Result sistema() {
    	Sistema sistema = Sistema.getInstance();
    	return ok(views.html.sistema.render(sistema,false));
    }
    
    
    @Transactional
    public static Result cadastro() {
    	if(session().get("user") == null){
    		return redirect(routes.Login.show());
    	}
    	Sistema sistema = Sistema.getInstance();
    	return ok(views.html.cadastro.render(sistema));
    	
    }
    
    @Transactional
    public static Result newEvento() {
    	
    	
		DynamicForm requestData = Form.form().bindFromRequest();
		
		Sistema sistema = Sistema.getInstance();
		
		String nome = requestData.get("nome");
		String descricao = requestData.get("descricao");
		String data = requestData.get("data");
		String tema1 = requestData.get("tema1");
		String tema2 = requestData.get("tema2");
		String tema3 = requestData.get("tema3");
		String tema4 = requestData.get("tema4");
		String tema5 = requestData.get("tema5");
		
		
		String email = session().get("email");
		String nomeAdm = session().get("user");
		
		String localSelecionado = requestData.get("local");
		
		String prioridade = requestData.get("tipo");
		
		//Não entendi como funciona isso
		Evento evento; // = filledForm.get(); 
		
		evento = new Evento(nome,descricao,data,email,nomeAdm);
		evento.addTema(tema1);
		evento.addTema(tema2);
		evento.addTema(tema3);
		evento.addTema(tema4);
		evento.addTema(tema5);
		
		/*
		 * esse trecho eh responsavel pelo cadastro/escolha
		 * do local
		 */
		if(localSelecionado.equals("Cadastrar local")){
			String nomeLocal = requestData.get("nomeLocal");
			String comoChego = requestData.get("rota");
			int capacidade = Integer.parseInt(requestData.get("capacidade"));
			evento.addLocal(nomeLocal, comoChego, capacidade);
		}else{
			List<Local> locais = sistema.getLocais();
			for(Local l :locais){
				if(l.getNome().equals(localSelecionado)){
					evento.addLocal(l.getNome(), l.getComoChegar(), l.getCapacidade());
				}
			}
		}
		
		Usuario u = sistema.getUsuario(nomeAdm, null, email);
		u.incrementaNumEventosCriados();
		
    	
			
		sistema.addEvento(evento);
			
		return redirect(routes.Application.index());
		
    	
    	
    }
    
    @Transactional
    public static Result participar(Long id) {
    	Sistema sistema = Sistema.getInstance();
    	Evento evento = sistema.getEvento(id);
    	String email = session().get("email");
    	try {
			sistema.addPessoaNoEvento(id, new Usuario(email,null,null));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return ok(views.html.evento.render(sistema, evento));
    }
    
    @Transactional
    public static Result addParticipante(Long id) {
    	DynamicForm requestData = Form.form().bindFromRequest();
    	
		String nome = requestData.get("nome");
		String email = requestData.get("email");
		
		Evento evento = sistema.getEvento(id); 
		
		Sistema sistema = Sistema.getInstance();
		try {
			sistema.addPessoaNoEvento(evento, new Usuario(email,null,nome));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ok(views.html.evento.render(sistema, evento));
	}
    	
    	
    	
    	
    

	public static GenericDAO getDao() {
		return dao;
	}

	public static void setDao(GenericDAO dao) {
		Application.dao = dao;
	}
    
    

}
