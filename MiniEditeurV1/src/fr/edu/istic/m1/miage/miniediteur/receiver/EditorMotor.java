package fr.edu.istic.m1.miage.miniediteur.receiver;

import fr.edu.istic.m1.miage.miniediteur.invoker.IHM;

/**
 * @author Diego Cardenas
 * @version 1.0
 */

public interface EditorMotor {
	public void setSelection(int selectionOrigin, int selectionSize);

	public void pasteText();
	public void copyText(int selectionOrigin,  int selectionSize);
	public void cutText(int selectionOrigin, int selectionSize);
	public void insertText(char text);

	public void deleteText();
	public int getSelectionSize();
	public int getSelectionOrigin();
	public void setCaret(int caretPostion);
    /**
     * return the caretPosition to set 
     * @return caretPosition
     */
	public int getCaret();

	/**
	 * Notify all the observer.
	 */
	public abstract void notifyObservers();

	/**
	 * Attach a new observer.
	 * 
	 * @param ihm
	 *            Observer to attach
	 * 
	 */
	public abstract void attach(IHM ihm);

	/**
	 * Detach an observer.
	 * 
	 * @param IHM
	 *            observer to remove if it's on the observers following the subject
	 */
	public abstract void detach(IHM ihm);

}
