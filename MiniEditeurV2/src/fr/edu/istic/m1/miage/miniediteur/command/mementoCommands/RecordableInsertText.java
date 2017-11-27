package fr.edu.istic.m1.miage.miniediteur.command.mementoCommands;

import fr.edu.istic.m1.miage.miniediteur.command.InsertText;
import fr.edu.istic.m1.miage.miniediteur.invoker.IHMImpl;
import fr.edu.istic.m1.miage.miniediteur.memento.Memento;
import fr.edu.istic.m1.miage.miniediteur.memento.Recorder;
import fr.edu.istic.m1.miage.miniediteur.memento.concretemementos.InsertTextMemento;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotorImpl;

/**
 * 
 * @author Diego Cardenas
 * @version 1.0
 * 
 * 
 *          Class that inherits Insert Text command and is charged with the
 *          execution of that concrete command and also of the set and get of
 *          the memento object
 *
 */
public class RecordableInsertText extends InsertText implements RecordCommand {
	private Recorder recorder;
	private InsertTextMemento insertTextMemento;
	private IHMImpl ihmImpl;
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
		ihmImpl = IHMImpl.getInstance();
		insertTextMemento = new InsertTextMemento(ihmImpl.getLastChart());
		return insertTextMemento;
	}

	@Override
	public void setMemento(Memento memento) {
		// TODO Auto-generated method stub
		 char inseredText = ((InsertTextMemento) memento).getState();
		 editorMotorImpl = EditorMotorImpl.getInstance();
		 editorMotorImpl.setCaret(editorMotorImpl.getBufferLenght());
		 editorMotorImpl.insertText(inseredText);
	}


}
