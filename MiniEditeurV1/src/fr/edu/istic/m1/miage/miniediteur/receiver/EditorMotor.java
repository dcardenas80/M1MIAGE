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
	 * This method sets a selection based on a point of origin and a size that
	 * indicates it's end
	 * 
	 * @param selectionOrigin
	 *            - the origin of the selection to set
	 * @param selectionSize
	 *            - the size of the selection
	 */
	public void setSelection(int selectionOrigin, int selectionSize);

	/**
	 * This method paste a text into the Editor's motor buffer
	 * 
	 * @throws UnsupportedFlavorException
	 *             - Error thrown when trying to insert data different to String
	 * @throws IOException
	 *             - Error thrown when trying to get the clipboard of system
	 */
	public void pasteText() throws UnsupportedFlavorException, IOException;

	/**
	 * This method copies a text on the ClipBoard based on a previous selection
	 * 
	 * 
	 */
	public void copyText();

	/**
	 * This method cuts a text from the Editor's motor buffer
	 */
	public void cutText();

	/**
	 * This method insert text into the buffer
	 * 
	 * @param text
	 *            - the text to be inserted
	 */
	public void insertText(char text);

	/**
	 * This method is used to erase text from the buffer
	 */
	public void deleteText();

	/**
	 * This method returns the current selection's size
	 * 
	 * @return a integer with the size of a selection
	 */
	public int getSelectionSize();

	/**
	 * This method returns the origin of a selection
	 * 
	 * @return a integer with the origin of the selection
	 */
	public int getSelectionOrigin();

	/**
	 * This method updates the caret positions of the Editor's motor buffer
	 * 
	 * @param caretPostion - the integer with the caret position
	 */
	public void setCaret(int caretPostion);

	/**
	 * This method return the caretPosition to set
	 * 
	 * @return an integer with the position of the caret
	 */
	public int getCaret();

	/**
	 * This method notifies all the observers of the concrete classes.
	 */
	public abstract void notifyObservers();

	/**
	 * This method attach a new observer.
	 * 
	 * @param ihm
	 *            - Observer to attach
	 * 
	 */
	public abstract void attach(IHM ihm);

	/**
	 * Detach an observer.
	 * 
	 * @param ihm
	 *            - observer to remove if it's on the observers following the
	 *            subject
	 */
	public abstract void detach(IHM ihm);

	/***
	 * This method returns the String value of the buffer of the EditorMotorImpl
	 * Object
	 * 
	 * @return a StringBuffer with the content of the buffer
	 */
	public String getBuffer();
	/**
	 * This method verifies if the action to do is a selection
	 * 
	 * @return a boolean with true if is a selection false in the other case
	 */
	public boolean isSelection();
}
