package fr.edu.istic.m1.miage.miniediteur.receiver;

/**
 * @author Diego Cardenas
 * @version 2.0
 * 
 *          The class buffer is the class where is registered all the text
 *          introduced by the end-user into the program, the buffer class it's
 *          part of the editorMotor class.
 */

public class Buffer {

	private StringBuffer motorText;
	private int caretPosition = 0;

	/**
	 * Constructor of the class, charged of initialize a stringBuffer
	 */
	public Buffer() {
		motorText = new StringBuffer();
	}

	/**
	 * delete text from the buffer
	 * 
	 * @throws StringIndexOutOfBoundsException
	 *             - exception throw when trying to delete out of bounds of buffer
	 */
	public void deleteText() throws StringIndexOutOfBoundsException {
		if (getCaretPosition() - 1 > -1) {
			setCaretPosition(getCaretPosition() - 1);
			motorText.deleteCharAt(getCaretPosition());
		}

	}

	/**
	 * This method cuts text from the buffer
	 * 
	 * @param selectionOrigin
	 *            - initial point of the selection to be cut
	 * @param selectionSize
	 *            - size of the selection
	 * @return a string with the text cut
	 */
	public String cutText(int selectionOrigin, int selectionSize) throws StringIndexOutOfBoundsException {
		String text = motorText.substring(selectionOrigin, selectionOrigin + selectionSize);
		motorText.delete(selectionOrigin, selectionOrigin + selectionSize);
		setCaretPosition(selectionOrigin);
		return text;

	}

	/**
	 * This method appends single characters into the buffer
	 * 
	 * @param texte
	 *            -a char to be inserted into the buffer
	 */
	public void append(char texte) {
		// TODO Auto-generated method stub
		if (texte == '\n') {
			motorText.insert(getCaretPosition(), '\n');
		} else {
			motorText.insert(getCaretPosition(), texte);
		}
		int lenght = getCaretPosition() + 1;
		setCaretPosition(lenght);

	}

	/**
	 * This method copies text from the buffer based in a selection
	 * 
	 * @param selectionOrigin
	 *            - the origin of a selection
	 * @param selectionSize
	 *            - the size of the selection
	 * @return a String with the value requested by the selection
	 */
	public String copyText(int selectionOrigin, int selectionSize) throws StringIndexOutOfBoundsException {
		String text = motorText.substring(selectionOrigin, selectionOrigin + selectionSize);
		setCaretPosition(selectionOrigin + selectionSize);
		return text;

	}

	/**
	 * This method is a over charge of the append method this method insert a String
	 * on the buffer
	 * 
	 * @param texte
	 *            - a String to be inserted
	 */
	public void append(String texte) {
		// TODO Auto-generated method stub

		motorText.insert(getCaretPosition(), texte);

		int lenght = getCaretPosition();
		setCaretPosition(lenght + texte.length());

	}

	/**
	 * This method gets the caret position on buffer's side
	 * 
	 * @return an integer with the position of the caret
	 */
	public int getCaretPosition() {
		return caretPosition;
	}

	/**
	 * This method sets the caret position on buffer's side
	 * 
	 * @param setCaretPosition-
	 *            the position of the caret
	 */
	public void setCaretPosition(int setCaretPosition) {
		this.caretPosition = setCaretPosition;
	}

	/**
	 * This method returns the text inside the buffer
	 * 
	 * @return a String with the buffer content
	 */
	public String getMotorText() {
		return motorText.toString();
	}

	/**
	 * This method returns the length of the buffer
	 * 
	 * @return an integer with the value of the length
	 */
	public int getLength() {
		return motorText.length();
	}

	/**
	 * Delete the requested text by its origin and its size
	 * 
	 * @param selectionOrigin
	 *            - the origin of the text to delete
	 * @param selectionSize
	 *            - the size of the text to delete
	 */
	public void deleteTextByRange(int selectionOrigin, int selectionSize) {
		motorText.delete(selectionOrigin, selectionOrigin + selectionSize);
		setCaretPosition(selectionOrigin);
	}

}
