package models;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity(name = "Evento")
public class Evento implements Comparable<Evento> {
	
	// Gerador de Sequencia para o Id
	// Todo Id tem que ter o GeneratedValue a não ser que ele seja setado
	@Id
	@SequenceGenerator(name = "EVENTO_SEQUENCE", sequenceName = "EVENTO_SEQUENCE", allocationSize = 1, initialValue = 0)
	@GeneratedValue(strategy = GenerationType.TABLE)
	// Usar Id sempre Long
	private Long id;
	
	@Column	
	private String nome;
	
	@Column
	private String descricao;
	
	@Column
	private String data;

	@Column
	private String tema1;
	
	@Column
	private String tema2;
	
	@Column
	private String tema3;
	
	@Column
	private String tema4;
	
	@Column
	private String tema5;
	
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn
//	private GerenciadorDeVagas gerenciador;
		
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn 
	private List<Usuario> pessoasQueConfirmaram;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn
	private Local local;
	
	@Column
	private String nomeAdmin;
	
	@Column
	private String emailAdmin;
	
	// Construtor vazio para o Hibernate criar os objetos
	public Evento(){
		this.pessoasQueConfirmaram = new ArrayList<Usuario>();
//		gerenciador = new GerenciadorNormal();
	}
	
	public Evento(String nome, String descricao, String data, String nomeAdmin, String emailAdmin) {
		this.nome = nome;
		this.descricao = descricao;
		this.data = data;
		this.nomeAdmin = nomeAdmin;
		this.emailAdmin = emailAdmin;
		this.pessoasQueConfirmaram = new ArrayList<Usuario>();
//		gerenciador = new GerenciadorNormal();
	}
	
	public Local getLocal() {
		return local;
	}
	
	public void setLocal(Local local){
		this.local = local;
	}
	
	public void addLocal(String nome,String rota,int capacidade){
		this.local = new Local(nome,capacidade,rota);
	}
	
	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
		
	public int getNumDePessoasQueConfirmaram() {
		return pessoasQueConfirmaram.size();
	}
	
	/*
	 * Esse metodo da um set na lista de participantes
	 */
	public void setNumDePessoasQueConfirmaram(
			List<Usuario> numDePessoasQueConfirmaram) {
		this.pessoasQueConfirmaram =  numDePessoasQueConfirmaram;
	}
	
	//adiciona participante sem acoplamento
	public void addParticipanteNoEvento(String nome,String email,String senha) {
			try {
				addParticipanteNoEvento(new Usuario(email,senha,nome));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	/*
	 * Verifica se o usuario esta no evento
	 */
	private boolean hasUsuario(String nome,String email,String senha){
		for(Usuario u:pessoasQueConfirmaram){
			try {
				if(u.equals(new Usuario(email,senha,nome))){
					return true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Evento)){
			return false;
		}else{
			Evento event = (Evento)obj;
			return (event.getNome().equals(this.nome));
		}

	}
	
	
	/*
	 * NAO FOI POSSIVEL FINALIZAR ESSE METODO POIS NAO TIVE RESPOSTA
	 * NO PIAZZA SOBRE O PROBLEMA QUE ESTAVA TENDO NA CLASSE ABSTRATA
	 */
	public void addParticipanteNoEvento(Usuario pessoa) {
		if ((!this.pessoasQueConfirmaram.contains(pessoa)) ){
			if(local.getCapacidade() > pessoasQueConfirmaram.size())
				this.pessoasQueConfirmaram.add(pessoa);
		}
		//this.gerenciador.addParticipanteNoEvento(pessoasQueConfirmaram, pessoa, local.getCapacidade());
	}
	
	public void removerParticipanteNoEvento(Usuario pessoa) {
		if (this.pessoasQueConfirmaram.contains(pessoa)){
			this.pessoasQueConfirmaram.remove(pessoa);
		}
		
	}
	
	public int numDePessoasQueConfirmaram(){
		return this.pessoasQueConfirmaram.size();
	}
	
	public boolean isFull(){
		return local.getCapacidade() >= pessoasQueConfirmaram.size();
	}
	
	@Override
	public int compareTo(Evento evento) {
		if (this.pessoasQueConfirmaram.size() > evento.numDePessoasQueConfirmaram()) {
		      return -1;
		    }
	    if (this.pessoasQueConfirmaram.size() < evento.numDePessoasQueConfirmaram()) {
		      return 1;
		    }
	    return 0;
		  
	}	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Usuario> getPessoasQueConfirmaram() {
		return  pessoasQueConfirmaram;
	}
	
	/*
	 * Metodo identico ao setNumPessoasQueConfirmaram
	 */
	public void setPessoasQueConfirmaram(ArrayList<Usuario> pessoasQueConfirmaram) {
		this.pessoasQueConfirmaram =  pessoasQueConfirmaram;
	}
	public String getNomeAdmin() {
		return nomeAdmin;
	}
	public void setNomeAdmin(String nomeAdmin) {
		this.nomeAdmin = nomeAdmin; 
	}
	public String getEmailAdmin() {
		return emailAdmin;
	}
	public void setEmailAdmin(String emailAdmin) {
		this.emailAdmin = emailAdmin;
	}
	
	public List<String> getTemas(){
		List<String> retorno = new ArrayList<String>();
		retorno.add(tema1);
		retorno.add(tema2);
		retorno.add(tema3);
		retorno.add(tema4);
		retorno.add(tema5);
		return retorno;
	}
	
	public void addTema(String tema){
		String tema11 = "Engenharia de Software";
		String tema21 = "Sistemas da Informacao";
		String tema31 = "Banco de Dados";
		String tema41 = "Computacao Desplugada";
		String tema51 = "Desenvolvimento para Web";
		if (tema.equals(tema11)){
			this.tema1 = tema;
			return;
		}
		else if (tema.equals(tema21)){
			this.tema2 = tema;
		}
		else if (tema.equals(tema31)){
			this.tema3 = tema;
		}
		else if (tema.equals(tema41)){
			this.tema4 = tema;
		}
		else if (tema.equals(tema51)){
			this.tema5 = tema;
		}
		
	}
	
	
	

}
