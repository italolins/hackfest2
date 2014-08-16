package models;

import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public abstract class GerenciadorDeVagas {
	
	@Id
	@SequenceGenerator(name = "GERENCIADORDEVAGAS_SEQUENCE", sequenceName = "GERENCIADORDEVAGAS_SEQUENCE", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;
	
	public GerenciadorDeVagas(){
		
	}
	
	
	public abstract void addParticipanteNoEvento(List<Usuario> usuarios,Usuario usuario,int capacidade);

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
