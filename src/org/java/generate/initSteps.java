package org.java.generate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class initSteps {

	
	public static void popolaAgendaEventi(ProgrammEventi AgendaEventi) {
		Evento concertoSubsonica = new Concerto("Subsonica", 100000L, LocalDate.of(2027, 05, 28), 55.00f);
		Evento concertoMetallica = new Concerto("Metallica", 1000050L, LocalDate.of(2027, 07, 20), 60.00f);
		Evento concertoGigiDalessio = new Concerto("Gigi D'Alessio", 10050L, LocalDate.of(2021, 02, 28), 60.00f);
		Evento concertoManeskin = new Concerto("Maneskin", 1000050L, LocalDate.of(2024, 07, 20), 60.00f);
		
		
		
		AgendaEventi.addEvento(concertoMetallica);
		AgendaEventi.addEvento(concertoSubsonica);
		AgendaEventi.addEvento(concertoGigiDalessio);
		AgendaEventi.addEvento(concertoManeskin);

			
	}
	
	
	
	public static Evento popolaEvento() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("inserisci un nuovo Evento:");
		System.out.println("tipologia Evento");
		String EventoTitolo = scanner.nextLine();

		System.out.println("Posti Totali a disposizione:");
		String postiTotali = scanner.nextLine();

		System.out.println("Data Evento (formato accettato:dd-MM-yyyy): ");
		String dataEvento = scanner.nextLine();
		
		System.out.println("Evento Creato");

		Evento eventoInserito = new Evento(EventoTitolo, Long.parseLong(postiTotali),
				LocalDate.parse(dataEvento, DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		return eventoInserito;
	}
	
	
	private static boolean utenteVuoleConfermare(String x) {
		if (x.equals("si")) {
			return true;
		} else {
			return false;
		}
	}
	
	
	public  static void VuoleLutenteEffettuarePrenotazione(Evento evento,LocalDate dataOra) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("quante prenotazioni vuoi effettuare?");

		String preotazioniRicheste = scanner.nextLine();

		int prenotazioniRichiesteInNumero = Integer.parseInt(preotazioniRicheste);

		evento.prenota(dataOra, prenotazioniRichiesteInNumero);

		System.out.println("posti prenotati: " + evento.getNumeriPostiPrenotati() + " posti totali: "
				+ evento.getPostiTotali() + " postiRimanenti: " + evento.getPostiRimanenti());

		
	}
	
	
	public static void vuoleDisdire(Evento evento,LocalDate dataOra) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("vuoi Disdire?");
		String vuoiDisdire = scanner.nextLine();
		String generalResponse = vuoiDisdire.toLowerCase();

		if (utenteVuoleConfermare(vuoiDisdire)) {
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
	
	static void mostraMenu() {
		System.out.println("[1] vuoi effetuare prenotazioni");
		System.out.println("[2] disdici prenotazioni");
		System.out.println("[3] mostra eventi in agenda");
		System.out.println("[4] aggiungi prenotazioni");
		System.out.println("[5] rimuovi eventi");
	}

	static void preferenzeUtente(Evento evento,List<Evento> eventoP,LocalDate dateOra,ProgrammEventi eventiProgrammati) {
		mostraMenu();
		
		Scanner scanner = new Scanner(System.in);
		switch(scanner.nextLine()) {
		  case "1":
			  initSteps.VuoleLutenteEffettuarePrenotazione(evento,dateOra);
			 
		    break;
		  case "2":
			  initSteps.vuoleDisdire(evento,dateOra);
			  
			    // code block
			    break;
		  case "3":
			  System.out.print(eventiProgrammati.toString()) ;
			  
			    // code block
			    break;
		  case "4":
			  eventiProgrammati.addEvento(evento) ;
			  
			    // code block
			    break;
		  case "5":
			  eventiProgrammati.removeEvento();
		    // code block
		    break;
		  case "6":
			  
		    break;
		  default:
		   
		}
	}
	

}
