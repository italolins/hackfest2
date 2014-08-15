package controllers;

import static play.data.Form.form;
import models.Usuario;
import models.Usuario;
import models.dao.GenericDAO;
import models.dao.GenericDAOImpl;
import play.data.DynamicForm;
import play.data.Form;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.registro;

public class Registro extends Controller {
	
	private static GenericDAO dao = new GenericDAOImpl();
	private static Form<Usuario> registroForm = form(Usuario.class).bindFromRequest();

	@Transactional
    public static Result show() {
        return ok(registro.render(registroForm));
    }
    
	@Transactional
	public static Result registrar() {
		DynamicForm requestData = Form.form().bindFromRequest();
    	
		String nome = requestData.get("nome");
		String email = requestData.get("email");
		String senha = requestData.get("pass");
		
		Usuario u = new Usuario(email,senha,nome); //registroForm.bindFromRequest().get();
    	
//		if (registroForm.hasErrors() ||
//				validate(u.getEmail())) {
//			flash("fail", "Email já está em uso");
//            return badRequest(registro.render(registroForm));
//        } else {
        	dao.persist(u);
            return redirect(
                routes.Login.show()
            );
       // }
    }
	
	private static boolean validate(String email) {
		return true;
	}

}
