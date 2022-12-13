package fr.utt.LO02.VL.CestDuBrutal;

import java.util.ArrayList;

/**
 * Interface Strategie
 * 
 * @author Vincent
 * @author Louis
 */
public interface Strategie {
	
	/**
	 * méthode typeStrategie qui sera offensive, defensive ou aleatoire en fonction de la stratégie choisie de l'étudiant.
	 * 
	 * @param etuCible
	 * @param etuAction
	 */
	public void typeStrategie(ArrayList<Etudiant> etuCible,Etudiant etuAction);
	
	/**
	 * méthode qui renvoie un String et qui est utilisée pour renvoyer le nom de la stratégie
	 * 
	 * @return
	 */
	public String nomStrat();

}