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
 *          Copy Text into the editor's motor
 */

public class CopyText implements Command {

	private EditorMotor editorMotorImpl;
	private IHM ihmImpl;

	/**
	 * Execute method for the command CopyText
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		editorMotorImpl = EditorMotorImpl.getInstance();
		ihmImpl = IHMImpl.getInstance();
		try {
			editorMotorImpl.copyText();
		} catch (StringIndexOutOfBoundsException e) {
			// TODO: handle exception
			ihmImpl.setWarningMessage("Erreur dans l'action de copier, revisez-vous s'il y'a une seléction");
		}

	}
}
