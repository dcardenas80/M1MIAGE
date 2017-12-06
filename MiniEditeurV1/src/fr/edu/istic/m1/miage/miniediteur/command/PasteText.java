package fr.edu.istic.m1.miage.miniediteur.command;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import fr.edu.istic.m1.miage.miniediteur.invoker.IHM;
import fr.edu.istic.m1.miage.miniediteur.invoker.IHMImpl;
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
	private IHM ihm;

	/**
	 * Execute method for the command PasteText
	 */
	@Override
	public void execute() {
		editorMotorImpl = EditorMotorImpl.getInstance();
		try {
			ihm = IHMImpl.getInstance();
		    editorMotorImpl.setCaret(ihm.getCaretPosition());
			editorMotorImpl = EditorMotorImpl.getInstance();
			editorMotorImpl.pasteText();
		} catch (UnsupportedFlavorException | IOException e) {
			// TODO Auto-generated catch block
			System.out.println("");
		}
	}

}
