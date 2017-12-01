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
	private int[] state = new int[2];
	private String content;
	public CutTextMemento(int selectionOrigin, int selectionSize, String content) {
		// TODO Auto-generated constructor stub
		this.state[0] = selectionOrigin;
		this.state[1] = selectionSize;
		this.setContent(content);
	}
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}
	
	public int[] getState() {
		return this.state;
	}
	public String getContent() {
		return content;
	}
	private void setContent(String content) {
		this.content = content;
	}
}
