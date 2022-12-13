package fr.utt.LO02.VL.CestDuBrutal;

import java.util.ArrayList;

/**
 * Classe Aleatoire qui implémente l'interface Stratégie.
 * 
 * @author Vincent
 * @author Louis
 */
public class Aleatoire implements Strategie {

	/**
	 * Méthode typeStrategie de la Classe Aleatoire. L'étudiant qui fait l'action
	 * choisit une stratégie offensive ou defensive de manière aléatoire. Pour faire
	 * fonctionner notre choix d'action de manière aléatoire, on décide de choisir à
	 * l'aide d'un lancer équiprobale une des deux factions en jeu. Si la faction
	 * obtenue est la même que celle de l'étudiant qui fait l'action, alors celui-ci
	 * va choisir une stratégie défensive dans le but de soigner son coéquipier avec
	 * le moins de crédits ECTS présent sur la même zone. Dans le cas contraire,
	 * l'étudiant qui fait l'action va attaquer l'étudiant de la faction adverse
	 * avec le moins de crédits ECTS présent sur la même zone.
	 * 
	 * @param etuCible
	 * @param etuAction
	 */
	public void typeStrategie(ArrayList<Etudiant> etuCible, Etudiant etuAction) {
		/*
		 * On choisit etucible avant d'appeler la méthode typeStrategie de la classe
		 * Aleatoire lorsque etuAction a une stratégie aléatoire Ceci nous permet de
		 * choisir le type de stratégie adapté en fonction de la faction de etuCible. la
		 * faction de etuCible est choisie de manière équiprobable.
		 */

		if (etuCible.get(0).getFactionEtu() == etuAction.getFactionEtu()) {
			Strategie soigner = new Soigner();
			soigner.typeStrategie(etuCible, etuAction);

		} else {
			Strategie attaquer = new Attaquer();
			attaquer.typeStrategie(etuCible, etuAction);
		}
	}

	/**
	 * méthode nomStrat de la classe Aléatoire qui renvoie un String.
	 * 
	 * @return String "aléatoire"
	 */
	public String nomStrat() {
		return "aléatoire";
	}

}