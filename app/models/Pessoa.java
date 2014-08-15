package models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.SequenceGenerator;

@Entity(name = "Pessoa")
public class Pessoa {
	// Gerador de Sequencia para o Id
	// Todo Id tem que ter o GeneratedValue a não ser que ele seja setado
	@Id
	@SequenceGenerator(name = "PESSOA_SEQUENCE", sequenceName = "PESSOA_SEQUENCE", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy = GenerationType.TABLE)
	// Usar Id sempre Long
	private Long id;
	
	@Column
	private String nome;
	
	@Column
	private String email;
	
	@Column
	private String senha;
	
	@Column
	private boolean logado;
	
	// Construtor vazio para o Hibernate criar os objetos
	public Pessoa (){
		
	}
	

	public Pessoa (String nome, String email, String senha){
		this.email = email;
		this.nome = nome;
		this.senha = senha;
		logado = false;
	}

	public boolean isLogado() {
		return logado;
	}


	public void setLogado(boolean logado) {
		this.logado = logado;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Pessoa)){
			return false;
		}else{
			Pessoa pessoa = (Pessoa)obj;
			return (pessoa.getNome().equals(this.nome) && pessoa.getSenha().equals(this.senha));
		}
	}	

}
