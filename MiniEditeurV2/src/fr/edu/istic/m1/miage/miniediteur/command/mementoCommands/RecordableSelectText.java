package fr.edu.istic.m1.miage.miniediteur.command.mementoCommands;

import fr.edu.istic.m1.miage.miniediteur.command.SelectText;
import fr.edu.istic.m1.miage.miniediteur.invoker.IHMImpl;
import fr.edu.istic.m1.miage.miniediteur.memento.Memento;
import fr.edu.istic.m1.miage.miniediteur.memento.Recorder;
import fr.edu.istic.m1.miage.miniediteur.memento.concretemementos.SelectTextMemento;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotorImpl;


/**
 * 
 * @author Diego Cardenas
 * @version 1.0
 * 
 * 
 *          Class that inherits Select Text command and is charged with the
 *          execution of that concrete command and also of the set and get of
 *          the memento object
 *
 */
public class RecordableSelectText extends SelectText implements RecordCommand {

	private Recorder recorder;
	private SelectTextMemento selectTextMemento;
	private EditorMotorImpl editorMotorImpl;
	private IHMImpl ihmImpl;
    private int[] selection;
    
    public RecordableSelectText() {
		// TODO Auto-generated constructor stub
    	selection = new int[2];
	}
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		super.execute();
		ihmImpl = IHMImpl.getInstance();
		recorder = Recorder.getInstance();
		recorder.recordCommands(this);
	}

	@Override
	public Memento getMemento() {
		// TODO Auto-generated method stub
		selection[0]= ihmImpl.getSelectionOrigin();
		selection[1]= ihmImpl.getSelectionSize();
		selectTextMemento = new SelectTextMemento(selection[0],selection[1]);
		return selectTextMemento;
	}

	@Override
	public void setMemento(Memento memento) {
		// TODO Auto-generated method stub
        int[] selection = ((SelectTextMemento)memento).getState();
        editorMotorImpl = EditorMotorImpl.getInstance();
        
        editorMotorImpl.setSelection(selection[0], selection[1]);
	}

}
