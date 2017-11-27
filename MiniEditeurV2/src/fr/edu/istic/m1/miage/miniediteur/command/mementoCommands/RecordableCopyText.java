package fr.edu.istic.m1.miage.miniediteur.command.mementoCommands;

import fr.edu.istic.m1.miage.miniediteur.command.CopyText;
import fr.edu.istic.m1.miage.miniediteur.memento.Memento;
import fr.edu.istic.m1.miage.miniediteur.memento.Recorder;
import fr.edu.istic.m1.miage.miniediteur.memento.concretemementos.CopyTextMemento;

/**
 * 
 * @author Diego Cardenas
 * @version 1.0
 * 
 *          Class that inherits CopyText command and is charged with the
 *          execution of that concrete command and also of the set and get of
 *          the memento object
 *
 */
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
