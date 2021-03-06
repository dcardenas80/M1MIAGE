package fr.edu.istic.m1.miage.miniediteur.command;

import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotor;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotorImpl;

/**
 * @author Diego Cardenas
 * @version 1.0
 * 
 *          Class charged with the logic implementation of the concrete command
 *          Cut Text into the editor's motor
 */
public class CutText implements Command {

	private EditorMotor editorMotorImpl;
	/**
	 * Execute method for the command CutText
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		editorMotorImpl = EditorMotorImpl.getInstance();
		editorMotorImpl.cutText();
	}

}
