package fr.edu.istic.m1.miage.miniediteur.command;

import fr.edu.istic.m1.miage.miniediteur.invoker.IHMImpl;
import fr.edu.istic.m1.miage.miniediteur.receiver.EditorMotorImpl;

/**
 * @(#) InsText.java
 */

public class TextInsertion implements Command {

	private static IHMImpl ihmImpl;
	private EditorMotorImpl moteurEditionImpl;
	
    
	@Override
	public void execute() {
	   ihmImpl = IHMImpl.getInstance();
	   moteurEditionImpl = EditorMotorImpl.getInstance();
	   moteurEditionImpl.insTexte(ihmImpl.getLastChart());

	}

}
