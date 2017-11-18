package fr.edu.istic.m1.miage.miniediteur.receiver;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import fr.edu.istic.m1.miage.miniediteur.invoker.IHM;

/**
 * @author Diego Cardenas
 * @version 1.0
 */

public interface EditorMotor {

	/**
	 * Sets a selection based on a point of origin and a size that indicates it's
	 * end
	 * 
	 * @param selectionOrigin
	 * @param selectionSize
	 */
	public void setSelection(int selectionOrigin, int selectionSize);

	/**
	 * Paste a text into the Editor's motor buffer
	 * 
	 * @throws IOException
	 * @throws UnsupportedFlavorException
	 */
	public void pasteText() throws UnsupportedFlavorException, IOException;

	/**
	 * copies a text on the clipboard based on a previous selection
	 * 
	 * 
	 */
	public void copyText();

	/**
	 * Cuts a text from the Editor's motor buffer
	 */
	public void cutText();

	/**
	 * Insert text into the buffer
	 * 
	 * @param text
	 */
	public void insertText(char text);

	/**
	 * Command used to erase text from the buffer
	 */
	public void deleteText();

	/**
	 * Returns the current selection's size
	 * 
	 * @return
	 */
	public int getSelectionSize();

	/**
	 * Returns the origin of a selection
	 * 
	 * @return
	 */
	public int getSelectionOrigin();

	/**
	 * updates the caret positions of the Editor's motor buffer
	 * 
	 * @param caretPostion
	 */
	public void setCaret(int caretPostion);

	/**
	 * return the caretPosition to set
	 * 
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
