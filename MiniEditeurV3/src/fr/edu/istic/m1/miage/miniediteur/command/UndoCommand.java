package fr.edu.istic.m1.miage.miniediteur.command;

import fr.edu.istic.m1.miage.miniediteur.memento.Recorder;

/**
 * 
 * @author Diego Cardenas
 * @version 1.0
 * 
 *          Class charged with the execution of the command Undo, this command
 *          reverses the latest change on the Editor's motor
 */
public class UndoCommand implements Command {
	
	private Recorder recorder;
	/**
	 * implementation of the execute method for the command Undo
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		recorder = Recorder.getInstance();
		recorder.undo();
	}

}
