package fr.edu.istic.m1.miage.miniediteur;

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
	   moteurEditionImpl.insTexte(ihmImpl.getTextToInsert());

	}

}
