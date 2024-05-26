package org.java.generate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] arvs) {
		LocalDate dataOdierna = LocalDate.now();

		ProgrammaEventi agendaEventi = new ProgrammaEventi("Agenda Prenotazione");
		Steps.popolaProgrammaEventi(agendaEventi);
		List<Evento> ArrayListEventoPerData = agendaEventi.listaDiEventi(dataOdierna);

		Evento eventoSelezionato = Steps.selezionaEvento(agendaEventi);

		Steps.loopSceltaOpzioni(eventoSelezionato, ArrayListEventoPerData, dataOdierna, agendaEventi);
	}

}
