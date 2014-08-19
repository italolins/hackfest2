package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name = "Local")
public class Local {
	
	@Column
	private String nome;
	
	@Column
	private int capacidade;
	
	@Column
	private String comoChegar;
	
	@Id
	@SequenceGenerator(name = "LOCAL_SEQUENCE", sequenceName = "LOCAL_SEQUENCE", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy = GenerationType.TABLE)
	// Usar Id sempre Long
	private Long id;
	
	public Local(){
		
	}
	
	/**
	 * 
	 * @param nome do local
	 * @param capacidade do local
	 * @param comoChegar descricao de como chegar
	 */
	public Local(String nome,int capacidade,String comoChegar){
		this.nome = nome;
		this.capacidade = capacidade;
		this.comoChegar = comoChegar;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getComoChegar() {
		return comoChegar;
	}

	public void setComoChegar(String comoChegar) {
		this.comoChegar = comoChegar;
	}

	public int getCapacidade() {
		return capacidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	
	/*
	 * Um local eh igual a outro se os nomes forem os mesmos
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Local)){
			return false;
		}else{
			Local l = (Local)obj;
			return l.getNome().equals(this.nome);
		}
	}

}
