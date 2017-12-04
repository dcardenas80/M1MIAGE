package fr.edu.istic.m1.miage.miniediteur.memento;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import fr.edu.istic.m1.miage.miniediteur.command.mementoCommands.RecordCommand;
import fr.edu.istic.m1.miage.miniediteur.command.mementoCommands.RecordableCopyText;
import fr.edu.istic.m1.miage.miniediteur.command.mementoCommands.RecordableCutText;
import fr.edu.istic.m1.miage.miniediteur.command.mementoCommands.RecordableDeleteText;
import fr.edu.istic.m1.miage.miniediteur.command.mementoCommands.RecordableInsertText;
import fr.edu.istic.m1.miage.miniediteur.command.mementoCommands.RecordablePasteText;
import fr.edu.istic.m1.miage.miniediteur.command.mementoCommands.RecordablePlayRecording;
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
	private Stack<Memento> undoStack;
	private Stack<Memento> redoStack;
	private Queue<Memento> commandsMementos;
	private static Recorder recorderInstance;
	private boolean recording = false;
	private int caretPaste;

	private Recorder() {

		commandsMementos = new LinkedList<Memento>();
		redoStack = new Stack<Memento>();
		undoStack = new Stack<Memento>();
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
	 * @param recordCommand - the command to record
	 */
	public void recordCommands(RecordCommand recordCommand) {
		if (recording) {
			commandsMementos.add(recordCommand.getMemento());
			register(recordCommand);
		} else {
			register(recordCommand);
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
					replayCommand(memento);
				} catch (NullPointerException e) {
					// TODO: handle exception
					break;
				}

			}
		}
	}

	/**
	 * this method calls the mementos saved previously to be played as a part of the
	 * recording, and also is used by the command redo to play a redo change
	 * 
	 * @param memento
	 * @throws NullPointerException
	 */
	private void replayCommand(Memento memento) throws NullPointerException {

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
		} else if (memento.getType().contentEquals("PlayRecording")) {
			command = new RecordablePlayRecording();
		}
		command.setMemento(memento);
	}

	public void undo() {
		if (!undoStack.isEmpty()) {
			Memento memento = undoStack.pop();
			redoStack.push(memento);
			playReverseCommand(memento);
		}
	}

	public void redo() {
		if (!redoStack.empty()) {
			Memento memento = redoStack.pop();
			undoStack.push(memento);
			replayCommand(memento);
		}
	}

	/**
	 * Register a recordableCommand to be undo
	 * 
	 * @param recordableCommand
	 *            - the command to undo
	 */
	public void register(RecordCommand recordableCommand) {
		redoStack.clear();
		Memento memento = recordableCommand.getMemento();
		registerMemento(memento);
	}

	/**
	 * This method registers the concrete memento of the recordable command
	 * 
	 * @param memento
	 *            - the memento to record
	 */
	public void registerMemento(Memento memento) {
		undoStack.push(memento);
	}

	/**
	 * Plays the reverse command of the memento
	 * 
	 * @param memento the memento to play the reverse command
	 */
	public void playReverseCommand(Memento memento) {
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
		} else if (memento.getType().contentEquals("PlayRecording")) {
			command = new RecordablePlayRecording();
		}
		command.reverseCommand(memento);
	}

	/**
	 * This method sets a caret to be use by RecordablePasteCommand when replayed
	 * 
	 * @return the value of the int caretPaste
	 */
	public int getCaretPaste() {
		return caretPaste;
	}

	/**
	 * This method sets the caretPaste to be used by the RecordablePasteCommand
	 * 
	 * @param caretPaste
	 *            - the value with the new caret
	 */
	public void setCaretPaste(int caretPaste) {
		this.caretPaste = caretPaste;
	}

}
