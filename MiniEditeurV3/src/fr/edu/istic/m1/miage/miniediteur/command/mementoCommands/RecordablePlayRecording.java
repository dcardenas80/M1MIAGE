package fr.edu.istic.m1.miage.miniediteur.command.mementoCommands;

import fr.edu.istic.m1.miage.miniediteur.command.PlayRecording;
import fr.edu.istic.m1.miage.miniediteur.memento.Memento;
import fr.edu.istic.m1.miage.miniediteur.memento.Recorder;
import fr.edu.istic.m1.miage.miniediteur.memento.concretemementos.PlayRecordingMemento;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotor;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotorImpl;
/**
 * 
 * @author Diego Cardenas
 *
 */
public class RecordablePlayRecording extends PlayRecording implements RecordCommand {
	private Recorder recorder;
	private EditorMotor editorMotorImpl;
	private PlayRecordingMemento playRecordingMemento;
	private String  bufferBefore;

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		editorMotorImpl = EditorMotorImpl.getInstance();
		bufferBefore = editorMotorImpl.getBuffer();
		super.execute();
		recorder = Recorder.getInstance();
		recorder.recordCommands(this);
	}

	@Override
	public Memento getMemento() {
		// TODO Auto-generated method stub
		editorMotorImpl = EditorMotorImpl.getInstance();
		playRecordingMemento = new PlayRecordingMemento(bufferBefore,editorMotorImpl.getBuffer());
		return playRecordingMemento;
	}

	@Override
	public void setMemento(Memento memento) {
		editorMotorImpl = EditorMotorImpl.getInstance();
		String text = ((PlayRecordingMemento)memento).getStateAfter();
		editorMotorImpl.setBuffer(text);
	
	}

	@Override
	public void reverseCommand(Memento memento) {
		// TODO Auto-generated method stub
		editorMotorImpl = EditorMotorImpl.getInstance();
		String text = ((PlayRecordingMemento)memento).getState();
		editorMotorImpl.setBuffer(text);
	}

}
