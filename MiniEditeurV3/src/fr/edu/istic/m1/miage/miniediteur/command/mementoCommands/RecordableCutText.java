package fr.edu.istic.m1.miage.miniediteur.command.mementoCommands;

import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import fr.edu.istic.m1.miage.miniediteur.command.CutText;
import fr.edu.istic.m1.miage.miniediteur.invoker.IHM;
import fr.edu.istic.m1.miage.miniediteur.invoker.IHMImpl;
import fr.edu.istic.m1.miage.miniediteur.memento.Memento;
import fr.edu.istic.m1.miage.miniediteur.memento.Recorder;
import fr.edu.istic.m1.miage.miniediteur.memento.concretemementos.CutTextMemento;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotor;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotorImpl;

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
	private EditorMotor editorMotorImpl;
	private IHM ihmImpl;

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
		editorMotorImpl = EditorMotorImpl.getInstance();
		cutTextMemento = new CutTextMemento(ihmImpl.getSelectionOrigin(), ihmImpl.getSelectionSize(),editorMotorImpl.getContentClipboard());
		return cutTextMemento;
	}

	@Override
	public void setMemento(Memento memento) {
		// TODO Auto-generated method stub
		editorMotorImpl = EditorMotorImpl.getInstance();
		String content = ((CutTextMemento)memento).getContent();
		editorMotorImpl.setContentClipboard(content);
	}

	@Override
	public void reverseCommand(Memento memento) {
		// TODO Auto-generated method stub
		editorMotorImpl = EditorMotorImpl.getInstance();
		int[] selection = ((CutTextMemento) memento).getState();
		editorMotorImpl.setSelection(selection[0], selection[1]);
		try {
			editorMotorImpl.pasteText();
		} catch (UnsupportedFlavorException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
