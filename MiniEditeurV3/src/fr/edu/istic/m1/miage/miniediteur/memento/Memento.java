package fr.edu.istic.m1.miage.miniediteur.memento;

/**
 * 
 * @author Diego Cardenas
 * @version 1.0
 * 
 *          Memento interface to be used by concrete mementos
 *
 */
public interface Memento {
	/**
	 * this mehtod is in charged of return the id of the concrete memento that has been saved
	 * @return String type
	 */
	String getType();

}
