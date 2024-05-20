package org.AntoArray;

import java.util.Arrays;

public class MioArrayDinamico {
	private int[] arrayAnto;
	private int ultimoIndice;

	public MioArrayDinamico(int[] nuovoArray) {
		this.arrayAnto = nuovoArray;
		this.ultimoIndice = -1;
	}

	public MioArrayDinamico() {
		this.arrayAnto = new int[0];
		this.ultimoIndice = -1;

	}

	public MioArrayDinamico(int size) {
		this.arrayAnto = new int[size];
		this.ultimoIndice = -1;
	}

	public int getElementoSuccessivo() {
		if (hasAncoraElementi()) {
			this.ultimoIndice++;
			return this.arrayAnto[this.ultimoIndice];
		} else {
			return 404;// ????
		}

	}

	private boolean hasAncoraElementi() {
		if (this.ultimoIndice < arrayAnto.length) {
			return true;
		}
		return false;
	}

	public void addElemento(int nuovoElemento) {
		int nuovaDimensionenArray = arrayAnto.length + 1;
		arrayAnto = Arrays.copyOf(arrayAnto, nuovaDimensionenArray);
		arrayAnto[arrayAnto.length - 1] = nuovoElemento;

	}

	@Override
	public  String toString() {
		String ciao="";
		for (int i = 0; i < arrayAnto.length; i++) {
			 ciao += " " + arrayAnto[i];
			
		}
		
		return ciao;
	}
}
