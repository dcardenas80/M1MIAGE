package fr.edu.istic.m1.miage.miniediteur.receiver;

/**
 * @Diego Cardenas
 * @version 2.0
 * 
 *          The class buffer is the class where is registered all the text
 *          introduced by the end-user into the program, the buffer class it's
 *          part of the editorMotor class.
 */

public class Buffer {

	private StringBuffer motorText;
	private int caretPosition = 0;

	public int getCaretPosition() {
		return caretPosition;
	}

	public void setCaretPosition(int setCaretPosition) {
		this.caretPosition = setCaretPosition;
	}

	public void setMotorText(StringBuffer motorText) {
		this.motorText = motorText;
	}

	public Buffer() {
		motorText = new StringBuffer();
	}

	public StringBuffer getMotorText() {
		return motorText;
	}

	public void deleteText() throws StringIndexOutOfBoundsException {
		motorText.deleteCharAt(caretPosition);
		int lenght = getCaretPosition();
		setCaretPosition(lenght);
	}

	public String cutText(int selectionOrigin, int selectionSize) {
		String text = motorText.substring(selectionOrigin, selectionOrigin + selectionSize);
		motorText.delete(selectionOrigin, selectionOrigin + selectionSize);
		setCaretPosition(selectionOrigin);
		return text;

	}

	public void append(char texte) {
		// TODO Auto-generated method stub
		if (texte == '\n') {
			motorText.insert(getCaretPosition() - 1, System.getProperty("line.separator"));

		} else {
			motorText.insert(getCaretPosition(), texte);

		}
		int lenght = getCaretPosition();
		setCaretPosition(lenght + 1);

	}

	public String copyText(int selectionOrigin, int selectionSize) {
		String text = motorText.substring(selectionOrigin, selectionOrigin + selectionSize);
		setCaretPosition(selectionOrigin + selectionSize);
		return text;

	}

	public void append(String texte) {
		// TODO Auto-generated method stub

		motorText.insert(getCaretPosition(), texte);

		int lenght = getCaretPosition();
		setCaretPosition(lenght + texte.length());

	}

}
