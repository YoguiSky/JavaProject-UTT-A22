package fr.utt.LO02.VL.CestDuBrutal;

import java.util.ArrayList;

/**
 * Classe Soigner qui implémente l'interface stratégie
 * @author Vincent DELESTRE
 * @author Louis GALLOIS
 *
 */
public class Soigner implements Strategie {

	/**
	 * méthode typeStratégie qui s'occupe du soin comme il est defini dans le cahier des charges.
	 */
	public void typeStrategie(ArrayList<Etudiant> etuCible, Etudiant etuAction) {
		if ((etuCible.get(0) != etuAction)) {
			int x = (int) (Math.random() * 101); 
			double y = Math.random() * 0.6;

			System.out.println("etu n°" + etuAction.getNumEtudiant() + " en " + etuAction.getFactionEtu()
					+ " lance un soin sur etu n°" + etuCible.get(0).getNumEtudiant() + " en "
					+ etuCible.get(0).getFactionEtu());
			if (x >= 0 && x <= 20 + 6 * etuAction.getDexterite()) {
				System.out.println("Le soin est réussi !"); 
				int creditsECTSGagne = (int) (y * (10 + etuCible.get(0).getConstitution()));
				etuCible.get(0).setCreditsECTS(etuCible.get(0).getCreditsECTS() + creditsECTSGagne);

				if (etuCible.get(0).getCreditsECTS() > 30 + etuCible.get(0).getConstitution()) {
					etuCible.get(0).setCreditsECTS(30 + etuCible.get(0).getConstitution());

					System.out.println("etu n°" + etuCible.get(0).getNumEtudiant() + " a regagné " + creditsECTSGagne
							+ " pv, il a maintenant toute sa vie !");
				}

				else {
					System.out.println("etu n°" + etuCible.get(0).getNumEtudiant() + " a regagné " + creditsECTSGagne
							+ " crédits ECTS !");
				}
			} else {
				System.out.println("Le soin a échoué...");
			}
		} else {
			System.out.println("L'étudiant n°"+etuAction.getNumEtudiant()+" ne peut se soigner sois même !");
		}
	}

	/**
	 * méthode nomStrat de la classe Soigner qui renvoie "soigner".
	 * @return String "soigner"
	 */
	public String nomStrat() {
		return "soigner";
	}


}