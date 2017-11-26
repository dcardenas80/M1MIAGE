package fr.edu.istic.m1.miage.miniediteur.command.mementoCommands;

import fr.edu.istic.m1.miage.miniediteur.command.Command;
import fr.edu.istic.m1.miage.miniediteur.memento.Memento;

/**
 * 
 * @author Diego Cardenas
 * @version 1.0
 * 
 *          this class is use by the concrete commands used when a macros is
 *          being recorded
 */
public interface RecordCommand extends Command {

	/**
	 * this method returns a Memento objet of the command being executed
	 * 
	 * @return Memento
	 */
	public Memento getMemento();

	public void setMemento(Memento memento);

}
