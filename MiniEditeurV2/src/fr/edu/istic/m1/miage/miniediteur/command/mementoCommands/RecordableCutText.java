package fr.edu.istic.m1.miage.miniediteur.command.mementoCommands;

import fr.edu.istic.m1.miage.miniediteur.command.CutText;
import fr.edu.istic.m1.miage.miniediteur.memento.Memento;
import fr.edu.istic.m1.miage.miniediteur.memento.Recorder;
import fr.edu.istic.m1.miage.miniediteur.memento.concretemementos.CutTextMemento;

/**
 * 
 * @author Diego Cardenas
 * @version 1.0
 * 
 * 
 *          Class that inherits Cut Text command and is charged with the
 *          execution of that concrete command and also of the set and get of
 *          the memento object
 *
 */
public class RecordableCutText extends CutText implements RecordCommand {
	private Recorder recorder;
	private CutTextMemento cutTextMemento;

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
		cutTextMemento = new CutTextMemento();
		return cutTextMemento;
	}

	@Override
	public void setMemento(Memento memento) {
		// TODO Auto-generated method stub
		super.execute();
	}

}
