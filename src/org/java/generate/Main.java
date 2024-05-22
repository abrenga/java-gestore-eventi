package org.java.generate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

	public static void main(String[] arvs) {
		Scanner scanner = new Scanner(System.in);
		LocalDate dateOra = LocalDate.now();
		Evento concertoSubsonica = new Concerto("Subsonica", 100000L, LocalDate.of(2027, 05, 28), 55.00f);
		Evento concertoMetallica = new Concerto("Metallica", 1000050L, LocalDate.of(2027, 07, 20), 60.00f);
		Evento concertoGigiDalessio = new Concerto("Gigi D'Alessio", 10050L, LocalDate.of(2021, 02, 28), 60.00f);
		Evento concertoManeskin = new Concerto("Maneskin", 1000050L, LocalDate.of(2024, 07, 20), 60.00f);

		System.out.println("inserisci un nuovo Evento:");
		System.out.println("tipologia Evento");
		String EventoTitolo = scanner.nextLine();

		System.out.println("Posti Totali a disposizione:");
		String postiTotali = scanner.nextLine();

		System.out.println("Data Evento (formato accettato:dd-MM-yyyy): ");
		String dataEvento = scanner.nextLine();

		Evento eventoInserito = new Evento(EventoTitolo, Long.parseLong(postiTotali),
				LocalDate.parse(dataEvento, DateTimeFormatter.ofPattern("dd-MM-yyyy")));

		System.out.println("quante prenotazioni vuoi effettuare?");

		String preotazioniRicheste = scanner.nextLine();

		int prenotazioniRichiesteInNumero = Integer.parseInt(preotazioniRicheste);

		eventoInserito.prenota(dateOra, prenotazioniRichiesteInNumero);

		System.out.println("posti prenotati: " + eventoInserito.getNumeriPostiPrenotati() + " posti totali: "
				+ eventoInserito.getPostiTotali() + " postiRimanenti: " + eventoInserito.getPostiRimanenti());

		System.out.println("vuoi Disdire?");
		String vuoiDisdire = scanner.nextLine();
		String generalResponse = vuoiDisdire.toLowerCase();

		if (utenteVuoleConfermare(generalResponse)) {
			System.out.println("quante prenotazioni vuoi Disdire?");
			String preotazioniDaDisdire = scanner.nextLine();
			int uff = Integer.parseInt(preotazioniDaDisdire);

			eventoInserito.disdici(dateOra, uff);
			System.out.println("posti prenotati: " + eventoInserito.getNumeriPostiPrenotati() + " posti totali: "
					+ eventoInserito.getPostiTotali() + " postiRimanenti: " + eventoInserito.getPostiRimanenti());

		} else {
			System.out.println("posti prenotati: " + eventoInserito.getNumeriPostiPrenotati() + " posti totali: "
					+ eventoInserito.getPostiTotali() + " postiRimanenti: " + eventoInserito.getPostiRimanenti());
		}

		System.out.println();
		System.out.println();
		System.out.println("----------------------------Eventi ordinati per Data-------------------------");
		System.out.println();

		ProgrammEventi AgendaEventi = new ProgrammEventi("Agenda Eventi");
		AgendaEventi.addEvento(concertoMetallica);
		AgendaEventi.addEvento(concertoSubsonica);
		AgendaEventi.addEvento(concertoGigiDalessio);
		AgendaEventi.addEvento(concertoManeskin);
		AgendaEventi.addEvento(eventoInserito);

		System.out.println(AgendaEventi);

	}

	private static boolean utenteVuoleConfermare(String x) {
		if (x.equals("si")) {
			return true;
		} else {
			return false;
		}
	}

}
