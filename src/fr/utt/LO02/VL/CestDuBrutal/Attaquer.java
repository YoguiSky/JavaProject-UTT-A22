package fr.utt.LO02.VL.CestDuBrutal;

import java.util.ArrayList;

/**
 * Classe Attaquer de notre interface Strategie
 * 
 * @author Vincent
 *
 */
public class Attaquer implements Strategie {

	/**
	 * méthode attaquer
	 */
	public static int DEGATS_REF = 10;

	public void typeStrategie(ArrayList<Etudiant> etuCible, Etudiant etuAction) {
		// System.out.println(etuAction + " attaque " + etuCible.get(0));

		// On commence par définir tous nos paramètres :
		/*
		 * System.out.println("etu n°" + etuAction.getNumEtudiant() + " faction = " + +
		 * " pv = " + etuAction.getCreditsECTS() + " initiative = " +
		 * etuAction.getInitiative() + " attaque etu n°" + + " faction = " +
		 * etuCible.get(0).getFactionEtu() + " pv = " + etuCible.get(0).getCreditsECTS()
		 * + " initiative = " + etuCible.get(0).getInitiative());
		 */
		System.out.println("etu n°" + etuAction.getNumEtudiant() + " en " + etuAction.getFactionEtu()
				+ " lance une attaque sur etu n°" + etuCible.get(0).getNumEtudiant() + " en "
				+ etuCible.get(0).getFactionEtu());
		int x = (int) (Math.random() * 101);
		// System.out.println("=========== " + x);
		if (x >= 0 && x <= (40 + (3 * etuAction.getDexterite()))) {
			System.out.println("Attaque réussie");
			int coef_degats = (int) ((10 * etuAction.getForce()) - (5 * etuCible.get(0).getResistance()));
			if (coef_degats > 100)
				coef_degats = 100;
			if (coef_degats < 0)
				coef_degats = 0;
			coef_degats /= 100;
			int degats = (int) ((Math.random() + 0.01) * (1 + coef_degats) * DEGATS_REF);
			etuCible.get(0).setCreditsECTS(etuCible.get(0).getCreditsECTS() - degats);
			System.out.println("L'Etudiant a perdu " + degats);
			if (etuCible.get(0).getCreditsECTS() <= 0) {
				System.out.println("L'étudiant n°" + etuCible.get(0).getNumEtudiant() + " est mort, il reste "
						+ (etuCible.size() - 1) + " étudiants\n");
				etuCible.get(0).setEstMort(true);
				etuCible.get(0).getLocalisation().desaffecterEtudiant(etuCible.get(0));
			}

		} else {
			System.out.println("Attaque échoue");
		}

	}

	public String nomStrat() {
		return "attaquer";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}