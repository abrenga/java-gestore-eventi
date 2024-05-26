package org.java.generate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] arvs) {
		LocalDate dateOra = LocalDate.now();

		ProgrammEventi eventoProgrammato = new ProgrammEventi("Agenda Prenotazione");
		initSteps.popolaAgendaEventi(eventoProgrammato);
		List<Evento> ArrayListEventoPerData = eventoProgrammato.listaDiEventi(dateOra);

		Evento e = initSteps.sceltaDelEventoDaParteDelTerminale(eventoProgrammato);

		initSteps.scelteTerminaleDopoLaSelezioneDellEvento(e, ArrayListEventoPerData, dateOra, eventoProgrammato);
	}

}
