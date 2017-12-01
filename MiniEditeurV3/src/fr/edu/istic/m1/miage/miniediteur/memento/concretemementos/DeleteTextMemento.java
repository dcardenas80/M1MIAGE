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
	private String wordDeleted;

	/**
	 * Constructor of the DeleteTextMemento concrete memento for the command
	 * RecordableDeleteText
	 * 
	 * @param wordDeleted
	 *            the word deleted in the concrete command
	 */
	public DeleteTextMemento(String wordDeleted) {
		// TODO Auto-generated constructor stub
		this.wordDeleted = wordDeleted;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}
	/**
	 * Returns the word that was deleted
	 * @return a String with a character o characters 
	 */
	public String getWordDeleted() {
		return this.wordDeleted;
	}

}
