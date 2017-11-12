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
	
    
	@Override
	public void execute() {
	   ihmImpl = IHMImpl.getInstance();
	   editorMotorImpl = EditorMotorImpl.getInstance();
	   editorMotorImpl.setCaret(ihmImpl.getPnlText().getCaretPosition());
	   editorMotorImpl.insertText(ihmImpl.getLastChart());

	}

}
