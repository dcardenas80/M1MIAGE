package fr.edu.istic.m1.miage.miniediteur.memento.concretemementos;

import fr.edu.istic.m1.miage.miniediteur.memento.Memento;

/**
 * 
 * @author Diego Cardenas
 * @version 1.0
 * 
 *          This class serves as the memento of the RecordableCopyText class
 *
 */
public class CopyTextMemento implements Memento {
	public final String type = "CopyText";

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

}
