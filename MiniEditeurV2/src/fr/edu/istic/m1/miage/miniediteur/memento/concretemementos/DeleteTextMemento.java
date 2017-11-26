package fr.edu.istic.m1.miage.miniediteur.memento.concretemementos;

import fr.edu.istic.m1.miage.miniediteur.memento.Memento;

/**
 * 
 * @author Diego Cardenas
 * @version 1.0
 * 
 *          this class serves as memento for the RecordableDeleteText class
 *
 */
public class DeleteTextMemento implements Memento {
	private final String type = "DeleteText";

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

}
