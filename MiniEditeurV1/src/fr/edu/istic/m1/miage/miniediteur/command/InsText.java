package fr.edu.istic.m1.miage.miniediteur.command;

import fr.edu.istic.m1.miage.miniediteur.invoker.IHMImpl;
import fr.edu.istic.m1.miage.miniediteur.receiver.MoteurEditionImpl;

/**
 * @(#) InsText.java
 */

public class InsText implements Command {

	private static IHMImpl ihmImpl;
	private MoteurEditionImpl moteurEditionImpl;
	
    
	@Override
	public void execute() {
	   ihmImpl = IHMImpl.getInstance();
	   moteurEditionImpl = MoteurEditionImpl.getInstance();
	   moteurEditionImpl.insTexte(ihmImpl.getLastChart());

	}

}
