package org.java.generate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

class Steps {
	static Scanner scanner = new Scanner(System.in);

	public static void popolaProgrammaEventi(ProgrammaEventi AgendaEventi) {
		Evento concertoSubsonica = new Concerto("Subsonica", 100000L, LocalDate.of(2027, 05, 28), 55.50f);
		Evento concertoMetallica = new Concerto("Irama", 1000050L, LocalDate.of(2027, 07, 20), 60.80f);
		Evento concertoGigiDalessio = new Concerto("Angelina Mango", 10050L, LocalDate.of(2021, 02, 28), 60.40f);
		Evento concertoManeskin = new Concerto("Maneskin", 1000050L, LocalDate.of(2024, 07, 20), 60.50f);

		AgendaEventi.addEvento(concertoMetallica);
		AgendaEventi.addEvento(concertoSubsonica);
		AgendaEventi.addEvento(concertoGigiDalessio);
		AgendaEventi.addEvento(concertoManeskin);

	}

	public static Evento creaEventoDaTipo(String tipologiaEvento) {
		if (tipologiaEvento.equals("concerto")) {

			System.out.println("nome Evento");
			String EventoTitolo = scanner.nextLine();

			System.out.println("Posti Totali a disposizione:");
			String postiTotali = scanner.nextLine();
			
			System.out.println("Data Evento (formato accettato:dd-MM-yyyy): ");
			String dataEvento = scanner.nextLine();

			
			System.out.println("che prezzo vuoi dare al concerto");
			String prezzo = scanner.nextLine();

			System.out.println("Evento Aggiunto");

			Evento eventoInserito = new Concerto(EventoTitolo, Long.parseLong(postiTotali),
					LocalDate.parse(dataEvento, DateTimeFormatter.ofPattern("dd-MM-yyyy")), Float.valueOf(prezzo));
			return eventoInserito;
		} else {
			System.out.println("nome Evento");
			String EventoTitolo = scanner.nextLine();

			System.out.println("Posti Totali a disposizione:");
			String postiTotali = scanner.nextLine();

			System.out.println("Data Evento (formato accettato:dd-MM-yyyy): ");
			String dataEvento = scanner.nextLine();

			System.out.println("Evento Aggiunto");

			Evento eventoInserito = new Evento(EventoTitolo, Long.parseLong(postiTotali),
					LocalDate.parse(dataEvento, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
			return eventoInserito;
		}

	}

	public static Evento creaEvento() {
		System.out.println("inserisci una nuova tipologia di Evento:");
		String tipologiaEvento = scanner.nextLine();
		return creaEventoDaTipo(tipologiaEvento);

	}

	private static boolean rispostaAffermativa(String x) {
		if (x.equals("si")) {
			return true;
		} else {
			return false;
		}
	}

	public static void effettuaPrenotazione(Evento evento, LocalDate dataOra) {
		System.out.println("quante prenotazioni vuoi effettuare?");

		String preotazioniRicheste = scanner.nextLine();

		int prenotazioniRichiesteInNumero = Integer.parseInt(preotazioniRicheste);

		evento.prenota(dataOra, prenotazioniRichiesteInNumero);

		System.out.println("posti prenotati: " + evento.getNumeriPostiPrenotati() + " posti totali: "
				+ evento.getPostiTotali() + " postiRimanenti: " + evento.getPostiRimanenti());

	}

	public static void vuoleDisdire(Evento evento, LocalDate dataOra) {
		System.out.println("vuoi Disdire?");
		String vuoiDisdire = scanner.nextLine();
		String generalResponse = vuoiDisdire.toLowerCase();

		if (rispostaAffermativa(vuoiDisdire)) {
			System.out.println("quante prenotazioni vuoi Disdire?");
			String preotazioniDaDisdire = scanner.nextLine();
			int uff = Integer.parseInt(preotazioniDaDisdire);

			evento.disdici(dataOra, uff);
			System.out.println("posti prenotati: " + evento.getNumeriPostiPrenotati() + " posti totali: "
					+ evento.getPostiTotali() + " postiRimanenti: " + evento.getPostiRimanenti());

		} else {
			System.out.println("posti prenotati: " + evento.getNumeriPostiPrenotati() + " posti totali: "
					+ evento.getPostiTotali() + " postiRimanenti: " + evento.getPostiRimanenti());
		}
	}

	private static void menuPrincipale() {
		System.out.println("[A] Aggiungi un nuovo evento");
		System.out.println("[B] seleziona un evento gia presente");
	}

	private static void sottoMenu() {
		System.out.println("[1]  effetua prenotazioni");
		System.out.println("[2] disdici prenotazioni");
		System.out.println("[3] mostra eventi in agenda");
		System.out.println("[4] rimuovi eventi");
	}

	private static void selezionaOpzioni(Evento evento, LocalDate dateOra,
			ProgrammaEventi eventiProgrammati) {
		switch (scanner.nextLine()) {
		case "1":
			effettuaPrenotazione(evento, dateOra);

			break;
		case "2":
			vuoleDisdire(evento, dateOra);

			// code block
			break;
		case "3":
			System.out.print(eventiProgrammati.toString());

			// code block
			break;
		case "4":
			eventiProgrammati.removeEvento();
			System.out.println("Agenda Svuotata");
			// code block
			break;
		}

	}

	public static Evento selezionaEvento(ProgrammaEventi agenda) {
		menuPrincipale();
		switch (scanner.nextLine()) {
		case "A":
			Evento evento = creaEvento();
			agenda.addEvento(evento);

			return evento;

		case "B":
			System.out.println("Quale evento vuoi selezionare?");
			return agenda.eventogiaEsistente(scanner.nextLine());
		}
		return null;
	}

	static void loopSceltaOpzioni(Evento evento, LocalDate dateOra,
			ProgrammaEventi eventiProgrammati) {
		while (true) {
			sottoMenu();
			selezionaOpzioni(evento, dateOra, eventiProgrammati);

			System.out.println("vuoi effetuare altre operazioni?");
			if (!rispostaAffermativa(scanner.nextLine())) {
				System.out.println("Operazioni Concluse");
				break;
			}
		}
	}

}
