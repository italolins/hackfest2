package models;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class GerenciadorPorExperiencia extends GerenciadorDeVagas {
	
	@Id
	@SequenceGenerator(name = "GERENCIADORPOREXPERIENCIA_SEQUENCE", sequenceName = "GERENCIADORPOREXPERIENCIA_SEQUENCE", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	@Override
	public void addParticipanteNoEvento(List<Usuario> usuarios, Usuario usuario,int capacidade) {
		
		if(usuarios.size() == capacidade){
			Usuario noob = usuarios.get(0);
			for(Usuario u: usuarios){
				if(u.compareTo(noob) < 0){
					noob = u;
				}
			}
			/*
			 * Se o usuario tem menos experiencia
			 * que o que tem menos experiencia do evento
			 * e se o evento nao tem esse novo usuario
			 */
			if(usuario.compareTo(noob) > 0 && !usuarios.contains(usuario)){
				usuarios.remove(noob);
				usuarios.add(usuario);
			}
		}else{
			usuarios.add(usuario);
		}
		
	}
	
	@Override
	public Long getId() {
		return id;
	}
	
	@Override
	public void setId(Long id) {
		this.id = id;
	}

}
