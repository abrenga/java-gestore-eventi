package org.java.generate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] arvs) {
		LocalDate dateOra = LocalDate.now();
		
		
		Evento evento = initSteps.popolaEvento();
		ProgrammEventi eventoProgrammato = new ProgrammEventi("Agenda Prenotazione");
		initSteps.popolaAgendaEventi(eventoProgrammato);
		List<Evento> ArrayListEventoPerData=  eventoProgrammato.listaDiEventi(dateOra);
		eventoProgrammato.addEvento(evento); 
		
		initSteps.preferenzeUtente(evento,ArrayListEventoPerData,dateOra,eventoProgrammato);
		
		


		
		
	

		
	}



}
