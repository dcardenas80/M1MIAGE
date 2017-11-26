package fr.edu.istic.m1.miage.miniediteur.command.mementoCommands;

import fr.edu.istic.m1.miage.miniediteur.command.DeleteText;
import fr.edu.istic.m1.miage.miniediteur.memento.Memento;
import fr.edu.istic.m1.miage.miniediteur.memento.Recorder;
import fr.edu.istic.m1.miage.miniediteur.memento.concretemementos.DeleteTextMemento;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotorImpl;

public class RecordableDeleteText extends DeleteText implements RecordCommand {

	private Recorder recorder;
	private DeleteTextMemento deleteTextMemento;
	private EditorMotorImpl editorMotorImpl;

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
		deleteTextMemento = new DeleteTextMemento();		
		return deleteTextMemento;
	}

	@Override
	public void setMemento(Memento memento) {
		// TODO Auto-generated method stub
		 editorMotorImpl = EditorMotorImpl.getInstance();
		 editorMotorImpl.deleteText();
	}


}
