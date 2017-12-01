package fr.edu.istic.m1.miage.miniediteur.command.mementoCommands;

import fr.edu.istic.m1.miage.miniediteur.command.DeleteText;
import fr.edu.istic.m1.miage.miniediteur.memento.Memento;
import fr.edu.istic.m1.miage.miniediteur.memento.Recorder;
import fr.edu.istic.m1.miage.miniediteur.memento.concretemementos.DeleteTextMemento;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotor;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotorImpl;

/**
 * 
 * @author Diego Cardenas
 * @version 1.0
 * 
 * 
 *          Class that inherits Delete Text command and is charged with the
 *          execution of that concrete command and also of the set and get of
 *          the memento object
 *
 */
public class RecordableDeleteText extends DeleteText implements RecordCommand {

	private Recorder recorder;
	private DeleteTextMemento deleteTextMemento;
	private EditorMotor editorMotorImpl;

	@Override
	public void execute() {
		// TODO Auto-generated method stub
		super.execute();
		recorder = Recorder.getInstance();
		recorder.recordCommands(this);
	}

	@Override
	public Memento getMemento() {
		// TODO Auto-generated method stub
		editorMotorImpl = EditorMotorImpl.getInstance();
		deleteTextMemento = new DeleteTextMemento(editorMotorImpl.getLastCharactersDeleted());
		return deleteTextMemento;
	}

	@Override
	public void setMemento(Memento memento) {
		// TODO Auto-generated method stub
		editorMotorImpl = EditorMotorImpl.getInstance();
		editorMotorImpl.deleteText();
		recorder = Recorder.getInstance();
	}

	@Override
	public void reverseCommand(Memento memento) {
		// TODO Auto-generated method stub
		editorMotorImpl = EditorMotorImpl.getInstance();
		String lastWordDeleted = ((DeleteTextMemento) memento).getWordDeleted();
		if (lastWordDeleted.length() == 1) {
			editorMotorImpl.insertText(lastWordDeleted.charAt(0));
		} else {
			editorMotorImpl.insertText(lastWordDeleted);
		}
	}

}
