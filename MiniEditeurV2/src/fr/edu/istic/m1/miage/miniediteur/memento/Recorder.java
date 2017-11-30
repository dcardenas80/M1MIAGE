package fr.edu.istic.m1.miage.miniediteur.memento;

import java.util.LinkedList;
import java.util.Queue;

import fr.edu.istic.m1.miage.miniediteur.command.mementoCommands.RecordCommand;
import fr.edu.istic.m1.miage.miniediteur.command.mementoCommands.RecordableCopyText;
import fr.edu.istic.m1.miage.miniediteur.command.mementoCommands.RecordableCutText;
import fr.edu.istic.m1.miage.miniediteur.command.mementoCommands.RecordableDeleteText;
import fr.edu.istic.m1.miage.miniediteur.command.mementoCommands.RecordableInsertText;
import fr.edu.istic.m1.miage.miniediteur.command.mementoCommands.RecordablePasteText;
import fr.edu.istic.m1.miage.miniediteur.command.mementoCommands.RecordableSelectText;

/**
 * 
 * @author Diego Cardenas
 * @version 1.0
 * 
 *          this class is charged of the recording of all the commands for the
 *          macro functionality
 */
public class Recorder {
	private Queue<Memento> commandsMementos;
	private static Recorder recorderInstance;
	private boolean recording = false;
	private int caretPaste;
	private Recorder() {

		commandsMementos = new LinkedList<Memento>();
	}

	/**
	 * Lazy singleton pattern
	 * 
	 * @return new instance of the Recorder if there is not an instance already
	 *         created
	 */
	public static Recorder getInstance() {
		if (recorderInstance == null) {

			recorderInstance = new Recorder();
		}
		return recorderInstance;
	}

	public boolean isRecording() {
		return recording;
	}

	private void setRecording(boolean recording) {
		this.recording = recording;
	}

	/**
	 * 
	 * this method will record every command that it's part of a macro
	 *
	 * @param recordCommand
	 */
	public void recordCommands(RecordCommand recordCommand) {
		if (recording) {
			commandsMementos.add(recordCommand.getMemento());
		}
	}

	/**
	 * this method will start the recording of a set of commands
	 */
	public void startRecording() {
		if (!commandsMementos.isEmpty()) {
			commandsMementos.clear();
		}
		setRecording(true);
	}

	/**
	 * this method stops the recording
	 */
	public void stopRecording() {

		recording = false;
	}

	/**
	 * this method start to play the recording
	 */
	public void playRecording() {
		if (!recording) {
			for (Memento memento : commandsMementos) {
				try {
					playRecordingStep(memento);
				} catch (NullPointerException e) {
					// TODO: handle exception
					break;
				}

			}
		}
	}

	/**
	 * this method calls the mementos saved previously to be played as a part of the
	 * recording
	 * 
	 * @param memento
	 * @throws NullPointerException
	 */
	private void playRecordingStep(Memento memento) throws NullPointerException {

		RecordCommand command = null;
		if (memento.getType().contentEquals("InsertText")) {
			command = new RecordableInsertText();
		} else if (memento.getType().contentEquals("DeleteText")) {
			command = new RecordableDeleteText();
		} else if (memento.getType().contentEquals("SelectText")) {
			command = new RecordableSelectText();
		} else if (memento.getType().contentEquals("CopyText")) {
			command = new RecordableCopyText();
		} else if (memento.getType().contentEquals("PasteText")) {
			command = new RecordablePasteText();
		} else if (memento.getType().contentEquals("CutText")) {
			command = new RecordableCutText();
		}
		command.setMemento(memento);
	}

	public int getCaretPaste() {
		return caretPaste;
	}

	public void setCaretPaste(int caretPaste) {
		this.caretPaste = caretPaste;
	}
}
