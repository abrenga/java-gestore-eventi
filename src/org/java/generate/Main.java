package org.java.generate;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] arvs) {
		Scanner scanner = new Scanner(System.in);
		LocalDate dateOra = LocalDate.now();
		Evento concertoSubsonica = new Concerto("Subsonica", 100000L, LocalDate.of(2027, 05, 28), 55.00f);
		Evento concertoMetallica= new Concerto("Metallica", 1000050L, LocalDate.of(2027, 07, 20), 60.00f);
		Evento concertoGigiDalessio= new Concerto("Gigi D'alessio", 10050L, LocalDate.of(2027, 02, 28), 60.00f);
		Evento concertoManeskin= new Concerto("Maneskin", 1000050L, LocalDate.of(2024, 07, 20), 60.00f);
		System.out.println("quante prenotazioni vuoi effettuare?");
		
		String preotazioniRicheste = scanner.nextLine();
		
		int prenotazioniRichiesteInNumero = Integer.parseInt(preotazioniRicheste);
		
		concertoSubsonica.prenota(dateOra, prenotazioniRichiesteInNumero);
		
		System.out.println("posti prenotati: " + concertoSubsonica.getNumeriPostiPrenotati() + " posti totali: "
				+ concertoSubsonica.getPostiTotali() + " postiRimanenti: " + concertoSubsonica.getPostiRimanenti());

		System.out.println("quante prenotazioni vuoi Disdire?");
		String preotazioniDaDisdire = scanner.nextLine();
		int uff = Integer.parseInt(preotazioniDaDisdire);

		concertoSubsonica.disdici(dateOra, uff);
		System.out.println("posti prenotati: " + concertoSubsonica.getNumeriPostiPrenotati() + " posti totali: "
				+ concertoSubsonica.getPostiTotali() + " postiRimanenti: " + concertoSubsonica.getPostiRimanenti());
		
		
		ProgrammEventi Sanremo = new ProgrammEventi("Sanremo");
		Sanremo.addEvento(concertoMetallica);
		Sanremo.addEvento(concertoSubsonica);
		Sanremo.addEvento(concertoGigiDalessio);
		Sanremo.addEvento(concertoManeskin);
		
		System.out.println(Sanremo);

	}

}
