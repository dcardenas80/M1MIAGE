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
	private final String type = "CopyText";
	private String state;
	private String stateBefore;
	public CopyTextMemento(String state, String stateBefore) {
		// TODO Auto-generated constructor stub
		this.state = state;
		this.stateBefore = stateBefore;
	}
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}
	public String getState() {
		return this.state;
	}
	
	public String getStateBefore(){
		return this.stateBefore;
	}

}
