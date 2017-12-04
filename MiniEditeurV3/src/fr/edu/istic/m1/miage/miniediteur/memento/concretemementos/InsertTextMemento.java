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
	private int position;

	/**
	 * Class constructor needs the char which has been typed to be storeed
	 * 
	 * @param state
	 *            - the char to be inserted
	 * @param position - the position of the char
	 */
	public InsertTextMemento(char state, int position) {
		// TODO Auto-generated constructor stub
		this.state = state;
		this.position = position;
	}

	/**
	 * Returns the char stored in this memento
	 * 
	 * @return state - the char stored
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

	/**
	 * Returns the position of the text inserted
	 * 
	 * @return an integer with the position stored in this memento
	 */
	public int getPosition() {
		return position;
	}

}
