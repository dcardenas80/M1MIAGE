package fr.edu.istic.m1.miage.miniediteur.command;

import fr.edu.istic.m1.miage.miniediteur.invoker.IHM;
import fr.edu.istic.m1.miage.miniediteur.invoker.IHMImpl;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotor;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotorImpl;

/**
 * @author Diego Cardenas
 * @version 1.0
 * 
 *          Class charged with the logic implementation of the concrete command
 *          Insert Text into the editor's motor
 */
public class InsertText implements Command {

	private IHM ihmImpl;
	private EditorMotor editorMotorImpl;
	/**
	 * Execute method for the command InsertText
	 */
	@Override
	public void execute() {
	   ihmImpl = IHMImpl.getInstance();
	   editorMotorImpl = EditorMotorImpl.getInstance();
	   editorMotorImpl.setCaret(ihmImpl.getCaretPosition());
	   editorMotorImpl.insertText(ihmImpl.getLastChart());

	}

}
