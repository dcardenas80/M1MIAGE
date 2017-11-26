package fr.edu.istic.m1.miage.miniediteur.command.mementoCommands;

import fr.edu.istic.m1.miage.miniediteur.command.CopyText;
import fr.edu.istic.m1.miage.miniediteur.memento.Memento;
import fr.edu.istic.m1.miage.miniediteur.memento.Recorder;
import fr.edu.istic.m1.miage.miniediteur.memento.concretemementos.CopyTextMemento;

public class RecordableCopyText extends CopyText implements RecordCommand {
	private Recorder recorder;
	private CopyTextMemento copyTextMemento;

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
		copyTextMemento = new CopyTextMemento();
		return copyTextMemento;
	}

	@Override
	public void setMemento(Memento memento) {
		// TODO Auto-generated method stub
		super.execute();
	}

}
