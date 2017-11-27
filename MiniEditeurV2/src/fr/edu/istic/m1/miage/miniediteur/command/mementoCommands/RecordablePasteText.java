package fr.edu.istic.m1.miage.miniediteur.command.mementoCommands;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import fr.edu.istic.m1.miage.miniediteur.command.PasteText;
import fr.edu.istic.m1.miage.miniediteur.memento.Memento;
import fr.edu.istic.m1.miage.miniediteur.memento.Recorder;
import fr.edu.istic.m1.miage.miniediteur.memento.concretemementos.PasteTextMemento;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotorImpl;

/**
 * 
 * @author Diego Cardenas
 * @version 1.0
 * 
 * 
 *          Class that inherits Paste Text command and is charged with the
 *          execution of that concrete command and also of the set and get of
 *          the memento object
 *
 */
public class RecordablePasteText extends PasteText implements RecordCommand {
	private Recorder recorder;
	private PasteTextMemento pasteTextMemento;
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
		pasteTextMemento = new PasteTextMemento();
		return pasteTextMemento;
	}

	@Override
	public void setMemento(Memento memento) {
		// TODO Auto-generated method stub
		editorMotorImpl = EditorMotorImpl.getInstance();
		try {
			editorMotorImpl.setCaret(editorMotorImpl.getBufferLenght());
			editorMotorImpl.pasteText();
		} catch (UnsupportedFlavorException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
