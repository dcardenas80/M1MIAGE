package fr.edu.istic.m1.miage.miniediteur.command;

import fr.edu.istic.m1.miage.miniediteur.invoker.IHM;
import fr.edu.istic.m1.miage.miniediteur.invoker.IHMImpl;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotor;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotorImpl;


/**
 * @author Diego Cardenas
 * @version 2.0
 * 
 *          Class charged with the logic implementation of the concrete command
 *          Delete Text into the editor's motor
 */
public class DeleteText implements Command {
	
	private EditorMotor editorMotorImpl;
	private IHM ihmImpl;
	/**
	 * Execute method for the command DeleteText
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		 editorMotorImpl = EditorMotorImpl.getInstance(); 
		 ihmImpl = IHMImpl.getInstance();
		  try {
			  editorMotorImpl.setCaret(ihmImpl.getCaretPosition());
			  editorMotorImpl.deleteText();
		  }catch (Exception e) {
			e.printStackTrace();
		}
		 
	}

}
