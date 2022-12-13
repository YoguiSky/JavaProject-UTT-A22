package fr.utt.LO02.VL.CestDuBrutal;

import java.util.ArrayList;

public class Soigner implements Strategie {

	/**
	 * méthode Stratégie qui s'occupe du soin
	 */
	public void typeStrategie(ArrayList<Etudiant> etuCible, Etudiant etuAction) {
		System.out.println(etuCible.get(0).getInitiative()+"-"+etuCible.get(0).getFactionEtu()+"------"+etuAction.getInitiative()+"-"+etuAction.getFactionEtu());
		//if ((etuCible.get(0).getNumEtudiant() != etuAction.getNumEtudiant())&&(etuCible.get(0).getFactionEtu() == etuAction.getFactionEtu())) {
		if ((etuCible.get(0) != etuAction)) {
			int x = (int) (Math.random() * 101); // x est un nombre aléatoire compris entre 0 et 100
			double y = Math.random() * 0.6;

			System.out.println("etu n°" + etuAction.getNumEtudiant() + " en " + etuAction.getFactionEtu()
					+ " lance un soin sur etu n°" + etuCible.get(0).getNumEtudiant() + " en "
					+ etuCible.get(0).getFactionEtu());
			if (x >= 0 && x <= 20 + 6 * etuAction.getDexterite()) {
				// Le soin est réussi !
				System.out.println("Le soin est réussi !"); // Il est préférable d'informer le joueur du déroulement du
															// soin
				int creditsECTSGagne = (int) (y * (10 + etuCible.get(0).getConstitution()));

				// remplacer ça par une méthode étudiant etuCible.get(0).add() qu'il faut
				// d'abord rajouter dans la classe Etudiant
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
				// Si la première condition n'est pas respectée, le soin échoue.
				System.out.println("Le soin a échoué...");
			}
		} else {
			System.out.println("L'étudiant n°"+etuAction.getNumEtudiant()+" ne peut se soigner sois même !");
		}
	}

	public String nomStrat() {
		return "soigner";
	}

	public static void main(String[] args) {
		// Commande de test :
		double z1 = 1.2;
		double z2 = 1.7;

		int val1 = (int) z1;
		int val2 = (int) z2;

		System.out.println("z1 : " + z1 + "\nz2 :" + z2 + "\nval1 :" + val1 + "\nval2 :" + val2);

		// TODO Auto-generated method stub

	}

}