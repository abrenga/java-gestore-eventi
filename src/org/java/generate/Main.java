package org.java.generate;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] arvs) {
		Scanner scanner = new Scanner(System.in);
		LocalDate date = LocalDate.of(2027, 05, 20);
		LocalDate dateOra = LocalDate.now();
		Concerto concertoSubsonica = new Concerto("Subsonica", 100000L, date, 55.00f);

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

	}

}
