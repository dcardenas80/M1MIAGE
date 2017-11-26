package fr.edu.istic.m1.miage.miniediteur.memento.concretemementos;

import fr.edu.istic.m1.miage.miniediteur.memento.Memento;

/**
 * 
 * @author Diego Cardenas
 * @version 1.0
 * 
 *          this class serves as memento for the RecordableSelectText class
 *
 */
public class SelectTextMemento implements Memento {
	private final String type = "SelectText";
	private int[] state = new int[2];

	/**
	 * Constructor of the class receives the points of the selection.
	 * 
	 * @param stateOne
	 * @param stateTwo
	 */
	public SelectTextMemento(int stateOne, int stateTwo) {
		// TODO Auto-generated constructor stub
		this.state[0] = stateOne;
		this.state[1] = stateTwo;
	}
    
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}
	/**
	 * this method returns an array with the selection points stored.
	 * @return state
	 */
	public int[] getState() {
		return state;
	}

}
