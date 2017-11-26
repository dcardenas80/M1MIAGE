package fr.edu.istic.m1.miage.miniediteur.command;

import fr.edu.istic.m1.miage.miniediteur.memento.Recorder;

/**
 * 
 * @author Diego Cardenas
 * @version 1.0
 *
 *          this class is used as command charged to play a recording save in
 *          memory
 */
public class PlayRecording implements Command {
	private Recorder recorder;

	/**
	 * implementation of the execute method for the command PlayRecording
	 */
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		recorder = Recorder.getInstance();
		recorder.playRecording();
	}

}
