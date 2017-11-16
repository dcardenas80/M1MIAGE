package fr.edu.istic.m1.miage.miniediteur.command;

import fr.edu.istic.m1.miage.miniediteur.invoker.IHMImpl;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotorImpl;

/**
 * @author Diego Cardenas
 * @version 1.0
 * 
 *          Class charged with the logic implementation of the concrete command
 *          CopyText
 */

public class CopyText implements Command {
	
	private IHMImpl ihmImpl;
	private EditorMotorImpl editorMotorImpl;
	@Override
	

	/**
	 * Execute method for the command CopyText
	 */
	public void execute() {
		// TODO Auto-generated method stub
		ihmImpl = IHMImpl.getInstance();
		editorMotorImpl = EditorMotorImpl.getInstance();
		editorMotorImpl.copyText();
	}
}
