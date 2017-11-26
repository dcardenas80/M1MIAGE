package fr.edu.istic.m1.miage.miniediteur.memento.concretemementos;

import fr.edu.istic.m1.miage.miniediteur.memento.Memento;

/**
 * This class serves as memento for RecordableInsertText class
 * 
 * @author Diego Cardenas
 * @version 1.0
 *
 */
public class InsertTextMemento implements Memento {
	private final String type = "InsertText";
	private char state;

	/**
	 * Class constructor needs the char which has been typed to be storeed
	 * 
	 * @param state
	 */
	public InsertTextMemento(char state) {
		// TODO Auto-generated constructor stub
		this.state = state;
	}

	/**
	 * returns the char stored in this memento
	 * 
	 * @return state
	 */
	public char getState() {
		// TODO Auto-generated method stub
		return state;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

}
