package fr.edu.istic.m1.miage.miniediteur.memento.concretemementos;

import fr.edu.istic.m1.miage.miniediteur.memento.Memento;

/**
 * 
 * @author Diego Cardenas
 * @version 1.0 this class serves as memento for the RecordablePasteText class
 *
 */
public class PasteTextMemento implements Memento {
	private final String type = "PasteText";

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

}
