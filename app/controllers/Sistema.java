package controllers;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.*;

import play.db.jpa.Transactional;
import models.Evento;
import models.Local;
import models.Usuario;


public class Sistema {
	
	private static Sistema sistema;
	
	private Sistema(){

	}
	
	@Transactional
	public static Sistema getInstance(){
		if(sistema == null){
			sistema = new Sistema();
		}
		return sistema;
	}

	@Transactional
	public List<Evento> getEventos() {
		return Application.getDao().findAllByClassName("Evento");
	}
	
	@Transactional
	public void addEvento(Evento evento){
		if(!contemEvento(evento) && (evento.getNome() != null)){
			Application.getDao().persist(evento);
			Application.getDao().flush();
		}
		
	}
	
	@Transactional
	public List<Local> getLocais(){
		return Application.getDao().findAllByClassName("Local");
	}
	
//	public boolean removeEvento(Evento evento){
//		return this.eventos.remove(evento);
//	}
	
	@Transactional
	public List<Evento> EventosPorTema(String tema){
		List<Evento> e = Application.getDao().findAllByClassName("Evento");
		
		List<Evento> retorno = new ArrayList<Evento>();
		for (Evento evento: e){
			if (evento.getTemas().contains(tema)){
				retorno.add(evento);
			}
		}
		return retorno;
	}
	
	@Transactional
	public List<Evento> EventosOrdenadosPorQuantidadeDePessoas(){
		List<Evento> copiaDeEventos = Application.getDao().findAllByClassName("Evento");
		Collections.sort(copiaDeEventos);
		return copiaDeEventos;
	}
	
	@Transactional
	public int numDeEventos(){
		List<Evento> e = Application.getDao().findAllByClassName("Evento");
		return e.size();
	}
	
	@Transactional
	public boolean contemEvento(Evento evento){
		List<Evento> e = Application.getDao().findAllByClassName("Evento");
		return e.contains(evento);
	}
	
	@Transactional
	public void addPessoaNoEvento(Evento evento, Usuario pessoa){
		List<Evento> eventos = Application.getDao().findAllByClassName("Evento");
		if(!eventos.isEmpty()){
			for(Evento e: eventos){
				if(e.equals(evento)){
					//pessoa.participaEvento(evento);
					e.addParticipanteNoEvento(pessoa);
				}
			}
		}
	}
	
	@Transactional
	public void addPessoaNoEvento(Long idDoEvento,Usuario pessoa){
		Evento evento = getEvento(idDoEvento);
		//pessoa.participaEvento(evento);
		List<Usuario> usuarios = Application.getDao().findAllByClassName("Usuario");
		if(!usuarios.isEmpty()){
			for(Usuario u: usuarios){
				if(u.equals(pessoa)){
					evento.addParticipanteNoEvento(u);
				}
			}
		}
		
	}
	
	@Transactional
	public void removePessoaDoEvento(Evento evento, Usuario pessoa){
		//if (this.eventos.contains(evento)){
			evento.removerParticipanteNoEvento(pessoa);
			
		//}
	}
	@Transactional
	public void signUp(String nome,String email,String senha){
		Application.getDao().persist(new Usuario(email,senha,nome));
		Application.getDao().flush();
	}

	@Transactional
	public boolean temUsuario(String nome, String senha,String email) {
		List<Usuario> clientesDoSistema = Application.getDao().findAllByClassName("Usuario");
		for(Usuario p:clientesDoSistema){
			if(p.equals(new Usuario(email,senha,nome))){
				return true;
			}
		}
		return false;
	}

	@Transactional
	public Evento getEvento(String nome) {
		List<Evento> eventos = Application.getDao().findAllByClassName("Evento");
		Iterator<Evento> it = eventos.iterator();
		while(it.hasNext()){
			Evento proximoEvento = it.next();
			if(proximoEvento.getNome().equals(nome)){
				return proximoEvento;
			}
		}
		return null;
	}
	
	@Transactional
	public Evento getEvento(Long id){
		return Application.getDao().findByEntityId(Evento.class, id);
	}
	
	@Transactional
	public Usuario getUsuario(String nome,String senha,String email){
		List<Usuario> clientesDoSistema = Application.getDao().findAllByClassName("Usuario");
		for(Usuario p:clientesDoSistema){
			if(p.equals(new Usuario(email,senha,nome))){
				return p;
			}
		}
		return null;
	}
	


}
