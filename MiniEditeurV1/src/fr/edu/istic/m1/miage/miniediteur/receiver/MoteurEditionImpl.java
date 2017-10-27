package fr.edu.istic.m1.miage.miniediteur.receiver;
/**
 * @author Diego Cardenas
 * @version 1.0
 * 
 */
public class MoteurEditionImpl implements MoteurEdition
{
	
	/**
	 * Definition of Singleton Pattern to control the number of instances
	 * of the class MoteurEditionImpl
	 */
	private static MoteurEditionImpl moteurEditionImplInstance;
	private Buffer textMoteur;
	private char texte;
	private MoteurEditionImpl() {
		this.textMoteur = new Buffer();
	}

	public static MoteurEditionImpl getInstance() {
		if (moteurEditionImplInstance == null) {
			
			moteurEditionImplInstance = new MoteurEditionImpl();
		}
		return moteurEditionImplInstance;
	}

	@Override
	public void selection() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void coller() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void copier() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insTexte(char texte) {
		
	
		textMoteur.append(texte);
	}
	
	
}
