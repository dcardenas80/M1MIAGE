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
	private int[] state = new int[2];
	private String content = "";
	private int caretAfterPaste;
	public PasteTextMemento(int selectionOrigin, int selectionSize, String content, int caretAfterPaste) {
		// TODO Auto-generated constructor stub
		
		this.state[0] = selectionOrigin;
		this.state[1] = selectionSize;
		this.content = content;
		this.setCaretAfterPaste(caretAfterPaste);
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
		return this.content;
	}

	public int getCaretAfterPaste() {
		return caretAfterPaste;
	}

	private void setCaretAfterPaste(int caretAfterPaste) {
		this.caretAfterPaste = caretAfterPaste;
	}
}
