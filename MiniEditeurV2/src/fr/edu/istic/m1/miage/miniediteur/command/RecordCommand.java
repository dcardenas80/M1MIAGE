package fr.edu.istic.m1.miage.miniediteur.command;

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

	public Memento getMemento();

	public void setMemento(Memento m);

}
