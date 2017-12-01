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
	 * @throws IOException
	 * @throws UnsupportedFlavorException
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
	 * This method inserts text into the buffer
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
	 * @param caretPostion
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
	 * @param IHM
	 *            - observer to remove if it's on the observers following the
	 *            subject
	 */
	public abstract void detach(IHM ihm);

	/**
	 * This method verifies if the action to do is a selection
	 * 
	 * @return a boolean with true if is a selection false in the other case
	 */
	public boolean isSelection();

	/**
	 * This method returns a String with the text of the Editor's buffer
	 * 
	 * @return a String with the text on the Editor's buffer
	 */
	public String getBuffer();

	/**
	 * This method returns the length of the buffer
	 * 
	 * @return an integer with the buffer's length value
	 */
	public int getBufferLength();

	/**
	 * This method sets the caret from the user on Editor's buffer
	 * 
	 * @param CaretPosition
	 *            the value of the new position
	 */
	public void setCaretByCommand(int caretPosition);
    /**
     * This method gets a boolean that let know the editor when notify an observer
     * @return the value of the boolean
     */
	public boolean isSelectionMacro();
	/**
	 * This method sets a boolean that let know the editor when notify an observer
	 * @param selectionMacro
	 */
	public void setSelectionMacro(boolean selectionMacro);

	/**
	 * This method gets the content of the clipboard
	 * 
	 * @return an String with the content
	 */
	public String getContentClipboard();
	/**
	 * This method sets the content of the clipboard
	 * @param content
	 */
	public void setContentClipboard(String content);
}
