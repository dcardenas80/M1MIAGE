package fr.edu.istic.m1.miage.miniediteur.receiver;

/**
 * @(#) Buffer.java
 */

public class Buffer {

	private StringBuffer motorText;

	public Buffer() {
		motorText = new StringBuffer();
	}

	public StringBuffer getMotorText() {
		return motorText;
	}

	public void oter() {

	}

	public void append(char texte) {
		// TODO Auto-generated method stub
		motorText.append(texte);

	}

}
