package fr.edu.istic.m1.miage.miniediteur.command;

import fr.edu.istic.m1.miage.miniediteur.memento.Recorder;

/**
 * 
 * @author Diego Cardenas
 * @version 1.0
 * 
 *          this class serves as a command to star the recording of series of
 *          commands
 *
 */
public class StartRecording implements Command {

	private Recorder recorder;

	/**
	 * implementation of the execute method for the command StartRecording
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		recorder = Recorder.getInstance();
		recorder.startRecording();
	}

}
