package fr.utt.LO02.VL.CestDuBrutal;

import java.util.ArrayList;

public class Aleatoire implements Strategie {

	public void typeStrategie(ArrayList<Etudiant> etuCible, Etudiant etuAction) {
		/*On choisis etucible avant d'appeler la methode typeStrategie de la classe Aléatoire lorsque etuAction à une stratégie aléatoire
		 *Ceci nous permet de choisir le type de stratégie adapté en fonction de la faction de etuCible.
		 *la faction de etuCible est choisie de manière équiprobable.
		 */

		if (etuCible.get(0).getFactionEtu()== etuAction.getFactionEtu()) {
			Strategie soigner = new Soigner();
			soigner.typeStrategie(etuCible, etuAction);

		} 
		else {
			Strategie attaquer = new Attaquer();
			attaquer.typeStrategie(etuCible, etuAction);
		}
	}
	public String nomStrat() {
		return "aléatoire";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}