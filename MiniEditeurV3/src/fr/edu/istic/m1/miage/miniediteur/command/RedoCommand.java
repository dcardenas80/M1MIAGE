package fr.edu.istic.m1.miage.miniediteur.command;

import fr.edu.istic.m1.miage.miniediteur.memento.Recorder;

/**
 * 
 * @author Diego Cardenas
 * @version 1.0
 * 
 *          Class charged with the execution of the command Redo, this command
 *          set again the latest change that the user has reverse on the
 *          Editor's motor
 */
public class RedoCommand implements Command {
	private Recorder recorder;
	/**
	 * implementation of the execute method for the command Redo
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		recorder = Recorder.getInstance();
		recorder.redo();
	}

}
