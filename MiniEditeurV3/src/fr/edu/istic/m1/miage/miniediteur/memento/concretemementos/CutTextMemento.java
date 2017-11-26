package fr.edu.istic.m1.miage.miniediteur.memento.concretemementos;

import fr.edu.istic.m1.miage.miniediteur.memento.Memento;

/**
 * 
 * @author Diego Cardenas
 * @version 1.0
 * 
 *          This class serves as the memento of the RecordableCutText class
 *
 */
public class CutTextMemento implements Memento {
	private final String type = "CutText";

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

}
