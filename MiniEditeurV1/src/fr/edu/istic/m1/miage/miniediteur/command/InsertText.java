package fr.edu.istic.m1.miage.miniediteur.command;

import fr.edu.istic.m1.miage.miniediteur.invoker.IHMImpl;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotorImpl;

/**
 * @author Diego Cardenas
 * @version 1.0
 * 
 *          Class charged with the logic implementation of the concrete command
 *          InsertText
 */
public class InsertText implements Command {

	private IHMImpl ihmImpl;
	private EditorMotorImpl editorMotorImpl;
	
	/**
	 * Execute method for the command InsertText
	 */
	@Override
	public void execute() {
	   ihmImpl = IHMImpl.getInstance();
	   editorMotorImpl = EditorMotorImpl.getInstance();
	   editorMotorImpl.insertText(ihmImpl.getLastChart());

	}

}
