package org.java.generate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.DecimalFormat;

public class Concerto extends Evento {
	//private LocalDate ora;// ricordati di passare l'ora corrente
	private float prezzo;

	public Concerto(String titolo, Long postiTotali, LocalDate dataConcerto, float prezzo) {
		super(titolo, postiTotali, dataConcerto);
		this.prezzo = prezzo;

	}


	public float getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	private String formattaPrezzo() {
		DecimalFormat prezzoFormattato = new DecimalFormat("##.## $");
		return prezzoFormattato.format(this.prezzo);

	}

	@Override
	public String toString() {
		return super.toString() + " il prezzo del biglietto è: " + formattaPrezzo();// ricordati di implemntare data e ora formattata - titolo -
															// prezzo formattato

	}
}
