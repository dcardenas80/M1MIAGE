package fr.edu.istic.m1.miage.miniediteur.receiver;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import fr.edu.istic.m1.miage.miniediteur.invoker.IHM;

/**
 * @author Diego Cardenas
 * @version 1.0
 * 
 */
public class EditorMotorImpl implements EditorMotor {

	/**
	 * Definition of Singleton Pattern to control the number of instances of the
	 * class MoteurEditionImpl
	 */
	private static EditorMotorImpl moteurEditionImplInstance;
	private Buffer textMoteur;
	private Collection<IHM> ihmObservers;
	private EditorMotorImpl() {
		this.textMoteur = new Buffer();
		this.ihmObservers = new ArrayList<IHM>();
		
	}

	/**
	 * Lazy singleton pattern
	 * 
	 * @return new instance of the EditorMotor if there is not an instance already
	 *         created
	 */
	public static EditorMotorImpl getInstance() {
		if (moteurEditionImplInstance == null) {

			moteurEditionImplInstance = new EditorMotorImpl();
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
		notifyObservers();
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		Iterator<IHM> iterator = ihmObservers.iterator();
		while (iterator.hasNext()) {
			IHM ihm = iterator.next();
			ihm.update();
			detach(ihm);
		}

	}

	@Override
	public void attach(IHM ihm) {
		// TODO Auto-generated method stub
		ihmObservers.add(ihm);

	}

	@Override
	public void detach(IHM ihm) {
		// TODO Auto-generated method stub
        ihmObservers.add(ihm);
	}
	
	public StringBuffer getBuffer() {
		
		return textMoteur.getMotorText();
				
	}

}
