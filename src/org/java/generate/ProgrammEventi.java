package org.java.generate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgrammEventi {

	private String titolo;
	private List<Evento> eventi;

	public ProgrammEventi(String titolo) {
		this.titolo = titolo;
		this.eventi = new ArrayList<Evento>();

	}

//un metodo che aggiunge alla lista un Evento, passato come parametro
	public void addEvento(Evento evento) {
		eventi.add(evento);

	}

	// un metodo che restituisce una lista con tutti gli eventi presenti in una
	// certa data
	public List<Evento> listaDiEventi(LocalDate data) {
		List<Evento> eventoPerData= new ArrayList<Evento>(); 

		for (int i = 0; i < eventi.size(); i++) {
			if (data.equals(eventi.get(i).getDataConcerto())) {
				eventoPerData.add(eventi.get(i));	
				
			}
			
		}
		return eventoPerData;
	}
	
	public void removeEvento() {	
		eventi.clear();
		
	}
	
	
	//un metodo che restituisce quanti eventi sono presenti nel programma

}
