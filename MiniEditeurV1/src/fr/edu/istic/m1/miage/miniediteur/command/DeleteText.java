package fr.edu.istic.m1.miage.miniediteur.command;

import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotorImpl;

/**
 * @author Diego Cardenas
 * @version 1.0
 * 
 *          Class charged with the logic implementation of the concrete command
 *          Delete Text into the editor's motor
 */
public class DeleteText implements Command {
	private EditorMotorImpl editorMotorImpl;

	/**
	 * Execute method for the command DeleteText
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub

		editorMotorImpl = EditorMotorImpl.getInstance();
		try {
			editorMotorImpl.deleteText();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
