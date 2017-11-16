package fr.edu.istic.m1.miage.miniediteur.receiver;

/**
 * @author Diego Cardenas
 * @version 1.0
 * 
 *          this class represents a selection made on the editor
 */

public class Selection {

	private int selectionOrigin;
	private int selectionSize;
	private boolean isSelection;

	/**
	 * 
	 * Getters and Setters of the class
	 */
	public boolean isSelection() {
		return isSelection;
	}

	public void setSelection(boolean isSelection) {
		this.isSelection = isSelection;
	}

	public int getSelectionOrigin() {
		return selectionOrigin;
	}

	public void setSelectionOrigin(int selectionOrigin) {
		this.selectionOrigin = selectionOrigin;
	}

	public int getSelectionSize() {
		return selectionSize;
	}

	public void setSelectionSize(int selectionSize) {
		this.selectionSize = selectionSize;
	}

}
