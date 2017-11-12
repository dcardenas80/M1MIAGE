package fr.edu.istic.m1.miage.miniediteur.command;

import fr.edu.istic.m1.miage.miniediteur.invoker.IHMImpl;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotorImpl;


/**
 * @author Diego Cardenas
 * @version 1.0
 * 
 *          Class charged with the logic implementation of the concrete command
 *          DeleteText
 */
public class DeleteText implements Command {
	private static IHMImpl ihmImpl;
	private EditorMotorImpl editorMotorImpl;
	/**
	 * Execute method for the command DeleteText
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		  ihmImpl = IHMImpl.getInstance();
		  editorMotorImpl = EditorMotorImpl.getInstance();
		  editorMotorImpl.setCaret(ihmImpl.getPnlText().getCaretPosition());
		  try {
			  editorMotorImpl.deleteText();
		  }catch (Exception e) {
			// TODO: handle exception
		}
		 
	}

}
