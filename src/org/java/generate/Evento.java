package org.java.generate;

import java.time.LocalDate;

public abstract class Evento {

	private String titolo;
	private long postiTotali;
	private long numeriPostiPrenotati;
	private LocalDate dataConcerto;
	private int richiestePosti;

	protected Evento(String titolo, Long postiTotali, LocalDate dataConcerto) {
		this.numeriPostiPrenotati = 0;
		this.postiTotali = postiTotali;
		this.dataConcerto = dataConcerto;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public long getPostiTotali() {
		return postiTotali;
	}

	public long getNumeriPostiPrenotati() {
		return numeriPostiPrenotati;
	}

	public long getPostiRimanenti() {
		return postiTotali - numeriPostiPrenotati;
	}
	
	public LocalDate getDataConcerto() {
		return dataConcerto;
	}

	public void setDataConcerto(LocalDate dataConcerto) {
		this.dataConcerto = dataConcerto;
	}

	// aggiunge uno ai posti prenotati.
	public void prenota(LocalDate dataOdierna, int richiestePosti) {
		if (isAfterDate(dataOdierna) && postiTotali > 0) {
			numeriPostiPrenotati += richiestePosti;

		} else {
			System.out.print("non ci sono posti disponibili");

		}

	}

	// disdici: riduce di uno i posti prenotati.
	public void disdici(LocalDate dataOdierna, int richiestePosti) {
		if (postiTotali <= 0 && !isAfterDate(dataOdierna)) {
			System.out.print("Non ci sono prenotazioni");
		} else {
			numeriPostiPrenotati -= richiestePosti;

		}

	}

	private Boolean isAfterDate(LocalDate dataOdierna) {
		if (this.dataConcerto.isAfter(dataOdierna)) {
			return true;
		} else {
			return false;
		}

	}

	// venga restituita una stringa contenente: data formattata - titolo
	@Override
	public String toString() {
		return "L'evento è in data: " + dataConcerto + " levento è: " + titolo;
	}

}
