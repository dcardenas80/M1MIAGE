package fr.edu.istic.m1.miage.miniediteur.command.mementoCommands;

import fr.edu.istic.m1.miage.miniediteur.command.Command;
import fr.edu.istic.m1.miage.miniediteur.memento.Memento;

/**
 * 
 * @author Diego Cardenas
 * @version 1.0
 * 
 *          This class is use by the concrete commands used when a macros is
 *          being recorded
 */
public interface RecordCommand extends Command {

	/**
	 * This method returns a Memento object of the command being executed
	 * 
	 * @return Memento
	 */
	public Memento getMemento();

	/**
	 * Executes the command with the values store in the memento
	 * 
	 * @param memento
	 *            - the memento object to be restored
	 */
	public void setMemento(Memento memento);

	/**
	 * 
	 * /** This method do the opposite of the command and is intended to be used
	 * when the users wants to undo the changes
	 *
	 * @param memento
	 *            - the memento object where the status of the command has been
	 *            saved
	 */
	public void reverseCommand(Memento memento);

}
