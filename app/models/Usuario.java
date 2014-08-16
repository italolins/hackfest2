package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity(name="Usuario")
public class Usuario implements Comparable<Usuario> {

	@Id
	@SequenceGenerator(name = "USUARIO_SEQUENCE", sequenceName = "USUARIO_SEQUENCE", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column
	private String email;
	
	@Column
	private String pass;
	
	@Column
	private String nome;
	
	@Column
	private int numEventosCriados;
	
	@Column
	private int numParticipacao;
	
	public Usuario() {
	}
	
	public Usuario(String email, String pass, String nome) {
		this.email = email;
		this.nome = nome;
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumEventosCriados() {
		return numEventosCriados;
	}

	public void setNumEventosCriados(int numEventosCriados) {
		this.numEventosCriados = numEventosCriados;
	}
	
	public void incrementaNumEventosCriados(){
		this.numEventosCriados += 1;
	}

	public int getNumParticipacao() {
		return numParticipacao;
	}

	public void setNumParticipacao(int numParticipacao) {
		this.numParticipacao = numParticipacao;
	}
	
	public void incrementaNumParticipacao(){
		this.numParticipacao += 1;
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
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Usuario)){
			return false;
		}else{
			Usuario pessoa = (Usuario)obj;
			return (pessoa.getEmail().equals(this.email));
		}
	}

	@Override
	public int compareTo(Usuario user) {
		// TODO Auto-generated method stub
		if(numEventosCriados == user.getNumEventosCriados()){
			return numParticipacao - user.getNumParticipacao();
		}
		return numEventosCriados - user.getNumEventosCriados();
	}
}
