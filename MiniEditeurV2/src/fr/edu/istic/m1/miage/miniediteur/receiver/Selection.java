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
	 * This method is used to verify if there is a selection
	 * 
	 * @return a boolean with true in the case of an existing selection false in the
	 *         other case
	 */
	public boolean isSelection() {
		return isSelection;
	}

	/**
	 * This method set a selection
	 * 
	 * @param isSelection
	 *            - true if there is a selection false in the other case
	 */
	public void setSelection(boolean isSelection) {
		this.isSelection = isSelection;
	}

	/**
	 * This method get the origin of the selection
	 * 
	 * @return a integer with the origin of the selection
	 */
	public int getSelectionOrigin() {
		return selectionOrigin;
	}

	/**
	 * This method sets the origin of a selection
	 * 
	 * @param selectionOrigin
	 *            - the origin of the selection
	 */
	public void setSelectionOrigin(int selectionOrigin) {
		this.selectionOrigin = selectionOrigin;
	}

	/**
	 * This method returns the size of the existing selection
	 * 
	 * @return a integer with the size of the selection
	 */
	public int getSelectionSize() {
		return selectionSize;
	}

	/**
	 * This method sets the size of a selection
	 * 
	 * @param selectionSize
	 *            - the size of the selection
	 */
	public void setSelectionSize(int selectionSize) {
		this.selectionSize = selectionSize;
	}

}
