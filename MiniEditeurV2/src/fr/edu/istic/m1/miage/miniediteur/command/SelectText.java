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
 *          Paste Text into the editor's motor
 */
public class SelectText implements Command {

	private IHM ihmImpl;
	private EditorMotor editorMotorImpl;

	/**
	 * Execute method for the command SelectText
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		ihmImpl = IHMImpl.getInstance();
		editorMotorImpl = EditorMotorImpl.getInstance();
		editorMotorImpl.setSelection(ihmImpl.getSelectionOrigin(), ihmImpl.getSelectionSize());

	}

}
