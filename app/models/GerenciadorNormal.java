package models;

public class GerenciadorNormal implements GerenciadorDeVagas{

	
	@Override
	public void addParticipanteNoEvento(Evento evento, Usuario usuario) {
		if(evento.getNumDePessoasQueConfirmaram() < evento.getLocal().getCapacidade()){
			evento.addParticipanteNoEvento(usuario);
		}
		
	}
	
}
