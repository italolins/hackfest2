package models;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class GerenciadorNormal extends GerenciadorDeVagas{
	
	@Id
	@SequenceGenerator(name = "GERENCIADORNORMAL_SEQUENCE", sequenceName = "GERENCIADORNORMAL_SEQUENCE", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	public GerenciadorNormal(){
		
	}
	
	@Override
	public void addParticipanteNoEvento(List<Usuario> usuarios, Usuario usuario,int capacidade) {
		/*
		 * se ainda tem vaga no evento
		 * e se o novo participante ja
		 * esta no evento
		 */
		if((usuarios.size() < capacidade) && !usuarios.contains(usuario)){
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
