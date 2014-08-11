package models;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.*;

@Entity(name = "Sistema")
public class Sistema {
	// Todo Id tem que ter o GeneratedValue a nÃ£o ser que ele seja setado
	@Id
	@SequenceGenerator(name = "SISTEMA_SEQUENCE", sequenceName = "SISTEMA_SEQUENCE", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy = GenerationType.TABLE)
	// Usar Id sempre Long
	private Long id;	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn
	private List<Evento> eventos;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn
	private List<Pessoa> clientesDoSistema; //Nao sei o pq mas so funciona com Set  =s
	
	
	// Construtor vazio para o Hibernate criar os objetos 
	public Sistema(){
		this.eventos = new ArrayList<Evento>();
		this.clientesDoSistema = new ArrayList<Pessoa>();
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	
	public void addEvento(Evento evento){
		this.eventos.add(evento);
	}
	
	public boolean removeEvento(Evento evento){
		return this.eventos.remove(evento);
	}
	
	public List<Evento> EventosPorTema(String tema){
		if(eventos.isEmpty()){
			return new ArrayList<Evento>();
		}
		List<Evento> retorno = new ArrayList<Evento>();
		for (Evento evento: this.eventos){
			if (evento.getTemas().contains(tema)){
				retorno.add(evento);
			}
		}
		return retorno;
	}
	
	public List<Evento> EventosOrdenadosPorQuantidadeDePessoas(){
		List<Evento> copiaDeEventos = this.eventos;
		Collections.sort(copiaDeEventos);
		return copiaDeEventos;
	}
	
	public int numDeEventos(){
		return this.eventos.size();
	}
	
	public boolean contemEvento(Evento evento){
		return this.eventos.contains(evento);
	}
	
	public void addPessoaNoEvento(Evento evento, Pessoa pessoa){

		if(!eventos.isEmpty()){
			for(Evento e: eventos){
				if(e.equals(evento)){
					e.addParticipanteNoEvento(pessoa);
				}
			}
		}
	}
	
	public void removePessoaDoEvento(Evento evento, Pessoa pessoa){
		if (this.eventos.contains(evento)){
			for (Evento eventoaux : this.eventos){
				if (eventoaux.equals(evento)){
					this.eventos.remove(eventoaux);
					return;
				}
			}
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public void signUp(String nome,String email,String senha){
		clientesDoSistema.add(new Pessoa(nome,email,senha));
	}

	public boolean temUsuario(String nome, String senha) {
		// TODO Auto-generated method stub
		for(Pessoa p:clientesDoSistema){
			if(p.equals(new Pessoa(nome,null,senha))){
				return true;
			}
		}
		return false;
	}

	public Evento getEvento(String nome) {
		Iterator<Evento> it = eventos.iterator();
		while(it.hasNext()){
			Evento proximoEvento = it.next();
			if(proximoEvento.getNome().equals(nome)){
				return proximoEvento;
			}
		}

		return null;
	}
	

}
