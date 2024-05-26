package org.java.generate;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		List<Evento> eventoPerData = new ArrayList<Evento>();

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

	private List<Evento> paragonaLeDate() {
		List<Evento> nuovoArray = new ArrayList<Evento>(eventi);
		/*
		 * Evento DataPiuPiccola = eventi.get(0); LocalDate dataTemp;
		 * 
		 * List<Evento> nuovoArray = new ArrayList<Evento>(eventi); for (int i = 0; i <
		 * eventi.size(); i++) { for(int y=i+1; y<eventi.size(); y++) { if
		 * (nuovoArray.get(i).getDataConcerto().isAfter(nuovoArray.get(y).
		 * getDataConcerto())) { DataPiuPiccola = nuovoArray.get(i); nuovoArray.set(i,
		 * nuovoArray.get(y)); nuovoArray.set(y, DataPiuPiccola); } else { continue; }
		 * 
		 * }
		 * 
		 * } return nuovoArray;
		 */

		Collections.sort(nuovoArray);
		return nuovoArray;
	}

	/*
	 * if (arr[i] < arr[j]) { int temp = arr[i]; arr[i] = arr[j]; arr[j] = temp;
	 */
	// Bubble sort;
	public Evento eventogiaEsistente(String nome) {
		Evento eventoSelezionato = null;
		for (int i = 0; i < eventi.size(); i++) {
			if (nome.equals(eventi.get(i).getTitolo())) {
				eventoSelezionato = eventi.get(i);
			}

		}
		return eventoSelezionato;
	}

	@Override
	public String toString() {
		List<Evento> torna = paragonaLeDate();
		String a = "";

		for (int i = 0; i < torna.size(); i++) {

			//a += "Data: " + torna.get(i).getDataConcerto() + " - evento: " + torna.get(i).getTitolo() + "\n";
			a+=torna.get(i).toString()+"\n";
		}

		return a;
	}

}
