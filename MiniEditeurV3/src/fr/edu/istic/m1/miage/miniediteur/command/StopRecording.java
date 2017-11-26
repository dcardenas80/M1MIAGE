package fr.edu.istic.m1.miage.miniediteur.command;

import fr.edu.istic.m1.miage.miniediteur.memento.Recorder;

/**
 * 
 * @author Diego Cardenas
 * @version 1.0
 * 
 *          this class is the command to be executed when the users wants to
 *          step a recording
 *
 */
public class StopRecording implements Command {
	private Recorder recorder;
	
	/**
	 * implementation of the execute method for the command StopRecording
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		recorder = Recorder.getInstance();
		recorder.stopRecording();
	}

}
