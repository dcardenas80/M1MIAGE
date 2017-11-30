package fr.edu.istic.m1.miage.miniediteur.command;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotor;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotorImpl;

/**
 * @author Diego Cardenas
 * @version 1.0
 * 
 *          Class charged with the logic implementation of the concrete command
 *          PasteText into the editor's motor
 */
public class PasteText implements Command {
	private EditorMotor editorMotorImpl;

	/**
	 * Execute method for the command PasteText
	 */
	@Override
	public void execute() {
		try {
			editorMotorImpl = EditorMotorImpl.getInstance();
			editorMotorImpl.pasteText();
		} catch (UnsupportedFlavorException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
